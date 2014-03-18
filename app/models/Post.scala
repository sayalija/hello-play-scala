package models

import java.util.Date

class Post(postName: String, content: String, date: Date) {
  var comments = List.empty[Comment]


  def addComment(comment: Comment) = {
    comments  = comments :+ comment
  }
}
