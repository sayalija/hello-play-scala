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

  def getPostsWithName() : List[String] = {
    val posts = collection.find().toList.map(_.get("post").toString)
    val names = collection.find().toList.map(_.get("name").toString)

    def getPostsWithNames(abc : List[(String,String)]) : List[String] = {
      var result = List.empty[String]
      for((name,post) <- abc){
        result = result :+ name + " : " + post
      }
      result
    }

    getPostsWithNames(names zip posts)
  }

}
