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
	private int orderId;
	
	@Column(name = "MEAL_QUALITY")
	private Integer mealQuality;
	
	@Column(name = "SERVICE_QUICKNESS")
	private Integer serviceQuickness;
	
	@Column(name = "SERVICE_QUALITY")
	private Integer serviceQuality;
	
	@Column(name = "CLIENT_COMMENT")
	private String clientComment;

	public int getOrderRatingId() {
		return orderRatingId;
	}

	public void setOrderRatingId(int orderRatingId) {
		this.orderRatingId = orderRatingId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		orderId = orderId;
	}

	public Integer getMealQuality() {
		return mealQuality;
	}

	public void setMealQuality(Integer mealQuality) {
		this.mealQuality = mealQuality;
	}

	public Integer getServiceQuickness() {
		return serviceQuickness;
	}

	public void setServiceQuickness(Integer serviceQuickness) {
		this.serviceQuickness = serviceQuickness;
	}

	public Integer getServiceQuality() {
		return serviceQuality;
	}

	public void setServiceQuality(Integer serviceQuality) {
		this.serviceQuality = serviceQuality;
	}

	public String getClientComment() {
		return clientComment;
	}

	public void setClientComment(String clientComment) {
		this.clientComment = clientComment;
	}
	
}

	

