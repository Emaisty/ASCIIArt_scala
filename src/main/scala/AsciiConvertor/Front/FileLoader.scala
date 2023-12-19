package AsciiConvertor.Front

import AsciiConvertor.Common.Image.Image.{Image, MatrixImage}
import AsciiConvertor.Common.Image.Pixel.{GreyPixel, Pixel, RGBPixel}


import java.io.File
import javax.imageio.ImageIO

/*
load image in format of Image[RGB] from file
 */
abstract class FileLoader(file: String) extends Loader {
  override def loadImage(): Image[RGBPixel] = {
    val ofile = new File(file)
    val imageBuffer = ImageIO.read(ofile)
    var image_tmp: Image[RGBPixel] = MatrixImage[RGBPixel](Array.ofDim(imageBuffer.getHeight, imageBuffer.getWidth))
    var i = 0
    while (i < imageBuffer.getHeight) {
      var j = 0
      while (j < imageBuffer.getWidth) {
        image_tmp = image_tmp.setPixel(i,j,RGBPixel((imageBuffer.getRGB(j, i) >> 16) & 255,(imageBuffer.getRGB(j, i) >> 8) & 255,imageBuffer.getRGB(j, i) & 255))
        j+=1
      }
      i+=1
    }
    image_tmp
  }
}
