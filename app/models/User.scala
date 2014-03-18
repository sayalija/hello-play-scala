package models

case class User(val name: String, private val password: String) {
  var posts = List.empty[Post]

  def addPost(post: Post) = {
    posts  = posts :+ post
  }

  def isPasswordCorrect(pwd: String) : Boolean = {
    this.password == pwd
  }

}
