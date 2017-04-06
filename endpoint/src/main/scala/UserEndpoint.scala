package ark.endpoint

import java.util.UUID

import ark.endpoint.parseUser._
import endpoints.algebra.{CirceEntities, Endpoints}

import scala.concurrent.Future
//import endpoints.algebra._
import io.circe.Decoder
import io.circe.Encoder
import io.circe.generic.JsonCodec
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.deriveDecoder
import io.circe.generic.extras.semiauto.deriveEncoder
import io.circe.generic.extras.semiauto.deriveEnumerationDecoder
import io.circe.generic.extras.semiauto.deriveEnumerationEncoder
import io.circe.generic.auto._
/**
	* Created by locnguyen on 3/23/17.
	*/

trait UserEndpoint extends Endpoints with CirceEntities {



	val getUser = endpoint(request(Get, path / "users": Url[Unit], emptyRequest), jsonResponse[GetUserResponse])

	val addUser = endpoint(request(Post, path / "users": Url[Unit], jsonRequest[AddUserRequest]), jsonResponse[AddUserResponse])

	val updateUser = endpoint(request(Put, path / "users" / segment[Long]: Url[Long], jsonRequest[UpdateUserRequest]), emptyResponse)

	val removeUser = endpoint(request(Delete, path / "users" / segment[Long]: Url[Long], emptyRequest), emptyResponse)

//	val addUser = endpoint(request(Post, path / "users": Url[Unit], jsonRequest[AddUserRequest]), jsonResponse[AddUserResponse])
//
//	val updateUser = endpoint(request(Put, path / "users" / segment[UserId]: Url[UserId], jsonRequest[UpdateUserRequest]), emptyResponse)
//
//	val removeUser = endpoint(request(Delete, path / "users" / segment[UserId]: Url[UserId], emptyRequest), emptyResponse)
}

