package com.khusin

import java.sql.Timestamp

import com.khusin.RuleBeans._
import org.apache.spark.sql.SparkSession

import scala.beans.{BeanInfo, BeanProperty}

/**
  * Created by sinchan on 11/09/17.
  */
object ScalaBeanRuleTestDriver {

  def main(args: Array[String]): Unit = {
    val rules = DroolsUtil.loadRules()

    val spark = SparkSession.builder().appName("Spark-drools").getOrCreate()
    import spark.implicits._

    val broadCastRules = spark.sparkContext.broadcast(rules)

    val dummyAction = List(ActionCoord("90876546","No",""))
    val dummyActionDs = spark.createDataset(dummyAction)
    dummyActionDs.createOrReplaceTempView("actionCoord")

    val eventData = List(Event("90876546","sb@vc.com"))
    val eventDs = spark.createDataset(eventData)
    eventDs.createOrReplaceTempView("event")
    val inputData = List(Log("90876546",Timestamp.valueOf("2017-05-30 15:00:10.5"),"INFO: hello"),Log("90876546",Timestamp.valueOf("2017-05-30 11:10:10.5"),"INFO: bolo"))

    val logsDf = spark.createDataset(inputData)
    logsDf.createOrReplaceTempView("LogTable")
    val resultDf = spark.sql("select mobileNo,collect_list(struct(log_date,log)) logs  from LogTable Group By mobileNo")
    val logWrapper = resultDf.as[LogWrapper]
    logWrapper.show()

    logWrapper.createOrReplaceTempView("logWrap")

    val casedf = spark.sql("select event.mobileNo,event.mailId,logWrap.logs FROM event JOIN logWrap ON event.mobileNo = logWrap.mobileNo")
    casedf.createOrReplaceTempView("casedf")

    val caseWrap = spark.sql("select casedf.mobileNo,casedf.mailId,casedf.logs,struct(actionCoord.sms,actionCoord.smsDetail) action FROM casedf JOIN actionCoord ON casedf.mobileNo = actionCoord.mobileNo")

    val caseDs = caseWrap.as[CaseWrapper]
    caseDs.show()

    val actionDS = caseDs.map(currWrapper => DroolsUtil.applyRulesForBundle(broadCastRules.value,currWrapper)).map(resultWrapper => resultWrapper.action)

    actionDS.show()
  }



}
