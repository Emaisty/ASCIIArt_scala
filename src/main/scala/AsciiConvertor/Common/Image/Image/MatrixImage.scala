package AsciiConvertor.Common.Image.Image

/*
  Classic matrix image
 */
case class MatrixImage [V](private val image: Array[Array[V]]) extends Image[V] {
  private val height = image.length
  private val width = if(height > 0) image(0).length else 0
  override def getPixel(y: Int, x: Int): V = {
    if (!(validHeight(y) && validWidth(x)))
      throw new IllegalArgumentException("Not valid coordinates")
    image(y)(x)
  }

  override def setPixel(y: Int, x: Int, pixel: V): MatrixImage[V] = {
    if (!(validHeight(y) && validWidth(x)))
      throw new IllegalArgumentException("Not valid coordinates")
    image(y)(x) = pixel
    MatrixImage[V](image)
  }

  def validHeight(y : Int) : Boolean= {
    y >= 0 && y < height
  }

  def validWidth(x : Int) : Boolean = {
    x >= 0 && x < width
  }

  override def getWidth: Int = width

  override def getHeight: Int = height




}
