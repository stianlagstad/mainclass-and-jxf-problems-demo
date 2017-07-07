package com.shadowjarcxfproblem

import com.typesafe.scalalogging.LazyLogging
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.{DefaultServlet, ServletContextHandler}
import org.scalatra.servlet.ScalatraListener

object JettyLauncher extends LazyLogging {

  def main(args: Array[String]): Unit = {

    val app_port = 4242
    val startMillis = System.currentTimeMillis()
    val servletContext = new ServletContextHandler
    servletContext.setContextPath("/")

    servletContext.addEventListener(new ScalatraListener)
    servletContext.addServlet(classOf[DefaultServlet], "/")
    servletContext.setInitParameter("org.eclipse.jetty.servlet.Default.dirAllowed", "false")

    val server = new Server(app_port)
    server.setHandler(servletContext)
    logger.info("Starting server")
    server.start()

    val startTime = System.currentTimeMillis() - startMillis
    logger.info("Started at port '" + app_port + "' in '" + startTime + "' ms.")

    server.join()
  }
}
