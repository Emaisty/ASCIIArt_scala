package AsciiConvertor.Middle.Convertor.Table

import AsciiConvertor.Common.Image.Image.{Image, MatrixImage}
import AsciiConvertor.Common.Image.Pixel.GreyPixel
import org.scalatest.funsuite.AnyFunSuite

class FullLinearConvertorTest extends AnyFunSuite {

  test("Check full table convector"){
    val filter = FullLinearConvertor()
    val input: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(0)),
      Array(GreyPixel(4)),
      Array(GreyPixel(8)),
      Array(GreyPixel(40)),
      Array(GreyPixel(45)),
      Array(GreyPixel(247)),
      Array(GreyPixel(250)),
      Array(GreyPixel(255))))
    val expected: Image[Char] = MatrixImage(Array(
      Array('$'),
      Array('@'),
      Array('B'),
      Array('o'),
      Array('h'),
      Array('\''),
      Array('.'),
      Array(' ')))
    val result = filter.convert(input)
    assert(result.equals(expected))
  }
}
