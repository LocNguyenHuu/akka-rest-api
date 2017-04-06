import akr.model.UserEntity
import io.circe.{Decoder, Encoder}
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.{deriveDecoder, deriveEncoder}
/**
	* Created by locnguyen on 3/28/17.
	*/
object circe {
	implicit val config = Configuration.default.withSnakeCaseKeys

	implicit val userEncoder: Encoder[UserEntity] = deriveEncoder
	implicit val userDecoder: Decoder[UserEntity] = deriveDecoder
}