ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "2.13.6"
ThisBuild / organization := "com.icicle"

val scalaTest = "org.scalatest" %% "scalatest" % "3.2.9"
val gigahorse = "com.eed3si9n" %% "gigahorse-okhttp" % "0.5.0"
val playJson = "com.typesafe.play" %% "play-json" % "2.9.2"

lazy val snippets = (project in file("."))
  .aggregate(helloCore)
  .dependsOn(helloCore)
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "snippets",
    libraryDependencies ++= Seq(
      scalaTest % Test,
    )
  )

lazy val helloCore = (project in file("core"))
  .settings(
    name := "Hello Core",

    libraryDependencies ++= Seq(
      gigahorse,
      playJson,
      scalaTest % Test,
    )
  )

lazy val basicScala = (project in file("basic"))
  .settings(
    name := "Basic Scala"
  )