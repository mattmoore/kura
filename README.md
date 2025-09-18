# Kura

[![GitHub Tag](https://img.shields.io/github/v/tag/mattmoore/kura)](https://github.com/mattmoore/kura/tags)
[![Maven Central Version](https://img.shields.io/maven-central/v/io.mattmoore/kura_3)](https://repo1.maven.org/maven2/io/mattmoore/kura_3/)

File storage manager, designed to work with [cats-effect](https://typelevel.org/cats-effect/) and [fs2](https://fs2.io/), supporting multiple backend options:

- Local files
- AWS S3
- GCP

Named after [traditional Japanese storehouse (Kura)](https://en.wikipedia.org/wiki/Kura_(storehouse))

![Kura (storehouse)](Kura_cafe.JPG)

## Getting Started

Add the following dependencies:

mill:

```scala
def mvnDeps = Seq(
  mvn"io.mattmoore::kura:${version}"
)
```

sbt:

```scala
libraryDependencies ++= Seq(
  "io.mattmoore" %% "kura" % version
)
```

## Usage

Assuming you have some effect type in scope (yes, I'm trying to encourage tagless final):

```scala
type F[A] = IO[A]
val F = Async[F]
```

### Filesystem Device

```scala
val fileDevice = kura.Device[F] = kura.filesystem[F](Option("storage"))
```

### S3 Bucket Device

```scala
val s3Device = kura.Device[F] = kura.s3[F](Option("storage"))
```
