import weaver.*

import cats.effect.*

object KuraSyntaxSuite extends SimpleIOSuite {
  type F[A] = IO[A]
  val F = Async[F]

  test("Syntax test") {
    for {
      result <- IO.pure(1)
    } yield expect.all(
      result == 1
    )
  }
}
