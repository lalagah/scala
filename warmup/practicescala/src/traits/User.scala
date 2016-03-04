package traits

import enums.Gender._

trait User {
  def team: Integer;
  def name: String;
  def gender: Option[Gender];
}

case class BaseUser(val team: Integer, val name: String, val gender: Option[Gender]) extends User
case class SpecialUser(val team: Integer, val name: String, val gender: Option[Gender]) extends User

//I guess using case class is going to be pretty normal for immutable classes like this and does all the unapply stuff for me

//object BaseUser {
//  def unapply(user: BaseUser): Option[(Integer, String, Option[Gender])] = Some(user.team, user.name, user.gender)
//}

//object SpecialUser {
// def unapply(user: SpecialUser): Option[(Integer, String, Option[Gender])] = Some(user.team, user.name, user.gender)
//}