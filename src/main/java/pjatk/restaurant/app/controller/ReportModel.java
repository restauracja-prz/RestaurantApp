package pjatk.restaurant.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class ReportModel {

	@NotNull
	private String dateFrom;
	
	@NotNull
	private String dateTo;
	
	public String getDateFrom() {
		return dateFrom;
	}
	
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	
	public String getDateTo() {
		return dateTo;
	}
	
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
	public Date parseDateFrom() {
		try {
			return new SimpleDateFormat("MM/dd/yyyy").parse(dateFrom);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Date parseDateTo() {
		try {
			return new SimpleDateFormat("MM/dd/yyyy").parse(dateTo);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
