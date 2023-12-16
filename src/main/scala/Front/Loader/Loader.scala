package Front.Loader

import Common.Image.Image.{Image, MatrixImage}
import Common.Image.Pixel.{GreyPixel, Pixel}
import Middle.Convertor.Convertor

trait Loader {

  val image = loadImage()

  def loadImage(): Image[Pixel]

  def getGreyImage(): Image[Pixel] = {
    var image_tmp: Image[Pixel] = MatrixImage[Pixel](Array.ofDim(image.getHeight, image.getWidth))
    var i = 0
    while (i < image.getHeight) {
      var j = 0
      while (j < image.getWidth) {
        image_tmp = image_tmp.setPixel(i, j, GreyPixel(image.getPixel(i, j).getValue))
        j += 1
      }
      i += 1
    }
    image_tmp
  }

}
