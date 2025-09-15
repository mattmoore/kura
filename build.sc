import mill.*
import scalalib.*
import scalafmt.*
import publish.*
import mill.api.Task.Simple

object versions {
  val scala = "3.7.2"
  val catsCore = "2.13.0"
  val catsEffect = "3.6.3"
  val catsRetry = "4.0.0"
  val awsSdk = "2.33.9"
  val googleCloudStorage = "2.57.0"
  val log4cats = "2.7.1"
  val logback = "1.5.18"
  val logstashLogbackEncoder = "8.1"
  val ciris = "3.6.0"
  val circe = "0.14.14"
  val fs2 = "3.12.0"
  val weaver = "0.9.3"
  val testContainers = "0.41.4"
}

object kura extends ScalaModule, ScalafmtModule, PublishModule, SonatypeCentralPublishModule {
  def scalaVersion = versions.scala
  def publishVersion = "0.0.1"

  def pomSettings = PomSettings(
    description = "Kura",
    organization = "io.mattmoore",
    url = "https://github.com/mattmoore/kura",
    licenses = Seq(License.`Apache-2.0`),
    versionControl = VersionControl.github("mattmoore", "kura"),
    developers = Seq(Developer("mattmoore", "Matt Moore", "https://github.com/mattmoore")),
  )

  def mvnDeps = Seq(
    // cats
    mvn"org.typelevel::cats-core:${versions.catsCore}",
    mvn"org.typelevel::cats-effect:${versions.catsEffect}",
    mvn"com.github.cb372::cats-retry:${versions.catsRetry}",
    // logging
    mvn"org.typelevel::log4cats-core:${versions.log4cats}",
    mvn"org.typelevel::log4cats-slf4j:${versions.log4cats}",
    mvn"ch.qos.logback:logback-classic:${versions.logback}",
    mvn"net.logstash.logback:logstash-logback-encoder:${versions.logstashLogbackEncoder}",
    // ciris
    mvn"is.cir::ciris:${versions.ciris}",
    // circe
    mvn"io.circe::circe-core:${versions.circe}",
    mvn"io.circe::circe-generic:${versions.circe}",
    mvn"io.circe::circe-literal:${versions.circe}",
    mvn"io.circe::circe-parser:${versions.circe}",
    // fs2
    mvn"co.fs2::fs2-core:${versions.fs2}",
    mvn"co.fs2::fs2-io:${versions.fs2}",
    mvn"co.fs2::fs2-scodec:${versions.fs2}",
    // AWS SDK
    mvn"software.amazon.awssdk:bom:${versions.awsSdk}",
    mvn"software.amazon.awssdk:s3:${versions.awsSdk}",
    // Google cloud storage
    mvn"com.google.cloud:google-cloud-storage:${versions.googleCloudStorage}",
    // weaver
    mvn"org.typelevel::weaver-cats:${versions.weaver}",
    // testcontainers
    mvn"com.dimafeng::testcontainers-scala:${versions.testContainers}",
  )

  object test extends ScalaTests {
    def testFramework = "weaver.framework.CatsEffect"
  }
}
