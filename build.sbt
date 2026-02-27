import Versiones._

ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.18"



lazy val root = (project in file("."))
  .settings(
    name := "Data-engineering-portfolio",

    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % SparkVersion,
      "org.apache.spark" %% "spark-sql"  % SparkVersion,
      "com.typesafe"      % "config"     % TypesafeConfigConfig,
    )
  )
