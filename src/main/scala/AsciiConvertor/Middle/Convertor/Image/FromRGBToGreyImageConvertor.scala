package AsciiConvertor.Middle.Convertor.Image

import AsciiConvertor.Common.Image.Image.{Image, MatrixImage}
import AsciiConvertor.Common.Image.Pixel.{GreyPixel, RGBPixel}
import AsciiConvertor.Middle.Convertor.Pixels.{FromRGBtoGreyConvertor, PixelsConvert}

case class FromRGBToGreyImageConvertor() extends ImageConvertor [RGBPixel,GreyPixel]{
  override def convert(image: Image[RGBPixel]): Image[GreyPixel] = {
    var res: Image[GreyPixel] = MatrixImage[GreyPixel](Array.ofDim(image.getHeight, image.getWidth))
    var i = 0
    val conv : PixelsConvert[RGBPixel,GreyPixel] = FromRGBtoGreyConvertor()
    while (i < image.getHeight) {
      var j = 0
      while (j < image.getWidth) {
        res = res.setPixel(i, j, conv.cconvert(image.getPixel(i,j)))
        j += 1
      }
      i += 1
    }
    res
  }
}
