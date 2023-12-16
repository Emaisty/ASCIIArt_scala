package Middle.Filter
import Common.Image.Image.{Image, MatrixImage}
import Common.Image.Pixel.GreyPixel

case class InvertFilter() extends Filter {
  override def applyFilter(image: Image[GreyPixel]): Image[GreyPixel] = {
    var image_tmp: Image[GreyPixel] = MatrixImage[GreyPixel](Array.ofDim(image.getWidth,image.getHeight))

    var i = 0
    while (i < image.getHeight) {
      var j = 0
      while (j < image.getWidth) {
        image_tmp = image_tmp.setPixel(j,i,image.getPixel(i,j))
        j+= 1
      }
      i += 1
    }
    image_tmp
  }
}
