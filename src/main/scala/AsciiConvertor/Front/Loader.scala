package AsciiConvertor.Front

import AsciiConvertor.Common.Image.Image.{Image, MatrixImage}
import AsciiConvertor.Common.Image.Pixel.{GreyPixel, Pixel,RGBPixel}
import AsciiConvertor.Middle.Convertor.Table.Convertor
import AsciiConvertor.Middle.Convertor.Pixels.{FromRGBtoGreyConvertor,PixelsConvert}

// loads image from somewhere
trait Loader {

  def loadImage(): Image[RGBPixel]

}
