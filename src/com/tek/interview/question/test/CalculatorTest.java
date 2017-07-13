package com.tek.interview.question.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tek.interview.question.Calculator;
import com.tek.interview.question.Item;
import com.tek.interview.question.Order;
import com.tek.interview.question.OrderLine;

public class CalculatorTest {
	
	
	Order c1;
	Map<String, Order> o;

	@Before
	public void init() throws Exception{
		o = new HashMap<String, Order>();

		c1 = new Order();

		c1.add(new OrderLine(new Item("book", (float) 12.49), 1));
		c1.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		c1.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		o.put("Order 1", c1);

    }
	
	@Test
	public void testRoundingEqual(){
		Assert.assertEquals(2.24, Calculator.rounding(2.2365),0);
	}
	@Test
	public void testRoundingNotEqual(){
		Assert.assertNotEquals(2.23, Calculator.rounding(2.2365),0);
	}
	
	

}
