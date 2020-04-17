name := "wikititledictionary"

version := "0.1"

scalaVersion := "2.12.11"
val sparkVersion = "2.4.5"
val macwireVersion = "2.3.3"
val scalacticVersion = "3.0.8"
val kuromojiVersion = "0.9.0"
libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % scalacticVersion,
  "org.scalatest" %% "scalatest" % scalacticVersion % "test",
  "com.softwaremill.macwire" %% "macros" % macwireVersion % "provided",
  "com.softwaremill.macwire" %% "macrosakka" % macwireVersion % "provided",
  "com.softwaremill.macwire" %% "util" % macwireVersion,
  "com.softwaremill.macwire" %% "proxy" % macwireVersion,
    "org.apache.spark" %% "spark-core" % sparkVersion,
    "org.apache.spark" %% "spark-sql" % sparkVersion,
    "org.apache.spark" %% "spark-catalyst" % sparkVersion,
  "com.redislabs" %% "spark-redis" % "2.4.2",
  "com.atilika.kuromoji" % "kuromoji-ipadic" % kuromojiVersion,
  "com.atilika.kuromoji" % "kuromoji-jumandic" % kuromojiVersion,
  "com.atilika.kuromoji" % "kuromoji" % kuromojiVersion,
  "com.ibm.icu" % "icu4j" % "60.1"
)


