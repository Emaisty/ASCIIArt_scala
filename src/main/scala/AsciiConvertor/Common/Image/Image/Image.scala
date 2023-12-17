package AsciiConvertor.Common.Image.Image

trait Image [V]{

  def getPixel(y : Int, x : Int) : V

  def setPixel(y : Int, x : Int, pixel : V) : Image[V]

  def getHeight : Int

  def getWidth : Int

  def equals(obj: Image[V]): Boolean = {
    if (getWidth != obj.getWidth || getHeight != obj.getWidth)
      false
    var flag = true
    for (i <- 0 until getHeight)
      for (j <-0 until getWidth)
        flag = flag && (getPixel(i,j) == obj.getPixel(i,j))
    flag
  }
}
