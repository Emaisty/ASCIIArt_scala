package AsciiConvertor.Middle.Convertor.Image

import AsciiConvertor.Common.Image.Image.{Image, MatrixImage}
import AsciiConvertor.Common.Image.Pixel.{GreyPixel, Pixel, RGBPixel}
import AsciiConvertor.Front.FileLoaders.JPGFileLoader
import org.scalatest.funsuite.AnyFunSuite

class FromRGBToGreyImageConvertorTest extends AnyFunSuite {
  test("Convert RGB Image to Grey") {
    val convertor = FromRGBToGreyImageConvertor()

    val input: Image[RGBPixel] = MatrixImage(Array(
      Array(RGBPixel(0, 0, 0), RGBPixel(255, 255, 255)),
      Array(RGBPixel(100, 50, 30), RGBPixel(45, 85, 186))
    ))

    val expected: Image[GreyPixel] = MatrixImage(Array(
      Array(GreyPixel(0), GreyPixel(255)),
      Array(GreyPixel(62), GreyPixel(84))
    ))

    assert(expected.equals(convertor.convert(input)))
  }
}
