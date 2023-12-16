package Middle.Convertor

import Common.Image.Image.Image
import Common.Image.Pixel.GreyPixel

trait Convertor {
  def table: String

  def convert(image: Image[GreyPixel]): Array[Array[Char]] = {
    var ascii_img = Array.ofDim[Char](image.getHeight, image.getWidth)
    var i = 0
    while (i < image.getHeight) {
      var j = 0
      while (j < image.getWidth) {
        ascii_img(i)(j) = table(((image.getPixel(i,j).getValue.toDouble/256)*table.length).toInt)
        j += 1
      }

      i += 1
    }
    ascii_img
  }

}
