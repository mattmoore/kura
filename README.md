# Kura

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
  mvn"io.mattmoore::kura:0.0.1"
)
```

sbt:

```scala
libraryDependencies ++= Seq(
  "io.mattmoore" %% "kura" % "0.0.1"
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
