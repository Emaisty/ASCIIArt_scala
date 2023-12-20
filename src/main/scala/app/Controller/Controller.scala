package app.Controller

import AsciiConvertor.Back.Output
import AsciiConvertor.Front.Loader
import AsciiConvertor.Middle.Convertor.Table.{Convertor, ShortLinearConvertor}
import AsciiConvertor.Middle.Filter.Filter
import app.Controller.Argument.InerArgument.Argument

/*
  How application going to behave. Gets arguments and create loader, filters and outputers
 */
trait Controller {

  var loader: Option[Loader]

  var convertor: Option[Convertor]

  var outputers: Seq[Output[Char]]

  var filters: Seq[Filter]

  case class ArgumentProperties(operands: Int, typ: Argument)

  val AllArguments: Map[String, ArgumentProperties]

  def getLoader: Loader = loader match {
    case Some(value) => value
    case None => throw new IllegalArgumentException("There is non input argument")
  }

  def getConvertor: Convertor = convertor match {
    case Some(convertor) => convertor
    case None => ShortLinearConvertor()
  }

  def getOutputer: Seq[Output[Char]] = outputers match {
    case Seq(first, _@_*) => outputers
    case Seq() => throw new IllegalArgumentException("There is non output argument")
  }

  def getFilters: Seq[Filter] = filters

  def fullFillValues
}
