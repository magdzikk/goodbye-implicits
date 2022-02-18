package org.example

import scala.concurrent.{ExecutionContext, Future}

object Example1_ProvidingContext {
  implicit val ec: ExecutionContext = ExecutionContext.global

  def main(args: Array[String]): Unit = {
    val myFuture = Future(42)
    myFuture.foreach(answer => println(answer))
  }
}
