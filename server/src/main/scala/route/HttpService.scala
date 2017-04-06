package route

import akka.http.scaladsl.server.Directives._
import ark.service.UsersService
import monix.execution.Scheduler

import scala.concurrent.ExecutionContext
/**
	* Created by locnguyen on 4/3/17.
	*/
class HttpService(userSerice: UsersService)(implicit  executionContext: ExecutionContext, scheduler: Scheduler) {
	val usersRouter = new UserServiceRoute(userSerice)

	val routes = pathPrefix("v1") {
		usersRouter.route
	}
}
