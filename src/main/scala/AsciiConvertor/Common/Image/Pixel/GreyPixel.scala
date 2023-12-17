package AsciiConvertor.Common.Image.Pixel

case class GreyPixel(spectre: Int) extends Pixel {
  if (spectre < 0 || spectre > 255) {
    throw new IllegalArgumentException("Invalid argument in Pixel constructor")
  }

    override def getValue: Int = spectre
}
