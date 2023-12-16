package Front.Loader

import Common.Image.Image.{Image, MatrixImage}
import Common.Image.Pixel.{GreyPixel, Pixel, RGBPixel}


import java.io.File
import javax.imageio.ImageIO

abstract class FileLoader(file: String) extends Loader {
  override def loadImage(): Image[Pixel] = {
    val ofile = new File(file)
    val imageBuffer = ImageIO.read(ofile)
    var image_tmp: Image[Pixel] = MatrixImage[Pixel](Array.ofDim(imageBuffer.getHeight, imageBuffer.getWidth))
    var i = 0
    while (i < imageBuffer.getHeight){
      var j = 0
      while (j < imageBuffer.getWidth){
        image_tmp = image_tmp.setPixel(i,j,RGBPixel((imageBuffer.getRGB(j, i) >> 16) & 255,(imageBuffer.getRGB(j, i) >> 8) & 255,imageBuffer.getRGB(j, i) & 255))
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
