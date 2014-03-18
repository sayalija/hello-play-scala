package models

import org.specs2.mutable.Specification

class UserTest extends Specification {

  "is password correct for right password" in {
    val sayali = new User("sayali", "jagtap")
    sayali.isPasswordCorrect("jagtap") mustEqual(true)
  }

  "is password correct for wrong password" in {
    val sayali = new User("sayali","$@yalI")
    sayali.isPasswordCorrect("$@alI") mustEqual(false)
  }

}
