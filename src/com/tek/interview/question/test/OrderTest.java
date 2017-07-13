package com.tek.interview.question.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tek.interview.question.Item;
import com.tek.interview.question.Order;
import com.tek.interview.question.OrderLine;

public class OrderTest {
	
	Item item1;
	Item item2;
	OrderLine orderLine1;
	OrderLine orderLine2;
	Order order;
	
	@Before
	public void init() throws Exception{
		item1 = new Item("Book",10.0f);
		item2 = new Item("Perfume",20.0f);
		orderLine1 = new OrderLine(item1,2);
		orderLine2 = new OrderLine(item2,4);
		List<OrderLine> orderLines = new ArrayList<OrderLine>();
		orderLines.add(orderLine1);
		orderLines.add(orderLine2);
		order = new Order();
		//order.add(orderLine1);
		//order.add(orderLine2);

    }
	@Test
	public void testOrderLineNotNullException() throws Exception{
		order.add(orderLine1);
		order.add(orderLine2);
	}
	
	@Test
	public void testOrderSize() throws Exception{
		order.add(orderLine1);
		order.add(orderLine2);
		Assert.assertEquals(2,order.size(),0);
	}
	
	
	

}
