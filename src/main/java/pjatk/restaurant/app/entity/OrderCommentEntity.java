package pjatk.restaurant.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ORDER_RATING")
public class OrderCommentEntity {
	
	@Id
	@Column(name="ORDER_RATING_ID")
	private int orderRatingId;	

	@Column(name="ORDER_ID")
	private int OrderId;
	
	@Column(name = "MEAL_QUALITY")
	private String mealQuality;
	
	@Column(name = "SERVICE_QUICKNESS")
	private String serviceQuickness;
	
	@Column(name = "SERVICE_QUALITY")
	private String serviceQuality;
	
	@Column(name = "CLIENT_COMMENT")
	private String clientComment;

	public int getOrderRatingId() {
		return orderRatingId;
	}

	public void setOrderRatingId(int orderRatingId) {
		this.orderRatingId = orderRatingId;
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public String getMealQuality() {
		return mealQuality;
	}

	public void setMealQuality(String mealQuality) {
		this.mealQuality = mealQuality;
	}

	public String getServiceQuickness() {
		return serviceQuickness;
	}

	public void setServiceQuickness(String serviceQuickness) {
		this.serviceQuickness = serviceQuickness;
	}

	public String getServiceQuality() {
		return serviceQuality;
	}

	public void setServiceQuality(String serviceQuality) {
		this.serviceQuality = serviceQuality;
	}

	public String getClientComment() {
		return clientComment;
	}

	public void setClientComment(String clientComment) {
		this.clientComment = clientComment;
	}
	
}

	

