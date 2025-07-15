ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "weather-analyzer",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.10.0",
      "com.nrinaudo" %% "kantan.csv" % "0.6.1",
      "com.nrinaudo" %% "kantan.csv-generic" % "0.6.1",
      "org.scalatest" %% "scalatest" % "3.2.18" % Test
    )
  )
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % Test
