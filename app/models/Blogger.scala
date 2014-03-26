package models

import scala.collection.JavaConverters._
import db.MongoDataBase

case class Blogger(users: Map[String, User] = Map.empty) {

  val mongodb = new MongoDataBase()

  def addUser(user: User) : Blogger= {
    Blogger(users + (user.name -> user))
  }

  def isValidUser(userName: String, password: String): Boolean = {
    var flag: Boolean = false
    if(users contains(userName)){
      println("i m here to.")
      val user: User = users.asJava.get(userName)
      flag = user.isPasswordCorrect(password)

    }
    flag
  }

  def addPostTo(userName: String, post: Post) = {
    val myUser: User = users.get(userName).getOrElse(null)
    myUser.addPost(post)
    mongodb.addPost(userName,post.postName,post.content)
  }

  def getMyPosts(userName: String): List[String] = {
    mongodb.showMyPosts(userName)
  }

  def contains(name: String) : Boolean = {
    users contains(name)
  }
}
