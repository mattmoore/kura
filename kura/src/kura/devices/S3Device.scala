package kura.devices

import cats.effect.*
import cats.implicits.*
import fs2.*
import fs2.io.file.*
import org.typelevel.log4cats.Logger

trait S3Device[F[_]] extends Device[F]

object S3Device {
  def apply[F[_]: Async: Logger](root: Option[String] = None): S3Device[F] = new S3Device[F] {
    override def read(path: String): Stream[F, Byte] =
      ???

    override def write(path: String, data: fs2.Stream[F, Byte]): F[Unit] =
      ???

    override def delete(path: String): F[Unit] =
      ???
  }
}
