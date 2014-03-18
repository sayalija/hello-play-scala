package models

import java.util.Date

case class Comment(person: User, content: String, date: Date)
