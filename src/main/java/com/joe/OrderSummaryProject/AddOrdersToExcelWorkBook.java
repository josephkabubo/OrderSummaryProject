package com.joe.OrderSummaryProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Joe Kabubo
 * @date   4th October 2022
 */
public class AddOrdersToExcelWorkBook {

	public void addOrders(String filePath, String sheetName, int startRow, ArrayList<Order> orders) throws IOException {
		// Read file from path and open workbook
		File file = new File(filePath);
		FileInputStream template = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(template);

		// Open sheet to add orders
		XSSFSheet sheet = wb.getSheet(sheetName);

		// Shift all rows below startRow by the number of orders to create rows for new orders
		int totalRows = sheet.getLastRowNum();
		sheet.shiftRows(startRow, totalRows, orders.size());

		// Get cell style to apply to newly created cells
		XSSFCellStyle cellStyle = sheet.getRow(1).getCell(0).getCellStyle();

		// Create date format pattern: yyyy-MM-dd h:mm:ss
		String datePattern = "yyyy-MM-dd h:mm:ss.SSS";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);

		for (Order order : orders) {
			// Create new row, create cells and set respective values
			XSSFRow row = sheet.createRow(startRow++);

			// Order Id
			row.createCell(0).setCellValue(order.getOrderId());
			row.getCell(0).setCellStyle(cellStyle);

			// Order Type
			row.createCell(1).setCellValue(order.getOrderType());
			row.getCell(1).setCellStyle(cellStyle);

			// Date
			String formattedDate = simpleDateFormat.format(order.getDate());
			row.createCell(2).setCellValue(formattedDate);
			row.getCell(2).setCellStyle(cellStyle);

			// Payment method
			row.createCell(3).setCellValue(order.getPaymentMethod());
			row.getCell(3).setCellStyle(cellStyle);

			// Meal period
			row.createCell(4).setCellValue(order.getMealPeriod());
			row.getCell(4).setCellStyle(cellStyle);

			// Commission
			row.createCell(5).setCellValue(order.getCommission());
			row.getCell(5).setCellStyle(cellStyle);

			// Additional charges
			row.createCell(6).setCellValue(order.getAdditionalCharges());
			row.getCell(6).setCellStyle(cellStyle);

			// Sub total
			row.createCell(7).setCellValue(order.getSubTotal());
			row.getCell(7).setCellStyle(cellStyle);

			// Tax
			row.createCell(8).setCellValue(order.getTax());
			row.getCell(8).setCellStyle(cellStyle);

			// Total
			row.createCell(9).setCellValue(order.getTotal());
			row.getCell(9).setCellStyle(cellStyle);

			// Total earned
			row.createCell(10).setCellValue(order.getTotalEarned());
			row.getCell(10).setCellStyle(cellStyle);
		}

		// Write to file and close stream and workbook
		FileOutputStream out = new FileOutputStream(filePath);
		wb.write(out);
		out.close();
		wb.close();
	}
}
