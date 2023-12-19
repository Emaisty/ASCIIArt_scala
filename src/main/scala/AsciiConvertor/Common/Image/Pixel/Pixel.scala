package AsciiConvertor.Common.Image.Pixel

/*
  Pixel of Image
 */
trait Pixel {
  def getValue : Int

  def equals(obj: Pixel): Boolean = {
    getValue == obj.getValue
  }

}
