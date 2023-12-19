package AsciiConvertor.Back

import AsciiConvertor.Common.Image.Image.Image

/*
  outputer Image of type V. send to print it
 */
trait Output[V] {
  // print Image
  def output(image : Image[V])
}
