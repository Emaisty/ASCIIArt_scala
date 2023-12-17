package AsciiConvertor.Common.Image.Pixel

trait Pixel {
  def getValue : Int

  def equals(obj: Pixel): Boolean = {
    getValue == obj.getValue
  }

}
