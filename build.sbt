name := "wikititledictionary"

version := "0.1"

scalaVersion := "2.12.11"

libraryDependencies ++= Seq(
  "com.google.inject" % "guice" % "4.2.1",
  "com.softwaremill.macwire" %% "macros" % "2.3.1" % "provided",
  "com.softwaremill.macwire" %% "macrosakka" % "2.3.1" % "provided",
  "com.softwaremill.macwire" %% "util" % "2.3.1",
  "com.softwaremill.macwire" %% "proxy" % "2.3.1",
  "org.wvlet.airframe" %% "airframe" % "20.4.0",
)
