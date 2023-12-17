package AsciiConvertor.Common.Image.Image

trait Image [V]{

  def getPixel(y : Int, x : Int) : V

  def setPixel(y : Int, x : Int, pixel : V) : Image[V]

  def getHeight : Int

  def getWidth : Int
}
