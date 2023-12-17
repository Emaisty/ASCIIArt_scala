package AsciiConvertor.Middle.Filter

import AsciiConvertor.Common.Image.Image.Image
import AsciiConvertor.Common.Image.Pixel.GreyPixel

trait Filter {
  def applyFilter(image : Image[GreyPixel]) : Image[GreyPixel]
}
