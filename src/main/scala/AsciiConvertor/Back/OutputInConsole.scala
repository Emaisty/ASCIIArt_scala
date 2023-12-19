package AsciiConvertor.Back

import AsciiConvertor.Common.Image.Image.Image

case class OutputInConsole() extends Output[Char] {
  override def output(image: Image[Char] ) = {
    for (i <- 0 until image.getHeight) {
      for (j <- 0 until image.getWidth) {
        print(image.getPixel(i,j))
      }
      print("\n")
    }
  }
}
