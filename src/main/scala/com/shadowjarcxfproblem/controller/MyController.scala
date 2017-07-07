package com.shadowjarcxfproblem.controller

import com.shadowjarcxfproblem.service.CalculatorServiceComponent
import com.typesafe.scalalogging.LazyLogging
import org.scalatra.{Ok, ScalatraServlet}

trait MyController {
  this: CalculatorServiceComponent =>

  val myController: MyController

  class MyController() extends ScalatraServlet with LazyLogging {

    get("/") {
      Ok(calculatorService.add(42, 42))
    }

  }
}