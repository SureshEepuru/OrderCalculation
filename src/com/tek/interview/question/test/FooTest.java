package com.tek.interview.question.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tek.interview.question.Calculator;
import com.tek.interview.question.Item;
import com.tek.interview.question.Order;
import com.tek.interview.question.OrderLine;

public class FooTest {

	Calculator calculator = new Calculator();
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpSysOut() {

		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@Test
	public void invalidOrder() {

		try {
			new Order().add(null);
		} catch (Exception e) {

			Assert.assertTrue(e instanceof IllegalArgumentException);

			Assert.assertEquals(e.getMessage(), "Order is NULL");

		}

	}

	@Test

	public void invalidOrderLine() {

		try {

			new OrderLine(null, 5);

		} catch (Exception e) {

			Assert.assertEquals(e.getMessage(), "Item is NULL");

		}

	}

	@Test

	public void calculateWithNull() {

		try {

			calculator.calculate(null);

		} catch (Exception e) {

			Assert.assertEquals(e.getMessage(), "Orders are Null");

		}

	}

	@Test

	public void calculateWithEmpty() throws Exception {

		calculator.calculate(new LinkedHashMap<String, Order>());

		Assert.assertTrue(new String(outContent.toByteArray(), "UTF-8").contains("Sum of orders: 0.0"));

	}

	@Test

	public void calculate1() throws Exception {

		Map<String, Order> o = new LinkedHashMap<>();

		Order c = new Order();

		c.add(new OrderLine(new Item("book", (float) 12.49), 1));

		c.add(new OrderLine(new Item("music CD", (float) 14.99), 1));

		c.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		o.put("Order 1", c);

		calculator.calculate(o);

		String output = new String(outContent.toByteArray(), "UTF-8");

		Assert.assertTrue(output.contains("Sum of orders: 28.33"));

		Assert.assertTrue(output.contains("Total: 28.33"));

		Assert.assertTrue(output.contains("Sales Tax: 2.83"));

		Assert.assertTrue(output.contains("chocolate bar: 0.94"));

		Assert.assertTrue(output.contains("music CD: 16.49"));

		Assert.assertTrue(output.contains("book: 13.74"));

	}

	@Test

	public void calculate2() throws Exception {

		Map<String, Order> o = new LinkedHashMap<>();

		Order c = new Order();

		c.add(new OrderLine(new Item("book", (float) 12.49), 1));

		c.add(new OrderLine(new Item("music CD", (float) 14.99), 1));

		c.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		o.put("Order 1", c);

		c = new Order();

		c.add(new OrderLine(new Item("imported box of chocolate", 10), 1));

		c.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));

		o.put("Order 2", c);

		c = new Order();

		c.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));

		c.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));

		c.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));

		c.add(new OrderLine(new Item("box of imported chocolates", (float) 11.25), 1));

		o.put("Order 3", c);

		calculator.calculate(o);

		String output = new String(outContent.toByteArray(), "UTF-8");

		Assert.assertTrue(output.contains("Sum of orders: 153.81"));

		Assert.assertTrue(output.contains("Total: 28.33"));

		Assert.assertTrue(output.contains("Sales Tax: 2.83"));

		Assert.assertTrue(output.contains("chocolate bar: 0.94"));

		Assert.assertTrue(output.contains("music CD: 16.49"));

		Assert.assertTrue(output.contains("book: 13.74"));

		Assert.assertTrue(output.contains("Total: 57.5"));

		Assert.assertTrue(output.contains("imported box of chocolate: 11.5"));

		Assert.assertTrue(output.contains("imported bottle of perfume: 54.63"));

		Assert.assertTrue(output.contains("Total: 67.98"));

		Assert.assertTrue(output.contains("Sales Tax: 8.76"));

		Assert.assertTrue(output.contains("Imported bottle of perfume: 32.19"));

		Assert.assertTrue(output.contains("packet of headache pills: 10.73"));

		Assert.assertTrue(output.contains("box of imported chocolates: 12.94"));

	}

	@After

	public void cleanUp() {

		System.setErr(null);

	}

}
