package AsciiConvertor.Middle.Filter

import AsciiConvertor.Common.Image.Image.{Image, MatrixImage}
import AsciiConvertor.Common.Image.Pixel.GreyPixel

case class BrightnessFilter(num: Int) extends Filter {
  override def applyFilter(image: Image[GreyPixel]): Image[GreyPixel] = {
    var image_tmp: Image[GreyPixel] = MatrixImage[GreyPixel](Array.ofDim(image.getHeight, image.getWidth))

    var i = 0
    while (i < image.getHeight) {
      var j = 0
      while (j < image.getWidth) {
        var newPixel = image.getPixel(i, j).getValue + num;
        if (newPixel > 255)
          image_tmp = image_tmp.setPixel(i, j, GreyPixel(255))
        else{
          if (newPixel < 0)
            image_tmp = image_tmp.setPixel(i, j, GreyPixel(0))
          else
            image_tmp = image_tmp.setPixel(i, j, GreyPixel(image.getPixel(i, j).getValue + num))
        }
        j += 1
      }
      i += 1
    }
    image_tmp
  }
}
