package AsciiConvertor.Front

import AsciiConvertor.Common.Image.Image.{Image, MatrixImage}
import AsciiConvertor.Common.Image.Pixel.{GreyPixel, RGBPixel,Pixel}
import AsciiConvertor.Front.FileLoaders.JPGFileLoader
import org.scalatest.funsuite.AnyFunSuite

import java.io.IOException

class FileLoaderTest extends AnyFunSuite {
  test("Jpg and colour") {
    val loader = JPGFileLoader("resources/tests/input/4_2.jpg")

    val expected: Image[RGBPixel] = MatrixImage(Array(
      Array(RGBPixel(118, 116, 101), RGBPixel(117, 115, 100)),
      Array(RGBPixel(123, 121, 106), RGBPixel(122, 120, 105))
    ))

    val result = loader.loadImage()

    assert(result.equals(expected))
  }

  test("png and colour") {
    val loader = JPGFileLoader("resources/tests/input/4_2.png")

    val expected: Image[RGBPixel] = MatrixImage(Array(
      Array(RGBPixel(118, 116, 101), RGBPixel(117, 115, 100)),
      Array(RGBPixel(123, 121, 106), RGBPixel(122, 120, 105))
    ))

    val result = loader.loadImage()

    assert(result.equals(expected))
  }

  test("Non existed file") {
    assertThrows[IOException] {
      val loader = JPGFileLoader("resources\\WrongFilePath.png")
      loader.loadImage()
    }
  }
}
