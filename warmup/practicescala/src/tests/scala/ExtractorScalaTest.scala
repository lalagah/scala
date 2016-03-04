package tests.scala;

import org.junit._;
import traits.BaseUser;
import traits.SpecialUser;
import traits.User;
import enums.Gender;

class ExtractorsTest {

	val mike : User = new BaseUser(1, "Mike", Some(Gender.male));
	val sally : User = new BaseUser(2, "Sally", Some(Gender.female));
	val fred : User = new SpecialUser(2, "Fred", Some(Gender.male));
	val alex : User = new SpecialUser(1, "Alex", None);
	
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
	
	def matchUserGender(user: User) : String = {
		user match {
			case BaseUser(_, _, Some(Gender.male)) => "you are a dude"
			case BaseUser(_, _, Some(Gender.female)) => "you are a chick"
			case SpecialUser(_ , _, Some(Gender.male)) => "you are a dude"
			case SpecialUser(_ , _, Some(Gender.female)) => "you are a chick"
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