package models

import org.specs2.mutable.Specification

class BloggerTest extends Specification {
  "check contains when Users list is empty " in {
    val admin = new Blogger
    admin.contains("sayali") mustEqual(false)
  }

  "check contains when Users list is not empty " in {
    val admin = new Blogger
    admin.addUser(new User("sayali","$@yalI"))
    admin.contains("sayali") mustEqual(true)
    admin.contains("jagtap") mustEqual(false)
  }

  "add user" in {
    val admin = new Blogger
    admin.addUser(new User("sayali","$@yalI"))
    admin.contains("sayali") mustEqual(true)
  }

  "check for validity of user when user is valid" in {
    val admin = new Blogger
    admin.addUser(new User("sayali","Sayali"))
    admin.isValidUser("sayali","Sayali") mustEqual(true)
  }

  "check for validity of user when user is invalid" in {
    val admin = new Blogger
    admin.addUser(new User("sayali","$@yalI"))
    admin.isValidUser("sayali","Sayali") mustEqual(false)
    admin.isValidUser("sa","Sayali") mustEqual(false)
  }


}
