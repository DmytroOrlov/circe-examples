import Dependencies._

lazy val zioVersion = "1.0-RC4"

lazy val `circe-examples` = (project in file("."))
  .settings(
    inThisBuild(List(
      scalaVersion := "2.12.8",
      version := "0.1.0-SNAPSHOT",
      organization := "com.github.DmytroOrlov"
    )),
    addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.10"),
    addCompilerPlugin(("org.scalameta" % "paradise" % "3.0.0-M11").cross(CrossVersion.full)),
    libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-zio" % zioVersion,
      "org.scalaz" %% "scalaz-zio-interop-cats" % zioVersion,
      "io.monix" %% "monix" % "3.0.0-RC2",
      "org.typelevel" %% "cats-core" % "1.6.0",
      "org.typelevel" %% "cats-mtl-core" % "0.5.0",
      "org.typelevel" %% "cats-tagless-macros" % "0.2.0",
      scalaTest % Test,
      scalaCheck % Test
    ) ++ List(
      "io.circe" %% "circe-core",
      "io.circe" %% "circe-generic",
      "io.circe" %% "circe-parser",
      "io.circe" %% "circe-generic-extras"
    ).map(_ % Versions.circe),
    scalacOptions += "-Ypartial-unification"
  )
