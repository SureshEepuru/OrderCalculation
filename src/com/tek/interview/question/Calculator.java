package com.tek.interview.question;

import java.util.Map;

/**
 * represents order Calculator.
 * @author suresh
 *
 */
class Calculator {

	public static double rounding(double value) {
		return Math.round(value*100.0)/100.0; // rounded to get 2 digits
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
					tax = rounding(r.get(i).getItem().getPrice() * 0.15); // Extra 15% tax on
					// imported items
				} else {
					tax = rounding(r.get(i).getItem().getPrice() * 0.10);
				}

				// Calculate the total price
				double totalprice = rounding(r.get(i).getItem().getPrice() + tax);//Math.round(tax*100.0)/100.0;// rounded

				// Print out the item's total price
				System.out.println(r.get(i).getQuantity()+" "+r.get(i).getItem().getDescription() + ": " + totalprice);//Math.round(totalprice*100.0)/100.0); 

				// Keep a running total
				totalTax +=  tax; //Math.round(tax*100.0)/100.0;//tax calculation
				total += r.get(i).getItem().getPrice();
			}

			// Print out the total taxes
			System.out.println("Sales Tax: " + rounding(totalTax));//Math.round(totalTax*100.0)/100.0); // rounded correct sales tax

			total = rounding(total);//total + totalTax;

			// Print out the total amount
			System.out.println("Total: " + total);//rounding(total-totalTax));  //Math.round((total-totalTax) * 100.0) / 100.0);// rounded
			grandtotal += total;//total-totalTax; // Fixed grand total calculation 
		}

		System.out.println("Sum of orders: " + grandtotal );//Math.round(grandtotal * 100.0) / 100.0); // rounded
	}
}