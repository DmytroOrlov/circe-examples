import Dependencies._

lazy val `circe-examples` = (project in file("."))
  .settings(
    inThisBuild(List(
      scalaVersion := "2.12.8",
      version := "0.1.0-SNAPSHOT",
      organization := "com.github.DmytroOrlov"
    )),
    addCompilerPlugin(("org.scalameta" % "paradise" % "3.0.0-M11").cross(CrossVersion.full)),
    libraryDependencies ++= List(
      "io.circe" %% "circe-core",
      "io.circe" %% "circe-generic",
      "io.circe" %% "circe-parser",
      "io.circe" %% "circe-generic-extras"
    ).map(_ % Versions.circe),
    scalacOptions += "-Ypartial-unification"
  )
