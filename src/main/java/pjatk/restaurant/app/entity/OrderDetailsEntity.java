package pjatk.restaurant.app.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ORDER_DETAILS")
public class OrderDetailsEntity {
	
	@Id
	@Column(name="ORDER_DETAILS_ID")
	private int orderDetailsId;
	
	@Column(name="ORDER_ID")
	private int orderId;
	
	@Column(name="DEVICE_ID")
	private String deviceId;
	
	@Column(name="MENU_ID")
	private Long menuId;
	
	@Column(name="UNIT_PRICE")
	private BigDecimal unitPrice;
	
	@Column(name="TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	@Column(name="CLIENT_COMMENT")
	private String clientComment;

	public int getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getClientComment() {
		return clientComment;
	}

	public void setClientComment(String clientComment) {
		this.clientComment = clientComment;
	}

}
