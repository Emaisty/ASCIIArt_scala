package app.Controller.parser

import app.Controller.Argument.CLIArguments.{CLIArgument, CLIComplicatedArgument, CLISimpleArgument}

case class ParseCLIArguments(simple_command: List[String], non_simple_command: List[String]) extends Parser[Array[String], Seq[CLIArgument]] {
  override def parse(item: Array[String]): Seq[CLIArgument] = {
    val arguments = item.toBuffer
    var ret = List[CLIArgument]()
    while (arguments.nonEmpty) {
      arguments.head match {
        case s if simple_command.contains(s) => {
          ret = ret.appended(CLISimpleArgument(s))
          arguments -= arguments.head
        }
        case c if (arguments.length > 1 && non_simple_command.contains(c)) => {
          ret = ret.appended(CLIComplicatedArgument(c, List(arguments(1))))
          arguments -= arguments.head
          arguments -= arguments.head
        }
        case els => throw new IllegalArgumentException(s"Unsupported argument: ${els}")
      }
    }
    ret
  }
}
