package circe

import io.circe._
import io.circe.syntax._
import io.circe.parser._
//import io.circe.generic.auto._
//import io.circe.generic.semiauto._
import io.circe.generic.extras.semiauto._
import io.circe.generic.JsonCodec
import io.circe.generic.extras._
import circe.Model._

object CirceApp extends App {
  @ConfiguredJsonCodec sealed trait Foo

  @ConfiguredJsonCodec case class Bar(xs: Vector[String]) extends Foo

  @ConfiguredJsonCodec case class Qux(cardId: Int, dataValue: Option[Double]) extends Foo

  val foo: Foo = Qux(13, Some(14.0))
  val jsonString = foo.asJson.noSpaces
  println(jsonString)
  val decodedFoo = decode[Foo](jsonString)
  println(decodedFoo)
}

object Model {
  import circe.CirceApp._

  implicit val config: Configuration = Configuration.default.withSnakeCaseMemberNames
  /*

  implicit val quxDecoder: Decoder[Foo] = deriveDecoder[Foo]
  implicit val quxEncoder: Encoder[Foo] = deriveEncoder[Foo]
 */
}
