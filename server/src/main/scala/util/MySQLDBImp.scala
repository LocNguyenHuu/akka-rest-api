//package util
//
//import slick.driver.MySQLDriver
//
///**
//	* Created by locnguyen on 3/30/17.
//	*/
//
//trait MySQLDBImp extends DatabaseConfig {
//	val driver = MySQLDriver
//
//	import driver.api._
//
//	val database: Database = MysqlDB.connectionPool
//}
//
//private[util] object MysqlDB {
//	import slick.driver.MySQLDriver.api._
//
//	val connectionPool = Database.forConfig("mysql")
//
//}