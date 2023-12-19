package AsciiConvertor.Middle.Convertor.Table

import AsciiConvertor.Common.Image.Image.{Image, MatrixImage}
import AsciiConvertor.Common.Image.Pixel.GreyPixel


//Convert Image from GreyScale to Ascii one by its table
trait Convertor {
  def table: String

  def convert(image: Image[GreyPixel]): Image[Char] = {
    var ascii_img: Image[Char] = MatrixImage[Char](Array.ofDim(image.getHeight, image.getWidth))
    var i = 0
    while (i < image.getHeight) {
      var j = 0
      while (j < image.getWidth) {
        ascii_img = ascii_img.setPixel(i, j, table(((image.getPixel(i, j).getValue.toDouble / 256) * table.length).toInt))
        j += 1
      }

      i += 1
    }
    ascii_img
  }

}
