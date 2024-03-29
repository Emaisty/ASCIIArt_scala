package AsciiConvertor.Middle.Filter

import AsciiConvertor.Common.Image.Image.{Image, MatrixImage}
import AsciiConvertor.Common.Image.Pixel.GreyPixel

case class FlipXFilter() extends Filter {
  override def applyFilter(image: Image[GreyPixel]): Image[GreyPixel] = {
    var image_tmp: Image[GreyPixel] = MatrixImage[GreyPixel](Array.ofDim(image.getHeight, image.getWidth))

    var i = 0
    while (i < image.getHeight) {
      var j = 0
      var invers_j = image.getWidth - 1
      while (j < image.getWidth) {
        image_tmp = image_tmp.setPixel(i, invers_j, image.getPixel(i, j))
        j += 1
        invers_j -= 1
      }
      i += 1
    }
    image_tmp
  }
}
