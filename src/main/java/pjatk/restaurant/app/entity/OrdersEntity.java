package pjatk.restaurant.app.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS")
public class OrdersEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDER_ID")
	private int orderId;
	
	@Column(name="ORDER_DATE")
	private Date orderDate;
	
	@Column(name="ORDER_PRICE_SUM")
	private BigDecimal orderPriceSum;
	
	public BigDecimal getOrderPriceSum() {
		return orderPriceSum;
	}

	public void setOrderPriceSum(BigDecimal orderPriceSum) {
		this.orderPriceSum = orderPriceSum;
	}

	@Column(name="ORDER_STATUS")
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@Column(name="USER_ID")
	private String userId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	
}
