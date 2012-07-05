organization := "com.braxisltd"

name := "thin-web"

version := "1.0"

libraryDependencies ++= Seq(
    "net.databinder" %% "unfiltered-filter" % "0.6.2",
    "net.databinder" %% "unfiltered-jetty" % "0.6.2",
    "org.clapper" %% "avsl" % "0.4",
    "org.clapper" %% "grizzled-slf4j" % "0.6.9",
    "net.liftweb" %% "lift-json" % "2.4",
    "org.scalatest" %% "scalatest" % "1.6.1" % "test",
    "org.seleniumhq.selenium" % "selenium-server" % "2.8.0" % "test",
    "org.seleniumhq.selenium" % "selenium-support" % "2.8.0" % "test"
)

resolvers ++= Seq(
    "java m2" at "http://download.java.net/maven/2",
    "sbt-idea-repo" at "http://mpeltonen.github.com/maven/",
    "Maven Repository" at "http://repo1.maven.org/maven2/",
    "Maven Repository 2" at "http://repo2.maven.org/maven2/",
    "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

