package ark.service

import akr.model.{UserEntity, UserEntityUpdate}
import monix.eval.Task
import monix.execution.CancelableFuture
import restapi.repository.UsersRepository

import scala.concurrent._
import ExecutionContext.Implicits.global
/**
	* Created by locnguyen on 4/6/17.
	*/
class UsersService(userRepo: UsersRepository) {

	def add(username: String, password: String): Task[(Option[Long], UserEntity)] = {
		val userId = Option(scala.util.Random.nextLong())
		val user = UserEntity(userId, username, password)

		val a = for {
			_ <- userRepo.createUser(user)
		} yield userId -> user
		Task.deferFuture(a)
	}

	def update(id: Long, user: UserEntityUpdate): Task[Unit] = {
		val b = userRepo.updateUser(id, user)
		Task.deferFuture(b)
	}

	def remove(id: Long): Task[Int] = {
		val c = userRepo.deleteUser(id)
		Task.deferFuture(c)
	}

	def getAll(): Task[Seq[UserEntity]] = {
		val d = userRepo.getUsers()
		Task.deferFuture(d)
	}
}
