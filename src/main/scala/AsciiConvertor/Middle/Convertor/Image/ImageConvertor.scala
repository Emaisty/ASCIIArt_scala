package AsciiConvertor.Middle.Convertor.Image

import AsciiConvertor.Common.Image.Image.Image


// convert image of one type to another
trait ImageConvertor[V,T] {
  def convert(image : Image[V]) : Image[T]
}

