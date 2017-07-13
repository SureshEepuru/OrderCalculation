package com.tek.interview.question.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tek.interview.question.Item;
import com.tek.interview.question.OrderLine;

public class OrderLineTest {
	Item item;
	OrderLine orderLine;
	
	@Before
	public void init() throws Exception{
		item = new Item("Book",10.0f);
		orderLine = new OrderLine(item,2);
    }
	@Test
	public void testGetQuantity(){
		Assert.assertEquals(2, orderLine.getQuantity());
	}

	@Test(expected=AssertionError.class)
	public void testQuantityMoreThanZero() throws Exception{
		//item=null;
		new OrderLine(item,0);
		
	}
	

}
