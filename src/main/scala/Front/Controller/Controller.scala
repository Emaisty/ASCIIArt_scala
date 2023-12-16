package Front.Controller

import Front.Loader.Loader
import Back.Output
import Middle.Filter.Filter
import Middle.Convertor.Convertor

/*
  How application going to behave. Gets arguments and create loader, filters and outputers
 */
trait Controller {

  def getLoader : Loader

  def getConvertor : Convertor

  def getOutputer : Output

  def getFilters : List[Filter]
}
