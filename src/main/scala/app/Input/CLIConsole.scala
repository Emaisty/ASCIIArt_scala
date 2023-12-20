package app.Input

import app.Controller.{CLIController, Controller}
import AsciiConvertor.Middle.Convertor.Image.{FromRGBToGreyImageConvertor, ImageConvertor}
import app.Helper.Helper

/*
  CLIConsole -- application, which runs in console with command line input
  @param args - program arguments
 */
class CLIConsole(val args: Array[String]) extends Input {


  override def loadAndRun(): Unit = {

    if (args.length == 1 && args.head == "--help") {
      new Helper
      return
    }

    try {
      val controller: Controller = new CLIController(args)
      controller.fullFillValues

      val loader = controller.getLoader
      val filters = controller.getFilters
      val convertor = controller.getConvertor
      val outputers = controller.getOutputer

      //get grey scale image
      var greyImage = FromRGBToGreyImageConvertor().convert(loader.loadImage())

      //apply filters to grey scale
      for (i <- filters)
        greyImage = i.applyFilter(greyImage)

      //Convert into ascii by table and print
      val ascii_image = convertor.convert(greyImage)

      for (i <- outputers)
        i.output(ascii_image)

    } catch {
      case e: Exception => println(e.getMessage)
    }


  }

}
