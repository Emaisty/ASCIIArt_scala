package AsciiConvertor.Back

class OutputInConsole extends Output {
  override def output(image: Array[Array[Char]]) = {
    for (i <- image) {
      for (j <- i) {
        print(j)
      }
      print("\n")
    }
  }
}
