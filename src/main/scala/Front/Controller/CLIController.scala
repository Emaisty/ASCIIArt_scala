package Front.Controller

import Front.Controller.CLIArguments.{CLIArgument, CLIComplicatedArgument, CLISimpleArgument}
import Front.Loader.{Loader, RandLoader}
import Front.Loader.FileLoaders.{JPGFileLoader, PNGFileLoader}

import Back.{Output, OutputInConsole, OutputIntoFile}


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
        case c if (arguments.length > 2 && Set("--image", "--flip", "--brightness", "--table", "--custom-table", "--output-file").contains(c)) => {
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
    var loader: Option[Loader] = Option.empty

    for (i <- CLIArgument)
      i match {
        case already if ((already.name == "--image-random" || already.name == "--image") && loader.nonEmpty) =>
          throw new IllegalArgumentException("More than 1 input argument")
        case CLISimpleArgument("--image-random") => loader = Option(new RandLoader)
        case CLIComplicatedArgument("--image", List(s)) if s.endsWith(".png") => loader = Option(PNGFileLoader(s))
        case CLIComplicatedArgument("--image", List(s)) if s.endsWith(".jpg") => loader = Option(JPGFileLoader(s))
      }
    loader match {
      case Some(imageLoader) => imageLoader
      case None => throw new IllegalArgumentException("There is non input argument")
    }
  }

  override def getOutputer: Output = {
    var outputer: Option[Output] = Option.empty

    for (i <- CLIArgument)
      i match {
        case already if ((already.name == "--output-console" || already.name == "--output-file") && outputer.nonEmpty) =>
          throw new IllegalArgumentException("More than 1 output argument")
        case CLISimpleArgument("--output-console") => outputer = Option(new OutputInConsole)
        case CLIComplicatedArgument("--output-file", List(s)) => outputer = Option(OutputIntoFile(s))
      }
    outputer match {
      case Some(imageOutputer) => imageOutputer
      case None => throw new IllegalArgumentException("There is non output argument")
    }
  }


}
