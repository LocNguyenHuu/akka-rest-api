package ark.endpoint.parseUser

import java.util.UUID

import akr.model.{UserEntity, UserEntityUpdate}
import io.circe.{Decoder, Encoder}
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.generic.auto._
import io.circe.syntax._

import scala.concurrent.Future

/**
	* Created by locnguyen on 3/28/17.
	*/


final case class GetUserResponse(
	user: Seq[UserEntity]
)

object GetUserResponse {
	implicit val encoder: Encoder[GetUserResponse] = deriveEncoder
	implicit val decoder: Decoder[GetUserResponse] = deriveDecoder
}

final case class AddUserRequest(
	username: String,
	password: String
)

object AddUserRequest {
	implicit val encoder: Encoder[AddUserRequest] = deriveEncoder
	implicit val decoder: Decoder[AddUserRequest] = deriveDecoder
}
final case class AddUserResponse(
	userId: Option[Long],
	user: UserEntity
)

object AddUserResponse {
	implicit val encoder: Encoder[AddUserResponse] = deriveEncoder
	implicit val decoder: Decoder[AddUserResponse] = deriveDecoder
}

final case class UpdateUserRequest(
	user: UserEntityUpdate
)

object UpdateUserRequest {
	implicit val encoder: Encoder[UpdateUserRequest] = deriveEncoder
	implicit val decoder: Decoder[UpdateUserRequest] = deriveDecoder
}
