package db

import com.mongodb.casbah.{Imports, MongoConnection}
import com.mongodb.casbah.commons.MongoDBObject
import scala.collection.parallel.mutable

class PostHandler {
  val myConnection = MongoConnection()
  val collection = myConnection("test")("posts")

  def addPost(name:String, post:String) = {
    val obj = MongoDBObject("name"->name, "post"->post)
    collection.insert(obj)
  }

  def getAllDocuments() : List[String] = {
    collection.find().toList.map(_.get("post").toString)
  }

  def getDocuments(name:String) : List[String] = {
    collection.find().filter(_.get("name") == name).toList.map(_.get("post").toString)
  }

}
