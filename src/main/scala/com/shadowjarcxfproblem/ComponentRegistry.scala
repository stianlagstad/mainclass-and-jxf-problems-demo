package com.shadowjarcxfproblem

import com.shadowjarcxfproblem.controller.MyController
import com.shadowjarcxfproblem.service.{CalculatorService, CalculatorServiceComponent}

object ComponentRegistry
  extends MyController
    with CalculatorServiceComponent
{
  lazy val myController = new MyController
  lazy val calculatorService: CalculatorService = new CalculatorServiceImpl
}
