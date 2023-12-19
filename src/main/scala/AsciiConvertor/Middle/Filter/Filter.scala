package AsciiConvertor.Middle.Filter

import AsciiConvertor.Common.Image.Image.Image
import AsciiConvertor.Common.Image.Pixel.GreyPixel


//Applies its filter to image and return converted one
trait Filter {
  def applyFilter(image : Image[GreyPixel]) : Image[GreyPixel]
}
