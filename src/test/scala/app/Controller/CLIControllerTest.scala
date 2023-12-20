package app.Controller

import org.scalatest.funsuite.AnyFunSuite
import AsciiConvertor.Front.RandLoader
import AsciiConvertor.Front.FileLoaders.{JPGFileLoader, PNGFileLoader}
import AsciiConvertor.Middle.Convertor.Table.{FullLinearConvertor, NonLinearConvertor, ShortLinearConvertor, UserConvertor}
import AsciiConvertor.Middle.Filter.{BrightnessFilter, FlipXFilter, FlipYFilter, InvertFilter}
import AsciiConvertor.Back.{OutputInConsole, OutputIntoFile}

class CLIControllerTest extends AnyFunSuite {
//  test("Wrong argument") {
//    assertThrows[IllegalArgumentException] {
//      val controller = new CLIController(Array("--lol", ""))
//      controller.parseArgs()
//    }
//  }

  test("Input file jpg") {
    val controller = new CLIController(Array("--image", "resources/tests/input/dog.jpg"))
    controller.fullFillValues
    assert(controller.getLoader match {
      case JPGFileLoader("resources/tests/input/dog.jpg") => true
      case _ => false
    })
  }

  test("Input file png") {
    val controller = new CLIController(Array("--image", "resources/tests/input/dog.png"))
    controller.fullFillValues

    assert(controller.getLoader match {
      case PNGFileLoader("resources/tests/input/dog.png") => true
      case _ => false
    })
  }

  test("Input random") {
    val controller = new CLIController(Array("--image-random"))
    controller.fullFillValues
    assert(controller.getLoader match {
      case RandLoader() => true
      case _ => false
    })
  }

  test("Double input") {
    val controller = new CLIController(Array("--image", "resources/tests/input/dog.jpg","--image-random"))


    assertThrows[IllegalArgumentException] {
      controller.fullFillValues
    }
  }

  test("correct full table") {
    val controller = new CLIController(Array("--table", "full"))
    controller.fullFillValues

    assert(controller.getConvertor match {
      case FullLinearConvertor() => true
      case _ => false
    })
  }


  test("correct short table") {
    val controller = new CLIController(Array())
    controller.fullFillValues

    assert(controller.getConvertor match {
      case ShortLinearConvertor() => true
      case _ => false
    })
  }


  test("correct non-linear table") {
    val controller = new CLIController(Array("--table", "non-linear"))
    controller.fullFillValues

    assert(controller.getConvertor match {
      case NonLinearConvertor() => true
      case _ => false
    })
  }


  test("correct user table") {
    val controller = new CLIController(Array("--custom-table", ".&*()"))
    controller.fullFillValues

    assert(controller.getConvertor match {
      case UserConvertor(".&*()") => true
      case _ => false
    })
  }

  test("Filters") {
    val controller = new CLIController(Array("--flip","x","--flip","y","--brightness","12","--invert"))
    controller.fullFillValues

    assert(controller.getFilters match {
      case Seq(FlipXFilter(),FlipYFilter(),BrightnessFilter(12),InvertFilter()) => true
      case _ => false
    })
  }

  test("Output Console") {
    val controller = new CLIController(Array("--output-console"))
    controller.fullFillValues

    assert(controller.getOutputer match {
      case Seq(OutputInConsole()) => true
      case _ => false
    })
  }

  test("Output into file") {
    val controller = new CLIController(Array("--output-file","tmp.txt"))
    controller.fullFillValues

    assert(controller.getOutputer match {
      case Seq(OutputIntoFile("tmp.txt")) => true
      case _ => false
    })
  }

  test("Double output") {
    val controller = new CLIController(Array("--output-file","tmp.txt","--output-console"))
    controller.fullFillValues

    assert(controller.getOutputer match {
      case Seq(OutputIntoFile("tmp.txt"),OutputInConsole()) => true
      case _ => false
    })
  }

}
