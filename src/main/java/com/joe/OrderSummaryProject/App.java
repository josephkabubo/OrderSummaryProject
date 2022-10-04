package com.joe.OrderSummaryProject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class App {
	// Set file path to Excel workbook here
	private static final String FILE_PATH = "Order_Summary_Template.xlsx";
	private static final String SHEET_NAME = "Order Summary";

	public static void main(String[] args) throws ParseException {
		// Create orders to add
		ArrayList<Order> orders = new ArrayList<Order>();

		Date date = new SimpleDateFormat("yyyy-MM-dd h:mm:ss").parse("2021-09-15 06:52:47");
		Order order1 = new Order("ZGFY-1342", "DELIVERY", date, "CREDIT_CARD", "Lunch", 15, 25, 8700, 8700, 8700, 0);
		orders.add(order1);

		Order order2 = new Order("ZTRK-1691", "TAKEOUT", new Date(), "CREDIT_CARD", "Dinner", 50, 0, 2500, 2000, 2500, 0);
		orders.add(order2);

		try {
			// Add orders to workbook
			AddOrdersToExcelWorkBook addOrdersToExcelWorkBook = new AddOrdersToExcelWorkBook();
			addOrdersToExcelWorkBook.addOrders(FILE_PATH, SHEET_NAME, 3, orders);
			System.out.println("Orders added to workbook");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
