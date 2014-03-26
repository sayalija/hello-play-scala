package models

import java.util.Date

case class Post(postName: String, content: String) {
  var comments = List.empty[Comment]


  def addComment(comment: Comment) = {
    comments  = comments :+ comment
  }
}
