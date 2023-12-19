package AsciiConvertor.Back

import AsciiConvertor.Common.Image.Image.{Image, MatrixImage}
import org.scalatest.funsuite.AnyFunSuite

import java.io.File
import scala.io.Source

class OutputIntoFileTest extends AnyFunSuite {
  test("output into file") {
    val outputer = OutputIntoFile("tmp.txt")

    val image = MatrixImage[Char](Array(
      Array('@', '@', '@'),
      Array('@', '+', '@'),
      Array('+', '+', '+')))

    outputer.output(image)

    val file1 = new File("tmp.txt")
    val file2 = new File("resources/tests/output/test.txt")

    val imageBuffer_1 = Source.fromFile(file1)
    val imageBuffer_2 = Source.fromFile(file2)

    assert(imageBuffer_1.toString == imageBuffer_2.toString)
    file1.delete()
  }
}
