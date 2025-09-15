package kura

import cats.effect.*
import kura.devices.*
import org.typelevel.log4cats.Logger

type Device[F[_]] = devices.Device[F]
type FilesystemDevice[F[_]] = devices.FilesystemDevice[F]
type S3Device[F[_]] = devices.S3Device[F]

def filesystem[F[_]: Async: Logger](root: Option[String] = None): FilesystemDevice[F] = FilesystemDevice(root)

def s3[F[_]: Async: Logger](root: Option[String] = None): S3Device[F] = S3Device(root)

def google[F[_]: Async: Logger](root: Option[String] = None): GoogleCloudDevice[F] = GoogleCloudDevice(root)
