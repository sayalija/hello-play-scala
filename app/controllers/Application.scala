package controllers

import play.api.mvc.{Action, Controller}
import db._
import models.{Post, User, Blogger}

object Application extends Controller {
  val map = Map("sayali" -> User("sayali","jagtap"),"pallavi" -> User("pallavi","goliwale"),"shital" -> User("shital","mane"))
  val myBlogger = new Blogger(map)

  def index = Action {
    Ok(views.html.index(""))
  }

  def post = Action { implicit request=>
    val map = request.body.asFormUrlEncoded.get
    val name = map.get("name").get.head
    val password = map.get("password").get.head

    val isValid = myBlogger.isValidUser(name,password)

    if(isValid)
      Ok(views.html.addPost(name))

    else
      Ok(views.html.index("Authentication Failed . . . !"))
  }

  def addPost(userName: String) = Action { implicit request=>
    val map = request.body.asFormUrlEncoded.get
    val postName = map.get("postname").get.head
    val content = map.get("content").get.head


    myBlogger.addPostTo(userName,Post(postName,content))
    Ok("I came to add post. . . !"+ postName + content)
  }

  def showMyPosts(name: String) = Action{
    val myPosts = myBlogger.getMyPosts(name)
    Ok(views.html.display(myPosts))
  }



//  def signup = Action{
//    myPostHandler.signups
//    myBlogger.addUser(User("sayali","jagtap"))
//    myBlogger.addUser(User("pallavi","goliwale"))
//    myBlogger.addUser(User("shital","mane"))
//    Ok("sign up added . . . !")
//  }

//
//  def showAll = Action{
//    val allPosts = myPostHandler.getAllDocuments()
//    Ok(views.html.display(allPosts))
//  }
//

//
//  def getPostsWithName = Action{
//    val myPosts = myPostHandler.getPostsWithName()
//
//    Ok(views.html.display(myPosts))
//  }

}