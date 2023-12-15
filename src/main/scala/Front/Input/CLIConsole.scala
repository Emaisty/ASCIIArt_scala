package Front.Input

import Front.Controller.{Controller, CLIController}

/*
  CLIConsole -- application, which runs in console with command line input
  @param args - program arguments
 */
class CLIConsole(val args: Array[String]) extends Input {


  override def loadAndRun(): Unit = {
    val controller: Controller = new CLIController(args)

    try {
      val loader

    } catch {
      case e: Exception => println(e.getMessage)
    }


  }

}
