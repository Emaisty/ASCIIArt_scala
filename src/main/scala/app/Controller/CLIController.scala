package app.Controller

import AsciiConvertor.Back.{Output, OutputInConsole, OutputIntoFile}
import AsciiConvertor.Front.FileLoaders.{JPGFileLoader, PNGFileLoader}
import AsciiConvertor.Front.{Loader, RandLoader}
import AsciiConvertor.Middle.Convertor.Table.{Convertor, FullLinearConvertor, NonLinearConvertor, ShortLinearConvertor, UserConvertor}
import AsciiConvertor.Middle.Filter.{BrightnessFilter, Filter, FlipXFilter, FlipYFilter, InvertFilter}
import app.Controller.CLIArguments.{CLIArgument, CLIComplicatedArgument, CLISimpleArgument}


class CLIController(args: Array[String]) extends Controller {
  private val CLIArgument = parseArgs()

  def parseArgs(): List[CLIArgument] = {
    val arguments = args.toBuffer
    var ret = List[CLIArgument]()
    while (arguments.nonEmpty) {
      arguments.head match {
        case s if Set("--image-random", "--invert", "--output-console").contains(s) => {
          ret = ret.appended(CLISimpleArgument(s))
          arguments -= arguments.head
        }
        case c if (arguments.length > 1 && Set("--image", "--flip", "--brightness", "--table", "--custom-table", "--output-file").contains(c)) => {
          ret = ret.appended(CLIComplicatedArgument(c, List(arguments(1))))
          arguments -= arguments.head
          arguments -= arguments.head
        }
        case els => throw new IllegalArgumentException(s"Unsupported argument: ${els}")
      }
    }
    ret
  }

  override def getLoader: Loader = {
    // Set how image going to be input
    var loader: Option[Loader] = Option.empty

    for (i <- CLIArgument)
      i match {
        case already if ((already.name == "--image-random" || already.name == "--image") && loader.nonEmpty) =>
          throw new IllegalArgumentException("More than 1 input argument")
        case CLISimpleArgument("--image-random") => loader = Option(RandLoader())
        case CLIComplicatedArgument("--image", List(s)) if s.endsWith(".png") => loader = Option(PNGFileLoader(s))
        case CLIComplicatedArgument("--image", List(s)) if s.endsWith(".jpg") => loader = Option(JPGFileLoader(s))
        case CLIComplicatedArgument("--image", List(s)) if (!s.endsWith(".jpg") || !s.endsWith(".png"))  =>
          throw new IllegalArgumentException("Unsupported file extension")
        case _ =>
      }

    loader match {
      case Some(imageLoader) => imageLoader
      case None => throw new IllegalArgumentException("There is non input argument")
    }
  }

  override def getFilters: Seq[Filter] = {
    var ret = Seq[Filter]()

    for (i <- CLIArgument) {
      i match {
        case CLISimpleArgument("--invert") => ret = ret.appended(InvertFilter())
        case CLIComplicatedArgument("--flip",List("x")) =>ret =  ret.appended(FlipXFilter())
        case CLIComplicatedArgument("--flip",List("y")) => ret = ret.appended(FlipYFilter())
        case CLIComplicatedArgument("--brightness",List(s)) => ret = ret.appended(BrightnessFilter(s.toInt))
        case _ =>
      }
    }
    ret
  }

  override def getConvertor: Convertor = {
    // Set to loader its convert table
    var table: Option[Convertor] = Option.empty
    for (i <- CLIArgument)
      i match {
        case already if ((already.name == "--table" || already.name == "--custom-table") && table.nonEmpty) =>
          throw new IllegalArgumentException("More than 1 table argument")
        case CLIComplicatedArgument("--table", List("short")) => table = Option(ShortLinearConvertor())
        case CLIComplicatedArgument("--table", List("full")) => table = Option(FullLinearConvertor())
        case CLIComplicatedArgument("--table", List("non-linear")) => table = Option(NonLinearConvertor())
        case CLIComplicatedArgument("--table", _) => throw new IllegalArgumentException("Unknown name of a table")
        case CLIComplicatedArgument("--custom-table", List(s)) if (s.nonEmpty && s.length <= 256) =>
          table = Option(UserConvertor(s))
        case _ =>
      }

    table match {
      case Some(convertor) => convertor
      case None => ShortLinearConvertor()
    }
  }

  override def getOutputer: Seq[Output[Char]] = {
    var outputers = Seq[Output[Char]]()

    for (i <- CLIArgument) {
      i match {
        case CLISimpleArgument("--output-console") => outputers = outputers.appended(OutputInConsole())
        case CLIComplicatedArgument("--output-file", List(s)) => outputers = outputers.appended(OutputIntoFile(s))
        case _ =>
      }
    }

    if (outputers.isEmpty)
      throw new IllegalArgumentException("There is non output argument")
      outputers

  }


}
