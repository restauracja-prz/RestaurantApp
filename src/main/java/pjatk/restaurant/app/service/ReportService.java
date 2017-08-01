package pjatk.restaurant.app.service;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pjatk.restaurant.app.entity.OrderDetailsEntity;
import pjatk.restaurant.app.entity.OrdersEntity;
import pjatk.restaurant.app.entity.TransactionEntity;

@Service
public class ReportService {
	
	@Autowired
	private OrdersDAO ordersDAO;
	
	@Autowired
	private TransactionDAO transactionDAO;

	public void exportOrderDetailsReport(Date dateFrom, Date dateTo, OutputStream outputStream) {
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        
        int currentRowIndex = 0;
        XSSFRow headerRow = sheet.createRow(currentRowIndex);
        
        headerRow.createCell(0).setCellValue("Order Id");
        headerRow.createCell(1).setCellValue("Device Id");
        headerRow.createCell(2).setCellValue("Menu Id");
        headerRow.createCell(3).setCellValue("Unit Price");
       
        
        List<OrderDetailsEntity> reportDataList = ordersDAO.findOrderDetailsReport(dateFrom, dateTo);
        
        for (OrderDetailsEntity reportData : reportDataList) {
        	currentRowIndex++;
        	
        	XSSFRow dataRow = sheet.createRow(currentRowIndex);
        	
        	dataRow.createCell(0).setCellValue(reportData.getOrder().getOrderId());
        	dataRow.createCell(1).setCellValue(reportData.getDeviceId());
        	dataRow.createCell(2).setCellValue(reportData.getMenu().getMenuId());
        	dataRow.createCell(3).setCellValue(convertToString(reportData.getUnitPrice()));
        	
        }
        
        for (int i = 0; i <= 4; i++) {
        	sheet.autoSizeColumn(i);
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
        headerRow.createCell(1).setCellValue("Order Date         ");
        headerRow.createCell(2).setCellValue("Order Status");
        headerRow.createCell(3).setCellValue("User Id");
        headerRow.createCell(4).setCellValue("Client Comment");
        
     
        
        List<OrdersEntity> reportDataList = ordersDAO.findOrderAndStatusReport(dateFrom, dateTo);
        
        for (OrdersEntity reportData : reportDataList) {
        	currentRowIndex++;
        	
        	XSSFRow dataRow = sheet.createRow(currentRowIndex);
        	
        	dataRow.createCell(0).setCellValue(reportData.getOrderId());
        	
        	XSSFCell orderDateCell = dataRow.createCell(1);
        	createDateCellValue(workbook, orderDateCell, reportData.getOrderDate());

        	dataRow.createCell(2).setCellValue(reportData.getOrderStatus().toString());
        	dataRow.createCell(3).setCellValue(reportData.getUserId());
        	
        	   if (reportData.getClientComment() != null) {
           		dataRow.createCell(4).setCellValue(reportData.getClientComment());
           	}
        }
        
        for (int i = 0; i <= 3; i++) {
        	sheet.autoSizeColumn(i);
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
        	
        	XSSFCell orderDateCell = dataRow.createCell(2);
        	createDateCellValue(workbook, orderDateCell, reportData.getTransactionDate());
        	
        	dataRow.createCell(3).setCellValue(convertToString(reportData.getTotalCost()));
        	dataRow.createCell(4).setCellValue(reportData.getTotalUnits());
        	dataRow.createCell(5).setCellValue(reportData.getPaymentType());
        	dataRow.createCell(6).setCellValue(reportData.getUserId());
        }
        
        for (int i = 0; i <= 6; i++) {
        	sheet.autoSizeColumn(i);
        }
        
        try {
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void createDateCellValue(XSSFWorkbook workbook, XSSFCell cell, Date date) {
		if (date == null) {
			return;
		}
		
		CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("m/d/yy h:mm"));
        cell.setCellValue(date);
        cell.setCellStyle(cellStyle);
	}
	
	private String convertToString(BigDecimal value) {
		return value == null ? "" : value.toString();
	}
}
