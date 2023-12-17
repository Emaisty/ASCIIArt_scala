package AsciiConvertor.Middle.Filter

import org.scalatest.funsuite.AnyFunSuite

import AsciiConvertor.Common.Image.Image.{MatrixImage, Image}
import AsciiConvertor.Common.Image.Pixel.GreyPixel

class BrightnessFilterTest extends AnyFunSuite {

  test("Brightness without changes"){
    val filter = new BrightnessFilter(0)
    val input: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(0), GreyPixel(1), GreyPixel(2)),
      Array(GreyPixel(3), GreyPixel(4), GreyPixel(5)),
      Array(GreyPixel(6), GreyPixel(7), GreyPixel(8))))
    val expected: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(0), GreyPixel(1), GreyPixel(2)),
      Array(GreyPixel(3), GreyPixel(4), GreyPixel(5)),
      Array(GreyPixel(6), GreyPixel(7), GreyPixel(8))))
    val result = filter.applyFilter(input)
    assert(result.equals(expected))
  }

  test("Brightness with changes"){
    val filter = new BrightnessFilter(10)
    val input: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(0), GreyPixel(1), GreyPixel(2)),
      Array(GreyPixel(3), GreyPixel(4), GreyPixel(5)),
      Array(GreyPixel(6), GreyPixel(7), GreyPixel(8))))
    val expected: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(10), GreyPixel(11), GreyPixel(12)),
      Array(GreyPixel(13), GreyPixel(14), GreyPixel(15)),
      Array(GreyPixel(16), GreyPixel(17), GreyPixel(18))))
    val result = filter.applyFilter(input)
    assert(result.equals(expected))
  }

  test("Brightness above bound"){
    val filter = new BrightnessFilter(255)
    val input: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(1), GreyPixel(56), GreyPixel(0)),
      Array(GreyPixel(255), GreyPixel(85), GreyPixel(0))))
    val expected: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(255), GreyPixel(255), GreyPixel(255)),
      Array(GreyPixel(255), GreyPixel(255), GreyPixel(255))))
    val result = filter.applyFilter(input)
    assert(result.equals(expected))
  }
}
