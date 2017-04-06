package route

import akka.actor.ActorSystem
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.PathMatchers
import akka.stream.ActorMaterializer
import akr.model.UserEntity
import de.heikoseeberger.akkahttpcirce.CirceSupport
import ark.endpoint.UserEndpoint
import ark.endpoint.parseUser._
import ark.service.UsersService
import endpoints.akkahttp.server._
import slick.backend.DatabaseConfig

import scala.concurrent.Future
import scala.io.StdIn
import scala.util.Random
import scala.concurrent.ExecutionContext
import io.circe.generic.auto._
import io.circe.syntax._
import monix.execution.Scheduler


/**
	* Created by locnguyen on 3/27/17.
	*/
class UserServiceRoute(userService: UsersService)(implicit executionContext: ExecutionContext, scheduler: Scheduler
 ) extends UserEndpoint with Endpoints with CirceEntities {

	import userService._


//	val route = pathPrefix("users") {
//		pathEndOrSingleSlash {
//			get {
//				complete(getUsers().map(x => x.asJson))
//			}
//		} ~ pathPrefix(IntNumber) { id =>
//			pathEndOrSingleSlash {
//				get {
//					complete(getUserById(id).map(_.asJson))
//				} ~ put {
//					entity(as[UserEntityUpdate]) { userUpdate =>
//						complete(updateUser(id, userUpdate).map(_.asJson))
//					}
//				} ~ delete {
//					onSuccess(deleteUser(id)) { ignored =>
//						complete("success delete user")
//					}
//				}
//			}
//		}
//	}


	val route = addUser.implementedByAsync { request =>
		userService.add(
			request.username,
			request.password
		).map { case (userId, user) => AddUserResponse(userId, user)
		}.runAsync
	} ~ updateUser.implementedByAsync { case (userId, request) =>
		userService.update(userId, request.user).runAsync
	} ~ removeUser.implementedBy { case (userId) =>
		userService.remove(userId)
	} ~ getUser.implementedByAsync { _ =>
		userService.getAll().map(GetUserResponse.apply).runAsync
	}

}
