package circe

import io.circe._
import io.circe.syntax._
import io.circe.parser._
import io.circe.generic.extras.semiauto._
import io.circe.generic.extras._
import circe.Config._

object CirceApp extends App {
  val foo = Qux(13, Some(14.0))
  val jsonString = foo.asJson.noSpaces
  println(jsonString)
  val decodedFoo = decode[Qux](jsonString)
  println(decodedFoo)
}

@ConfiguredJsonCodec
sealed trait Foo

@ConfiguredJsonCodec
case class Bar(xs: Vector[String]) extends Foo

@ConfiguredJsonCodec
case class Qux(cardId: Int, dataValue: Option[Double], json: Option[Json] = None) extends Foo

object Config {
  implicit val config: Configuration =
    Configuration.default.withSnakeCaseMemberNames

//  implicit val fooDecoder: Decoder[Foo] = deriveDecoder
//  implicit val fooEncoder: Encoder[Foo] = deriveEncoder
//  implicit val quxDecoder: Decoder[Qux] = deriveDecoder
//  implicit val quxEncoder: Encoder[Qux] = deriveEncoder
}
