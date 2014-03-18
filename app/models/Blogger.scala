package models

import scala.collection.JavaConverters._

class Blogger {
  private var users: Map[String, User] = Map.empty

  def addUser(user: User) = {
    users  = users + (user.name -> user)
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

  def contains(name: String) : Boolean = {
    users contains(name)
  }
}
