package AsciiConvertor.Middle.Convertor.Pixels

import AsciiConvertor.Common.Image.Pixel.{RGBPixel, GreyPixel}

case class FromRGBtoGreyConvertor() extends PixelsConvert [RGBPixel,GreyPixel]{

  override def cconvert(pixel: RGBPixel): GreyPixel = {
    GreyPixel((((0.3 * pixel.red) + (0.59 * pixel.green) + (0.11 * pixel.blue)) +0.00001).toInt)
  }
}
