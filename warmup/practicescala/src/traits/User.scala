package traits

import enums.Gender._

trait User {
  def team: Integer;
  def name: String;
  def gender: Option[Gender];
}

class BaseUser(val team: Integer, val name: String, val gender: Option[Gender]) extends User
class SpecialUser(val team: Integer, val name: String, val gender: Option[Gender]) extends User

object BaseUser {
  def unapply(user: BaseUser): Option[(Integer, String)] = Some(user.team, user.name)
}

object SpecialUser {
 def unapply(user: SpecialUser): Option[(Integer, String)] = Some(user.team, user.name)
}