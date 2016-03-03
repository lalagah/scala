package tests;

import traits.BaseUser;
import traits.User;

public class ExtractorsTest {

	User mike;
	User sally;
	User fred;
	
	public void setup(){
		mike = new BaseUser(1, "Mike");
		sally = new BaseUser(2, "Sally");
		fred = new BaseUser(2, "Fred");
	}
	
	public void test_MessingWithExtractors(){
		
		
	}
}
