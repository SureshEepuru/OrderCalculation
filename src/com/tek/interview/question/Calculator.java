package com.tek.interview.question;

import java.util.Map;

/**
 * represents order Calculator.
 * @author suresh
 *
 */
class Calculator {

	public static double rounding(double value) {
		return ( (int) (value * 100)) / 100;
	}

	/**
	 * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
	 * is the item's price * quantity * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for this order
	 */
	public void calculate(Map<String, Order> o) {

		double grandtotal = 0;

		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");
			//grandtotal = 0; // Not required as its initialized above

			Order r = entry.getValue();

			double totalTax = 0;
			double total = 0;

			// Iterate through the items in the order
			for (int i = 0; i < r.size(); i++) { // Fixed IndexOutOfBoundsException

				// Calculate the taxes
				double tax = 0;

				if (r.get(i).getItem().getDescription().contains("imported")) {
					tax = rounding(r.get(i).getItem().getPrice() * 0.15); // Extra 5% tax on
					// imported items
				} else {
					tax = rounding(r.get(i).getItem().getPrice() * 0.10);
				}

				// Calculate the total price
				double totalprice = r.get(i).getItem().getPrice() + Math.floor(tax);

				// Print out the item's total price
				System.out.println(r.get(i).getItem().getDescription() + ": " + Math.floor(totalprice));

				// Keep a running total
				totalTax += tax;
				total += r.get(i).getItem().getPrice();
			}

			// Print out the total taxes
			System.out.println("Sales Tax: " + Math.floor(totalTax));

			total = total + totalTax;

			// Print out the total amount
			System.out.println("Total: " + Math.floor(total * 100) / 100);
			grandtotal += total;
		}

		System.out.println("Sum of orders: " + Math.floor(grandtotal * 100) / 100);
	}
}