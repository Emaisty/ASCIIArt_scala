package AsciiConvertor.Middle.Filter

import AsciiConvertor.Common.Image.Image.{Image, MatrixImage}
import AsciiConvertor.Common.Image.Pixel.GreyPixel
import org.scalatest.funsuite.AnyFunSuite

class InvertFilterTest extends AnyFunSuite {
  test("Invert"){
    val filter = InvertFilter()
    val input: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(128), GreyPixel(1), GreyPixel(2)),
      Array(GreyPixel(3), GreyPixel(255), GreyPixel(255)),
      Array(GreyPixel(6), GreyPixel(7), GreyPixel(8))))
    val expected: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(255-128), GreyPixel(255-1), GreyPixel(255-2)),
      Array(GreyPixel(255-3), GreyPixel(255-255), GreyPixel(255-255)),
      Array(GreyPixel(255-6), GreyPixel(255-7), GreyPixel(255-8))))
    val result = filter.applyFilter(input)
    assert(result.equals(expected))
  }
}
