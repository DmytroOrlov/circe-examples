import sbt._

object Dependencies {

  object Versions {
    val circe = "0.11.1"
  }

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.7"
  lazy val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.14.0"
}
