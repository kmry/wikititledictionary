name := "wikititledictionary"

version := "0.1"

scalaVersion := "2.12.11"
val sparkVersion = "2.4.5"
val macwireVersion = "2.3.3"

libraryDependencies ++= Seq(
  "com.softwaremill.macwire" %% "macros" % macwireVersion % "provided",
  "com.softwaremill.macwire" %% "macrosakka" % macwireVersion % "provided",
  "com.softwaremill.macwire" %% "util" % macwireVersion,
  "com.softwaremill.macwire" %% "proxy" % macwireVersion,
    "org.apache.spark" %% "spark-core" % sparkVersion,
    "org.apache.spark" %% "spark-sql" % sparkVersion,
    "org.apache.spark" %% "spark-catalyst" % sparkVersion,
  "com.redislabs" %% "spark-redis" % "2.4.2"
)


