import play.Project._

name := "hello-play-scala"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.webjars" %% "webjars-play" % "2.2.0", 
  "org.webjars" % "bootstrap" % "2.3.1",
  "org.mongodb" % "mongo-java-driver" % "2.12.0-rc0",
  "org.mongodb" %% "casbah" % "2.5.0"
)

playScalaSettings
