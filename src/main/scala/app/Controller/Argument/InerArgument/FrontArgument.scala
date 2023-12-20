package app.Controller.Argument.InerArgument

import AsciiConvertor.Front.Loader
import app.Controller.Argument.CLIArguments.CLIArgument

case class FrontArgument(conver: (CLIArgument) => Loader) extends Argument