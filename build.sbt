scalaVersion := "3.9.0"

lazy val root = rootProject
  .settings(
    name := "Jasm",
    mainClass := Option("src/main/scala/Main.scala"),
    libraryDependencies ++= Seq(
      //You can add library dependencies here, for example,
      //"org.scalatest" %% "scalatest" % "3.2.19" % Test,
      //"org.scalameta" %% "munit" % "1.2.3" % Test
    ),
    libraryDependencies += "com.lihaoyi" %% "os-lib" % "0.11.9-M8",
    libraryDependencies += "asm" % "asm" % "3.3.1"
  )
