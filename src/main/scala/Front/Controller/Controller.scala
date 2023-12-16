package Front.Controller

import Front.Loader.Loader
import Back.Output

/*
  How application going to behave. Gets arguments and create loader, filters and outputers
 */
trait Controller {

  def getLoader : Loader

  def getOutputer : Output

  def getFilters
}
