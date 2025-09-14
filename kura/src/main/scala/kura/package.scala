package kura

import cats.effect.*
import kura.devices.FilesystemDevice
import org.typelevel.log4cats.Logger

type Device[F[_]] = devices.Device[F]

def filesystem[F[_]: Async: Logger](root: Option[String] = None): FilesystemDevice[F] = FilesystemDevice(root)
