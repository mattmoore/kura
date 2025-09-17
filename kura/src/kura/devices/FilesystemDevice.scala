package kura.devices

import cats.effect.*
import cats.implicits.*
import fs2.*
import fs2.io.file.*
import org.typelevel.log4cats.Logger

trait FilesystemDevice[F[_]] extends Device[F]

object FilesystemDevice {
  def apply[F[_]: Async: Logger](root: Option[String] = None): FilesystemDevice[F] = new FilesystemDevice[F] {
    override def read(path: String): Stream[F, Byte] =
      Files[F].readAll(rootOrPath(path))

    override def write(path: String, data: fs2.Stream[F, Byte]): F[Unit] = for {
      _ <- rootOrPath(path).parent match {
        case Some(parent) => Files[F].createDirectories(parent)
        case None         => ().pure
      }
      _ <- data
        .through(Files[F].writeAll(rootOrPath(path)))
        .compile
        .drain
    } yield ()

    override def delete(path: String): F[Unit] =
      Files[F].deleteIfExists(rootOrPath(path)).void

    private def rootOrPath(path: String): Path =
      root.fold(Path(path))(r => Path(s"$r/$path"))
  }
}
