name := "aboutakka"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

scalacOptions ++= "-deprecation" :: "-feature" :: "-language:postfixOps" :: Nil

javacOptions ++= "-Xlint:deprecation" :: "-Xlint:unchecked" :: Nil

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.1" withSources() withJavadoc(),
  "com.typesafe.akka" %% "akka-remote" % "2.4.1" withSources() withJavadoc(),
  "com.typesafe.akka" %% "akka-slf4j" % "2.4.1" withSources() withJavadoc(),
  "com.typesafe.akka" %% "akka-kernel" % "2.4.1" withSources() withJavadoc(),
  "org.slf4j" % "slf4j-simple" % "1.7.7" withSources() withJavadoc(),
  "org.scalatest" %% "scalatest" % "2.2.6" % "test" withSources() withJavadoc(),
  "com.novocode" % "junit-interface" % "0.10" % "test",
  "org.easytesting" % "fest-assert" % "1.4" % "test" withSources() withJavadoc()
)