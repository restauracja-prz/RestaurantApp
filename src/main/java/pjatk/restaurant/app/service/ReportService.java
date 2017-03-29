package pjatk.restaurant.app.service;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pjatk.restaurant.app.service.entity.OrderDetailsEntity;
import pjatk.restaurant.app.service.entity.OrderEntity;
import pjatk.restaurant.app.service.entity.TransactionEntity;

@Service
public class ReportService {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private TransactionDAO transactionDAO;

	public void exportOrderDetailsReport(Date dateFrom, Date dateTo, OutputStream outputStream) {
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        
        int currentRowIndex = 0;
        XSSFRow headerRow = sheet.createRow(currentRowIndex);
        
        headerRow.createCell(0).setCellValue("Order Id");
        headerRow.createCell(1).setCellValue("Device Id");
        headerRow.createCell(2).setCellValue("Meal Id");
        headerRow.createCell(3).setCellValue("Unit Price");
        headerRow.createCell(4).setCellValue("Client Comment");
        
        List<OrderDetailsEntity> reportDataList = orderDAO.findOrderDetailsReport(dateFrom, dateTo);
        
        for (OrderDetailsEntity reportData : reportDataList) {
        	currentRowIndex++;
        	
        	XSSFRow dataRow = sheet.createRow(currentRowIndex);
        	
        	dataRow.createCell(0).setCellValue(reportData.getOrderId());
        	dataRow.createCell(1).setCellValue(reportData.getDeviceId());
        	dataRow.createCell(2).setCellValue(reportData.getMealId());
        	dataRow.createCell(3).setCellValue(convertToString(reportData.getUnitPrice()));
        	dataRow.createCell(4).setCellValue(reportData.getClientComment());
        }
        
        try {
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void exportOrdersAndStatusReport(Date dateFrom, Date dateTo, OutputStream outputStream) {
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        
        int currentRowIndex = 0;
        XSSFRow headerRow = sheet.createRow(currentRowIndex);
        
        headerRow.createCell(0).setCellValue("Order Id");
        headerRow.createCell(1).setCellValue("Order Date");
        headerRow.createCell(2).setCellValue("Order Status");
        headerRow.createCell(3).setCellValue("User Id");
        
        List<OrderEntity> reportDataList = orderDAO.findOrderAndStatusReport(dateFrom, dateTo);
        
        for (OrderEntity reportData : reportDataList) {
        	currentRowIndex++;
        	
        	XSSFRow dataRow = sheet.createRow(currentRowIndex);
        	
        	dataRow.createCell(0).setCellValue(reportData.getOrderId());
        	dataRow.createCell(1).setCellValue(reportData.getOrderDate());
        	dataRow.createCell(2).setCellValue(reportData.getOrderStatus());
        	dataRow.createCell(3).setCellValue(reportData.getUserId());
        }
        
        try {
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void exportSalesReport(Date dateFrom, Date dateTo, OutputStream outputStream) {
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        
        int currentRowIndex = 0;
        XSSFRow headerRow = sheet.createRow(currentRowIndex);
        
        headerRow.createCell(0).setCellValue("Transaction Id");
        headerRow.createCell(1).setCellValue("Order Id");
        headerRow.createCell(2).setCellValue("Transaction Date");
        headerRow.createCell(3).setCellValue("Total Cost");
        headerRow.createCell(4).setCellValue("Total Units");
        headerRow.createCell(5).setCellValue("Payment Type");
        headerRow.createCell(6).setCellValue("User Id");
        
        List<TransactionEntity> reportDataList = transactionDAO.findSalesReport(dateFrom, dateTo);
        
        for (TransactionEntity reportData : reportDataList) {
        	currentRowIndex++;
        	
        	XSSFRow dataRow = sheet.createRow(currentRowIndex);
        	
        	dataRow.createCell(0).setCellValue(reportData.getTransactionId());
        	dataRow.createCell(1).setCellValue(reportData.getOrderId());
        	dataRow.createCell(2).setCellValue(reportData.getTransactionDate());
        	dataRow.createCell(3).setCellValue(convertToString(reportData.getTotalCost()));
        	dataRow.createCell(4).setCellValue(reportData.getTotalUnits());
        	dataRow.createCell(5).setCellValue(reportData.getPaymentType());
        	dataRow.createCell(6).setCellValue(reportData.getUserId());
        }
        
        try {
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	private String convertToString(BigDecimal value) {
		return value == null ? "" : value.toString();
	}
}
