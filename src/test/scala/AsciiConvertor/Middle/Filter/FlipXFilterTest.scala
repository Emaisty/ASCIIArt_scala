package AsciiConvertor.Middle.Filter

import AsciiConvertor.Common.Image.Image.{Image, MatrixImage}
import AsciiConvertor.Common.Image.Pixel.GreyPixel
import org.scalatest.funsuite.AnyFunSuite

class FlipXFilterTest extends AnyFunSuite {
  test("Flip x with odd columns"){
    val filter = new FlipXFilter()
    val input: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(0), GreyPixel(1), GreyPixel(2)),
      Array(GreyPixel(3), GreyPixel(4), GreyPixel(5)),
      Array(GreyPixel(6), GreyPixel(7), GreyPixel(8))))
    val expected: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(2), GreyPixel(1), GreyPixel(0)),
      Array(GreyPixel(5), GreyPixel(4), GreyPixel(3)),
      Array(GreyPixel(8), GreyPixel(7), GreyPixel(6))))
    val result = filter.applyFilter(input)
    assert(result.equals(expected))
  }

  test("Flip x with even columns"){
    val filter = new FlipXFilter()
    val input: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(0), GreyPixel(1), GreyPixel(2),GreyPixel(2)),
      Array(GreyPixel(3), GreyPixel(4), GreyPixel(5),GreyPixel(2)),
      Array(GreyPixel(6), GreyPixel(7), GreyPixel(8),GreyPixel(2))))
    val expected: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(2), GreyPixel(2), GreyPixel(1),GreyPixel(0)),
      Array(GreyPixel(2), GreyPixel(5), GreyPixel(4),GreyPixel(3)),
      Array(GreyPixel(2), GreyPixel(8), GreyPixel(7),GreyPixel(6))))
    val result = filter.applyFilter(input)
    assert(result.equals(expected))
  }

  test("Flip x multiple times"){
    val filter = new FlipXFilter()
    val input: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(0), GreyPixel(1), GreyPixel(2),GreyPixel(2)),
      Array(GreyPixel(3), GreyPixel(4), GreyPixel(5),GreyPixel(2)),
      Array(GreyPixel(6), GreyPixel(7), GreyPixel(8),GreyPixel(2))))
    val expected_after_3: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(2), GreyPixel(2), GreyPixel(1),GreyPixel(0)),
      Array(GreyPixel(2), GreyPixel(5), GreyPixel(4),GreyPixel(3)),
      Array(GreyPixel(2), GreyPixel(8), GreyPixel(7),GreyPixel(6))))
    val result2 = filter.applyFilter(filter.applyFilter(input))
    val result3 = filter.applyFilter(filter.applyFilter(filter.applyFilter(input)))
    assert(result2.equals(input))
    assert(result3.equals(expected_after_3))
  }
}
