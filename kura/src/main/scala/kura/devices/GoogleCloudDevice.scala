package kura.devices

import cats.effect.*
import cats.implicits.*
import com.google.cloud.storage.Bucket
import com.google.cloud.storage.StorageOptions
import fs2.*
import fs2.io.file.*
import org.typelevel.log4cats.Logger
import com.google.auth.oauth2.GoogleCredentials
import java.io.FileInputStream

trait GoogleCloudDevice[F[_]] extends Device[F]

object GoogleCloudDevice {
  def apply[F[_]: Async: Logger](
      root: Option[String] = None,
      credentials: GoogleCredentials,
  ): GoogleCloudDevice[F] = new GoogleCloudDevice[F] {
    private val storage = StorageOptions.getDefaultInstance().getService()
    private val credentials = GoogleCredentials.fromStream(new FileInputStream(""))

    override def read(path: String): Stream[F, Byte] =
      ???

    override def write(path: String, data: fs2.Stream[F, Byte]): F[Unit] =
      ???

    override def delete(path: String): F[Unit] =
      ???
  }
}
