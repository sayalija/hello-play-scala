package db

import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.MongoConnection

class MongoDataBase extends Database{
  val myConnection = MongoConnection()
  val postCollection = myConnection("test")("posts")

  override def addPost(userName: String, title: String, content: String)= {
    val obj = MongoDBObject("user"-> userName, "postname"->title, "post"->content)
    postCollection.insert(obj)
  }

  override def showAllPosts(): (String, String, String) = ???

  override def showMyPosts(name: String): List[String] = {
    val posts = postCollection.find().filter(_.get("user") == name).toList.map(_.get("post").toString)
    val postNames = postCollection.find().filter(_.get("user") == name).toList.map(_.get("postname").toString)

    def getPostsWithNames(abc: List[(String, String)]): List[String] = {
      var result = List.empty[String]
      for ((postName, post) <- abc) {
        result = result :+ postName + " : " + post
      }
      result
    }
    getPostsWithNames(postNames zip posts)
  }  
}
