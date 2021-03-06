name := "macroid-viewable"

organization := "org.macroid"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.10.4"

scalacOptions ++= Seq("-feature", "-deprecation")

resolvers ++= Seq(
  "jcenter" at "http://jcenter.bintray.com",
  "Android" at (file(System.getenv("ANDROID_SDK_HOME")) / "extras" / "android" / "m2repository").getCanonicalFile.toURI.toString
)

libraryDependencies ++= Seq(
  "com.google.android" % "android" % "4.1.1.4" % "provided",
  "com.android.support" % "support-v13" % "19.0.0",
  "org.macroid" %% "macroid" % "2.0.0-M2"
)

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))