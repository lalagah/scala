package traits

trait User {
  def team: Integer;
  def name: String;
}

class BaseUser(val team: Integer, val name: String) extends User
class SpecialUser(val team: Integer, val name: String) extends User

object BaseUser {
  def unapply(user: BaseUser): Option[(Integer, String)] = Some(user.team, user.name)
}

object SpecialUser {
 def unapply(user: SpecialUser): Option[(Integer, String)] = Some(user.team, user.name)
}