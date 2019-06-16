package com.khusin

import java.sql.Timestamp

import org.apache.hadoop.classification.InterfaceAudience.Public

import scala.beans.{BeanInfo, BeanProperty}

/**
  * Created by sinchan on 15/06/19.
  */
object RuleBeans {

  case class Log(mobileNo:String, log_date:Timestamp, log: String)

  @BeanInfo
  case class LogStruct(log_date:Timestamp, log: String)
  case class LogWrapper(mobileNo:String,logs:Seq[LogStruct])
  case class Event(mobileNo:String,mailId:String)

  @BeanInfo
  case class ActionCoord(mobileNo:String,sms:String,smsDetail:String)

  @BeanInfo
  case class NewAction(var sms:String, var smsDetail:String)

  @BeanInfo
  case class CaseWrapper(mobileNo:String,mailId:String,logs:Seq[LogStruct] = Nil, @BeanProperty  var action: NewAction)


}
