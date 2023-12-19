package AsciiConvertor.Middle.Convertor.Pixels

import org.scalatest.funsuite.AnyFunSuite
import AsciiConvertor.Common.Image.Pixel.{GreyPixel, Pixel, RGBPixel}

class FromRGBtoGreyConvertorTest extends AnyFunSuite {
  test("Convert RGB to Grey scale") {
    val convertor = FromRGBtoGreyConvertor()
    val input_1 = RGBPixel(0, 0, 0)
    val expect_1: Pixel = GreyPixel(0)
    assert(expect_1.equals(convertor.cconvert(input_1)))
    val input_2 = RGBPixel(255, 255, 255)
    val expect_2: Pixel = GreyPixel(255)
    assert(expect_2.equals(convertor.cconvert(input_2)))
    val input_3 = RGBPixel(128, 128, 128)
    val expect_3: Pixel = GreyPixel(128)
    assert(expect_3.equals(convertor.cconvert(input_3)))
    val input_4 = RGBPixel(100, 50, 30)
    val expect_4: Pixel = GreyPixel(62)
    assert(expect_4.equals(convertor.cconvert(input_4)))
    val input_5 = RGBPixel(45, 85, 186)
    val expect_5: Pixel = GreyPixel(84)
    assert(expect_5.equals(convertor.cconvert(input_5)))
  }
}
