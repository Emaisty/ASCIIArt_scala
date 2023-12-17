package AsciiConvertor.Middle.Filter

import AsciiConvertor.Common.Image.Image.{Image, MatrixImage}
import AsciiConvertor.Common.Image.Pixel.GreyPixel
import org.scalatest.funsuite.AnyFunSuite

class FlipYFilterTest extends AnyFunSuite {

  test("Flip y with odd rows"){
    val filter = new FlipYFilter()
    val input: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(0), GreyPixel(1), GreyPixel(2)),
      Array(GreyPixel(3), GreyPixel(4), GreyPixel(5)),
      Array(GreyPixel(6), GreyPixel(7), GreyPixel(8))))
    val expected: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(6), GreyPixel(7), GreyPixel(8)),
      Array(GreyPixel(3), GreyPixel(4), GreyPixel(5)),
      Array(GreyPixel(0), GreyPixel(1), GreyPixel(2))))
    val result = filter.applyFilter(input)
    assert(result.equals(expected))
  }

  test("Flip y with even columns"){
    val filter = new FlipYFilter()
    val input: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(0), GreyPixel(1), GreyPixel(2),GreyPixel(2)),
      Array(GreyPixel(12), GreyPixel(16), GreyPixel(3),GreyPixel(7)),
      Array(GreyPixel(3), GreyPixel(4), GreyPixel(5),GreyPixel(2)),
      Array(GreyPixel(6), GreyPixel(7), GreyPixel(8),GreyPixel(2))))
    val expected: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(6), GreyPixel(7), GreyPixel(8),GreyPixel(2)),
      Array(GreyPixel(3), GreyPixel(4), GreyPixel(5),GreyPixel(2)),
      Array(GreyPixel(12), GreyPixel(16), GreyPixel(3),GreyPixel(7)),
      Array(GreyPixel(0), GreyPixel(1), GreyPixel(2),GreyPixel(2))))
    val result = filter.applyFilter(input)
    assert(result.equals(expected))
  }

  test("Flip y multiple times"){
    val filter = new FlipYFilter()
    val input: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(0), GreyPixel(1), GreyPixel(2)),
      Array(GreyPixel(3), GreyPixel(4), GreyPixel(5)),
      Array(GreyPixel(6), GreyPixel(7), GreyPixel(8))))
    val expected_after_3: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(6), GreyPixel(7), GreyPixel(8)),
      Array(GreyPixel(3), GreyPixel(4), GreyPixel(5)),
      Array(GreyPixel(0), GreyPixel(1), GreyPixel(2))))
    val result2 = filter.applyFilter(filter.applyFilter(input))
    val result3 = filter.applyFilter(filter.applyFilter(filter.applyFilter(input)))
    assert(result2.equals(input))
    assert(result3.equals(expected_after_3))
  }

}
