package com.shadowjarcxfproblem.service

import com.shadowjarcxfproblem.SoapServiceFactory
import com.typesafe.scalalogging.LazyLogging
import org.tempuri.CalculatorSoap

trait CalculatorServiceComponent {
  val calculatorService: CalculatorService

  class CalculatorServiceImpl extends CalculatorService with LazyLogging {

    // PortTypes

    val calculatorSoap: CalculatorSoap = new SoapServiceFactory[CalculatorSoap](
      "http://www.dneonline.com/calculator.asmx",
      60000,
      classOf[CalculatorSoap]).create

    // Outgoing calls

    override def add(a: Int, b: Int): Int = {
      calculatorSoap.add(6, 7)
    }

  }
}

trait CalculatorService {

  def add(a: Int, b: Int): Int

}


