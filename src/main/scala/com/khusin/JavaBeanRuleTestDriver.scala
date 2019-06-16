package com.khusin

import java.util

import org.apache.spark.sql.SparkSession


/**
  * Created by sinchan on 08/09/17.
  */
object JavaBeanRuleTestDriver{

  def main(args: Array[String]): Unit = {
    val rules = DroolsUtil.loadRules()

    val spark = SparkSession.builder().appName("Spark-drools-javabeans").getOrCreate()
    val broadCastRules = spark.sparkContext.broadcast(rules)
    val garage = new Garage
    garage.setName("testName")

    val inputData  = Seq(garage)

    val inputrdd = spark.sparkContext.parallelize(inputData)

    val actionRdd = inputrdd.map(currGarage => DroolsUtil.applyRules(broadCastRules.value,currGarage)).map(gar => gar.getAction)

    val actionDf = spark.createDataFrame(actionRdd,classOf[Action])

    actionDf.show()
  }


}
