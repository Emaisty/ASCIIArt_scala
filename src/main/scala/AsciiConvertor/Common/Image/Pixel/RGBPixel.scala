package AsciiConvertor.Common.Image.Pixel

import Math.round

case class RGBPixel(red: Int, green: Int, blue: Int) extends Pixel {
  if (!valid(red) || !valid(green) || !valid(blue))
    throw new IllegalArgumentException("Invalid Pixel ")

  private def valid(colour: Int): Boolean = {
    colour <= 255 && colour >= 0
  }

  override def getValue: Int = (red+green+blue)/3

}
