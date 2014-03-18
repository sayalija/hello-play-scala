package db

import com.mongodb.casbah.MongoConnection

object MongoDBSetup {
  val mongoDB = MongoConnection()("test_database")
}