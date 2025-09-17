package kura

import fs2.Stream

import java.util.UUID

case class File[F[_]](
    name: String,
    stream: Stream[F, Byte],
)
