package Middle.Filter

import Common.Image.Image.{Image, MatrixImage}
import Common.Image.Pixel.GreyPixel

case class BrightnessFilter(num: Int) extends Filter {
  override def applyFilter(image: Image[GreyPixel]): Image[GreyPixel] = {
    var image_tmp: Image[GreyPixel] = MatrixImage[GreyPixel](Array.ofDim(image.getHeight, image.getWidth))

    var i = 0
    while (i < image.getHeight) {
      var j = 0
      while (j < image.getWidth) {
        image_tmp = image_tmp.setPixel(i, j, GreyPixel(image.getPixel(i, j).getValue + num))
        j += 1
      }
      i += 1
    }
    image_tmp
  }
}
