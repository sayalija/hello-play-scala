package db

trait Database {
  def addPost(userName: String, title: String,content: String)
  def showMyPosts(name: String): List[String]
  def showAllPosts() : (String,String,String)
}
