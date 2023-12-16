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
      val loader = controller.getLoader
      val filters = controller.getFilters
      val convertor = controller.getConvertor
      val outputer = controller.getOutputer

      //get grey scale image
      var greyImage = loader.getGreyImage()

      //apply filters to grey scale
      for (i <- filters)
        greyImage = i.applyFilter(greyImage)






    } catch {
      case e: Exception => println(e.getMessage)
    }


  }

}
