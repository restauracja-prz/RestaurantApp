package pjatk.restaurant.app.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACTIONS")
public class TransactionEntity {

	@Id
	@Column(name="TRANSACTION_ID")
	private int transactionId;
	
	@Column(name="ORDER_ID")
	private int orderId;
	
	@Column(name="TRANSACTION_DATE")
	private Date transactionDate;
	
	@Column(name="TOTAL_COST")
	private BigDecimal totalCost;
	
	@Column(name="TOTAL_UNITS")
	private int totalUnits;
	
	@Column(name="PAYMENT_TYPE")
	private char paymentType;
	
	@Column(name="USER_ID")
	private String userId;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public int getTotalUnits() {
		return totalUnits;
	}

	public void setTotalUnits(int totalUnits) {
		this.totalUnits = totalUnits;
	}

	public char getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(char paymentType) {
		this.paymentType = paymentType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
