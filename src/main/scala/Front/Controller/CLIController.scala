package Front.Controller

import Front.Controller.CLIArguments.{CLIArgument, CLIComplicatedArgument, CLISimpleArgument}
import Front.Loader.Loader

class CLIController(args: Array[String]) extends Controller {
  private val CLIArgument = parseArgs()

  def parseArgs(): List[CLIArgument] = {
    var ret = List[CLIArgument]()
    var i = 0
    while (i < args.length) {
      args(i) match {
        case s if Set("--image-random", "--invert", "--output-console").contains(s) => {
          ret = ret.appended(CLISimpleArgument(s))
          i += 1
        }
        case c if (!(i + 1 >= args.length) && Set("--image", "--flip", "--brightness", "--table", "--custom-table", "--output-file").contains(c)) => {
          ret = ret.appended(CLIComplicatedArgument(c, List(args(i + 1))))
          i += 2
        }
        case els => throw new IllegalArgumentException(s"Unsupported argument: ${els}")
      }
    }
    ret
  }

  override def getLoader: Loader = {
    var loader: Option[Loader] = Option.empty



    loader match {
      case Some(res) => res
      case None => throw new IllegalArgumentException("non input provided")
    }
  }


}
