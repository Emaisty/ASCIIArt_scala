package AsciiConvertor.Middle.Convertor.Pixels


//Convert Pixels from one type to another
trait PixelsConvert[V,T] {
  def cconvert(pixel :V) : T
}
