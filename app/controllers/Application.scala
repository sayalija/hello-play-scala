package controllers

import play.api.mvc.{Action, Controller}
import db._

object Application extends Controller {

  val myPostHandler = new PostHandler
  def index = Action {
    Ok(views.html.index())
  }

  def post = Action { implicit request=>
    val map = request.body.asFormUrlEncoded.get
    val name = map.get("name").get.head
    val postToAdd = map.get("postToAdd").get.head

    myPostHandler.addPost(name,postToAdd)

    Ok("Post added. . . !")
  }

  def showAll = Action{
    val allPosts = myPostHandler.getAllDocuments()
    Ok(views.html.display(allPosts))
  }

  def showMyPosts(name: String) = Action{
    val myPosts = myPostHandler.getDocuments(name)
    Ok(views.html.display(myPosts))
  }

}