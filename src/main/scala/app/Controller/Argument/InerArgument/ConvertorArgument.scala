package app.Controller.Argument.InerArgument

import app.Controller.Argument.CLIArguments.CLIArgument
import AsciiConvertor.Middle.Convertor.Table.Convertor

case class ConvertorArgument(conver: (CLIArgument) => Convertor) extends Argument