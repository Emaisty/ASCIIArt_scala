package app.Controller.Argument.InerArgument

import AsciiConvertor.Back.Output
import app.Controller.Argument.CLIArguments.CLIArgument

case class BackArgument(conver: (CLIArgument) => Output[Char]) extends Argument
