package tests.scala;

import org.junit._;
import traits.BaseUser;
import traits.SpecialUser;
import traits.User;
import enums.Gender;
import scala.collection.mutable.ListBuffer;

class ExtractorsTest {

	val mike : User = new BaseUser(1, "Mike", Some(Gender.male));
	val sally : User = new BaseUser(2, "Sally", Some(Gender.female));
	val fred : User = new SpecialUser(2, "Fred", Some(Gender.male));
	val alex : User = new SpecialUser(1, "Alex", None);
	
	val userList = List(mike, sally, fred, alex);
	
	@Test def test_MessingWithExtractors_Name(){
		println(matchUserName(mike));
		println(matchUserName(sally));
		println(matchUserName(fred));
		println(matchUserName(alex));
	}
	
	@Test def test_MessingWithExtractors_Gender(){
		println(matchUserGender(mike));
		println(matchUserGender(sally));
		println(matchUserGender(fred));
		println(matchUserGender(alex));
	}
	
	@Test def test_MessingWithExtractors_Gender_take_two(){
		println(matchUserGender(mike));
		println(matchUserGender(sally));
		println(matchUserGender(fred));
		println(matchUserGender(alex));
	}
	
	@Test def test_Extracting_My_Own_tuples_team_number___silly_but_learning_syntax(){
	
		var actual = new ListBuffer[Integer]();
	
		for(user <- userList) {
			val tuple = (user.team, user.gender);
			actual += matchTuple(tuple);
		}
		
		val expected = List(1,2,2,1);
		
		println(actual);
		println(expected);
	}
	
	def matchTuple(tuple: (_, _)) : Integer = {
		tuple match{
			case (team : Integer, _) => team;
		}
	}
	
	def matchUserGender(user: User) : String = {
		user match {
			case BaseUser(_, _, Some(Gender.male)) => "you are a dude"
			case BaseUser(_, _, Some(Gender.female)) => "you are a chick"
			case SpecialUser(_ , _, Some(Gender.male)) => "you are a dude"
			case SpecialUser(_ , _, Some(Gender.female)) => "you are a chick"
			case _ => "you are a mystery"
		}
	}
	
	def matchUserGender_take_two(user: User) : String = {
		val gender = user.gender;
	
		gender match {
			case Some(Gender.male) => "you are a dude"
			case Some(Gender.female) => "you are a chick"
			case _ => "you are a mystery"
		}
	}
	
	def matchUserName(user: User) : String = {
		user match {
			case BaseUser(_, name, _) => "Hello " + name + " you are a normal user"
			case SpecialUser(_ , name, _) => "Hello " + name + " you are a special user"
		}
	}
}