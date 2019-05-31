package example

import scalaz.zio.App
import scalaz.zio.console._

object Hello extends Greeting with App {
  def run(args: List[String]) = app

  val program =
    for {
      _ <- putStrLn("Hello! What is your name?")
      n <- getStrLn
      _ <- putStrLn(greeting + ", " + n)
    } yield ()

  val app = program.either.map(_.fold(_ => 1, _ => 0))
}

trait Greeting {
  def greeting: String = "Hello"
}
