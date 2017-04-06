package restapi.utils

import org.flywaydb.core.Flyway

/**
	* Created by locnguyen on 4/3/17.
	*/
class FlywayService(jdbcUrl: String, dbUser: String, dbPassword: String) {
	private[this] val flyway = new Flyway()
	flyway.setDataSource(jdbcUrl, dbUser, dbPassword)

	def migrateDatabaseSchema() : Unit = flyway.migrate()

	def dropDatabase() : Unit = flyway.clean()
}
