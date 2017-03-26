package pjatk.restaurant.app.controller;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class ReportModel {

	@NotNull
	private Date dateFrom;
	
	@NotNull
	private Date dateTo;
	
	public Date getDateFrom() {
		return dateFrom;
	}
	
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	
	public Date getDateTo() {
		return dateTo;
	}
	
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
}
