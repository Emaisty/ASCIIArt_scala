import app.Input.{CLIConsole, Input}

object Main extends App {


  val app : Input = new CLIConsole(args)

  app.loadAndRun()
}