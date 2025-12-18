val scala3Version = "3.7.4"

lazy val root = project
  .in(file("."))
  .settings(
    name := "advent-of-code",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.scalatest"     %% "scalatest"        % "3.2.19" % Test,
      "org.scalatestplus" %% "scalacheck-1-16"  % "3.2.14.0" % Test,
      "org.scalameta"     %% "munit"            % "1.0.0" % Test
    )
  )
