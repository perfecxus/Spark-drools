name := "Spark-drools"

version := "1.0"

scalaVersion := "2.11.8"

val sparkVersion = "2.1.0"

resolvers ++= Seq(
  "apache-snapshots" at "http://repository.apache.org/snapshots/"
)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion
)


val droolsVersion = "6.4.0.Final"

resolvers += "JBoss public" at "http://repository.jboss.org/nexus/content/groups/public/"

libraryDependencies ++= {
  "org.kie" % "kie-api" % droolsVersion ::
    List("drools-compiler","drools-core", "drools-decisiontables", "knowledge-api")
      .map("org.drools" % _ % droolsVersion)
}

libraryDependencies += "org.jbpm" % "jbpm-test" % droolsVersion

    