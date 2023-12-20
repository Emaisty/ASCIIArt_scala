package app.Controller

import AsciiConvertor.Back.{Output, OutputInConsole, OutputIntoFile}
import AsciiConvertor.Front.FileLoaders.{JPGFileLoader, PNGFileLoader}
import AsciiConvertor.Front.{Loader, RandLoader}
import AsciiConvertor.Middle.Convertor.Table.{Convertor, FullLinearConvertor, NonLinearConvertor, ShortLinearConvertor, UserConvertor}
import AsciiConvertor.Middle.Filter.{BrightnessFilter, Filter, FlipXFilter, FlipYFilter, InvertFilter}
import app.Controller.Argument.CLIArguments.{CLIArgument, CLIComplicatedArgument, CLISimpleArgument}
import app.Controller.Argument.InerArgument.{BackArgument, Argument, ConvertorArgument, FilterArgument, FrontArgument}
import app.Controller.parser.ParseCLIArguments


class CLIController(args: Array[String]) extends Controller {

  override var loader: Option[Loader] = Option.empty
  override var convertor: Option[Convertor] = Option.empty
  override var outputers: Seq[Output[Char]] = Seq()
  override var filters: Seq[Filter] = Seq()

  override val AllArguments: Map[String, ArgumentProperties] = Map.apply(
    "--image-random" -> ArgumentProperties(0, FrontArgument(arg => {
      RandLoader()
    })),
    "--invert" -> ArgumentProperties(0, FilterArgument(arg => {
      InvertFilter()
    })),
    "--output-console" -> ArgumentProperties(0, BackArgument(arg => {
      OutputInConsole()
    })),
    "--image" -> ArgumentProperties(1, FrontArgument({
      case CLIComplicatedArgument("--image", List(s)) if s.endsWith("png") => PNGFileLoader(s)
      case CLIComplicatedArgument("--image", List(s)) if s.endsWith("jpg") => JPGFileLoader(s)
      case _ => throw new IllegalArgumentException("Unsupported file extension")
    })),
    "--flip" -> ArgumentProperties(1, FilterArgument({
      case CLIComplicatedArgument("--flip", List("x")) => FlipXFilter()
      case CLIComplicatedArgument("--flip", List("y")) => FlipYFilter()
      case _ => throw new IllegalArgumentException("Unsupported coordinates")
    })),
    "--brightness" -> ArgumentProperties(1, FilterArgument({
      case CLIComplicatedArgument("--brightness", List(s)) => BrightnessFilter(s.toInt)
    })),
    "--table" -> ArgumentProperties(1, ConvertorArgument({
      case CLIComplicatedArgument("--table", List("short")) => ShortLinearConvertor()
      case CLIComplicatedArgument("--table", List("full")) => FullLinearConvertor()
      case CLIComplicatedArgument("--table", List("non-linear")) => NonLinearConvertor()
      case CLIComplicatedArgument("--table", _) => throw new IllegalArgumentException("Unknown name of a table")

    }))
    ,
    "--custom-table" -> ArgumentProperties(1, ConvertorArgument({
      case CLIComplicatedArgument("--custom-table", List(s)) if (s.nonEmpty && s.length <= 256) =>
        UserConvertor(s)
      case _ => throw new IllegalArgumentException("Wrong table")

    }))
    ,
    "--output-file" -> ArgumentProperties(1, BackArgument({
      case CLIComplicatedArgument("--output-file", List(s)) => OutputIntoFile(s)
    }))
  )

  val CLIArguments: Seq[CLIArgument] = giveArgs()

  def giveArgs() = {
    var simpleArguments = List[String]()
    var nonSimpleArguments = List[String]()
    for (i <- AllArguments) {

      if (i._2.operands == 1)
        nonSimpleArguments = nonSimpleArguments.appended(i._1)
      else
        simpleArguments = simpleArguments.appended(i._1)
    }
    ParseCLIArguments(simpleArguments, nonSimpleArguments).parse(args)
  }

  override def fullFillValues: Unit = {
    for (i <- CLIArguments) {
      AllArguments.get(i.name) match {
        case Some(ArgumentProperties(_, FrontArgument(c))) => {
          if (loader.nonEmpty)
            throw new IllegalArgumentException("More than 1 input argument")
          loader = Option(c(i))
        }
        case Some(ArgumentProperties(_, ConvertorArgument(c))) => {
          if (convertor.nonEmpty)
            throw new IllegalArgumentException("More than 1 input argument")
          convertor = Option(c(i))
        }
        case Some(ArgumentProperties(_, FilterArgument(c))) => {
          filters = filters.appended(c(i))
        }
        case Some(ArgumentProperties(_, BackArgument(c))) => {
          outputers = outputers.appended(c(i))
        }
      }
    }
  }


}
