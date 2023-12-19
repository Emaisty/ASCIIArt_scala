package AsciiConvertor.Middle.Convertor.Table

import AsciiConvertor.Common.Image.Image.{Image, MatrixImage}
import AsciiConvertor.Common.Image.Pixel.GreyPixel
import org.scalatest.funsuite.AnyFunSuite

class ShortLinearConvertorTest extends AnyFunSuite {
  test("Check full table convector"){
    val filter = ShortLinearConvertor()
    val input: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(0)),
      Array(GreyPixel(4)),
      Array(GreyPixel(8)),
      Array(GreyPixel(40)),
      Array(GreyPixel(128)),
      Array(GreyPixel(167)),
      Array(GreyPixel(200)),
      Array(GreyPixel(255))))
    val expected: Image[Char] = MatrixImage(Array(
      Array(' '),
      Array(' '),
      Array(' '),
      Array('.'),
      Array('+'),
      Array('*'),
      Array('#'),
      Array('@')))
    val result = filter.convert(input)
    assert(result.equals(expected))
  }
}
