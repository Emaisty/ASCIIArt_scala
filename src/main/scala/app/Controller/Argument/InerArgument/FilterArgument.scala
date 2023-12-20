package app.Controller.Argument.InerArgument

import AsciiConvertor.Middle.Filter.Filter
import app.Controller.Argument.CLIArguments.CLIArgument

case class FilterArgument(conver: (CLIArgument) => Filter) extends Argument