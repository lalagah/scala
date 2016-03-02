package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import basics.cache;

public class cacheSingletonTest {
	
	@Before
	public void setup(){
		//part of learning about how object vs class is a singleton
		cache.reset();
	}
	
	@Test
	public void testCache_noEntry() {
		Integer key = 2;
		
		assertEquals(cache.get(key), cache.notfound());
	}
	
	@Test
	public void testCache_putget() {
		Integer key = 2;
		String value = "This is TWO";
		
		cache.put(key, value);
		assertEquals(cache.get(key), value);
	}
	
	@Test
	public void testCache_putdelete() {
		Integer key = 2;
		String value = "This is TWO";
		
		cache.put(key, value);
		cache.delete(key);
		
		assertEquals(cache.get(key), cache.notfound());
	}
}
