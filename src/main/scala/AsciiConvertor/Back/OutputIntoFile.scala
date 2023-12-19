package AsciiConvertor.Back

import java.io.FileWriter

import AsciiConvertor.Common.Image.Image.Image

case class OutputIntoFile(file : String) extends Output[Char]{
  override def output(image: Image[Char]) = {
    val writer = new FileWriter(file)
    for (i <- 0 until image.getHeight) {
      for (j <- 0 until image.getWidth) {
        writer.write(image.getPixel(i,j))
      }
      writer.write("\n")
    }
  }
}
