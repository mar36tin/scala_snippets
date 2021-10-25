ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "2.13.6"
ThisBuild / organization := "com.icicle"

val scalaTest = "org.scalatest" %% "scalatest" % "3.2.9"
val gigahorse = "com.eed3si9n" %% "gigahorse-okhttp" % "0.5.0"
val playJson = "com.typesafe.play" %% "play-json" % "2.9.2"

lazy val commonSettings = Seq{
  target := { baseDirectory.value / "target2" }
  libraryDependencies ++= Seq(
    gigahorse,
    playJson,
    scalaTest % Test,
  )
}

lazy val snip = taskKey[Unit]("Offers a desc of the project")

lazy val root = (project in file("."))
  .aggregate(helloCore, basicScala)
  .dependsOn(helloCore)
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "snippets",
    update / aggregate := false,
    snip := {println(
      s"""
        | ${name.value} project
        | Version: ${version.value}
        | Scala Version: ${scalaVersion.value}
        |
        |""".stripMargin)},
    libraryDependencies ++= Seq(
      scalaTest % Test,
    )
  )

lazy val helloCore = (project in file("core"))
  .settings(
    commonSettings,
    name := "Hello Core",
  )

lazy val basicScala = (project in file("basic"))
  .settings(
    commonSettings,
    name := "Basic Scala"
  )