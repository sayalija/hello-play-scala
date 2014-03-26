package db

import com.mongodb.casbah.{Imports, MongoConnection}
import com.mongodb.casbah.commons.MongoDBObject
import models.{User, Blogger}

class PostHandler {
  val myConnection = MongoConnection()
  val postCollection = myConnection("test")("posts")
  val userCollection = myConnection("test")("users")
  var blogger = new Blogger

  def signups = {

    blogger = blogger.addUser(User("sayali","jagtap")).addUser(User("pallavi","goliwale")).addUser(User("shital","mane"))

    userCollection.insert(MongoDBObject("_id" -> "sayali", "password" -> "jagtap"))
    userCollection.insert(MongoDBObject("_id" -> "pallavi", "password" -> "goliwale"))
    userCollection.insert(MongoDBObject("_id" -> "shital", "password" -> "mane"))

    val aa = userCollection.find()
    for(a <- aa){
      println(a)
    }
  }


  def addPost(user: String,postName:String, post:String) = {
    val obj = MongoDBObject("user"-> user, "postname"->postName, "post"->post)
    postCollection.insert(obj)
  }

//  def getAllDocuments() : List[String] = {
//    collection.find().toList.map(_.get("post").toString)
//  }

//  def getDocuments(postName:String) : List[String] = {
//    collection.find().filter(_.get("postName") == postName).toList.map(_.get("post").toString)
//  }

//  def getPostsWithName() : List[String] = {
//    val posts = collection.find().toList.map(_.get("post").toString)
//    val names = collection.find().toList.map(_.get("postName").toString)

//    def getPostsWithNames(abc : List[(String,String)]) : List[String] = {
//      var result = List.empty[String]
//      for((postName,post) <- abc){
//        result = result :+ postName + " : " + post
//      }
//      result
//    }

//    getPostsWithNames(names zip posts)
//  }

}
