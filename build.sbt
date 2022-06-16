name := "customhud"

version := "0.1"

scalaVersion := "2.13.1"

//resolvers += "spigot-repo" at "https://hub.spigotmc.org/nexus/content/repositories/snapshots/"
resolvers += "jcenter-bintray" at "https://jcenter.bintray.com"
//resolvers += "bungeecord" at "https://oss.sonatype.org/content/repositories/snapshots/"
resolvers += Resolver.mavenLocal // need to build it first with buildtools


libraryDependencies += "org.spigotmc" % "spigot-api" % "1.19-R0.1-SNAPSHOT" % "provided"
