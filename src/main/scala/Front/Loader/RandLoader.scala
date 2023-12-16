package Front.Loader

import Common.Image.Image.{Image, MatrixImage}
import Common.Image.Pixel.{Pixel, RGBPixel,GreyPixel}



import scala.util.Random
import scala.math.abs


class RandLoader extends Loader {

  override def loadImage(): Image[Pixel] = {
    val width = abs(Random.nextInt()) % 100
    val height = abs(Random.nextInt()) % 70
    var image_tmp: Image[Pixel] = MatrixImage[Pixel](Array.ofDim(height, width))
    var i = 0
    while( i < height){
      var j = 0
      while (j < width){
        image_tmp = image_tmp.setPixel(i,j,getRandomPixel())
        j+=1
      }
      i+=1
    }
    image_tmp
  }

  private def getRandomPixel(): RGBPixel = {
    val red = Random.nextInt(256)
    val green = Random.nextInt(256)
    val blue = Random.nextInt(256)
    RGBPixel(red, green, blue)
  }

}
