package com.tek.interview.question.test;


import org.junit.Assert;
import org.junit.Test;

import com.tek.interview.question.Item;

public class ItemTest {
	
	Item item = new Item("Book",10.0f);
	
	@Test
	public void testGetDescription(){
		Assert.assertEquals("Book",item.getDescription());
	}
	
	@Test
	public void testGetPrice(){
		Assert.assertEquals(10.0, item.getPrice(), 0.0);;
	}

}
