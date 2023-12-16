import Front.Input.{Input, CLIConsole}

object Main extends App {
  val app : Input = new CLIConsole(args)

  app.loadAndRun()
}