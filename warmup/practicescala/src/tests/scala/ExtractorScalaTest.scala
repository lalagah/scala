package tests.scala;

import org.junit._;
import traits.BaseUser;
import traits.SpecialUser;
import traits.User;

class ExtractorsTest {

	val mike : User = new BaseUser(1, "Mike");
	val sally : User = new BaseUser(2, "Sally");
	val fred : User = new SpecialUser(2, "Fred");
	
	@Test def test_MessingWithExtractors(){
		println(matchUser(mike));
		println(matchUser(sally));
		println(matchUser(fred));
	}
	
	def matchUser(user: User) : String = {
		user match {
			case BaseUser(_, name) => "Hello " + name + " you are a normal user"
			case SpecialUser(_ , name) => "Hello " + name + " you are a special user"
		}
	}
}