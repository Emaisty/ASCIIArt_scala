package app.Controller

import AsciiConvertor.Back.Output
import AsciiConvertor.Front.Loader
import AsciiConvertor.Middle.Convertor.Table.Convertor
import AsciiConvertor.Middle.Filter.Filter

/*
  How application going to behave. Gets arguments and create loader, filters and outputers
 */
trait Controller {

  def getLoader: Loader

  def getConvertor: Convertor

  def getOutputer: Seq[Output[Char]]

  def getFilters: Seq[Filter]
}
