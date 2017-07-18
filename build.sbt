name := "NumbersProject"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

wartremoverErrors in (Compile, compile) ++= Warts.unsafe
wartremoverExcluded += baseDirectory.value / "src" / "test" / "scala" / "NumberToTextTest.scala"