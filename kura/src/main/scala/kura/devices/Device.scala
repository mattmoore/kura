package kura.devices

import fs2.Stream
import kura.File

trait Device[F[_]] {
  def read(path: String): Stream[F, Byte]
  def write(path: String, data: Stream[F, Byte]): F[Unit]
  def delete(path: String): F[Unit]
}
