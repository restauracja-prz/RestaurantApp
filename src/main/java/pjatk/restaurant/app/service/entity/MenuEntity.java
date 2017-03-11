package pjatk.restaurant.app.service.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MENU")
public class MenuEntity {

	@Id
	@Column(name="MEAL_ID")
	private Long mealId;
	
	@Column(name="MEAL_TYPE_ID")
	private Long mealTypeId;
	
	@Column(name="UNIT_PRICE")
	private BigDecimal unitPrice;
	
	@Column(name="IS_VISIBLE")
	private String isVisible;

	@ManyToOne
	@JoinColumn(name = "MEAL_TRANSLATION_ID")
	private MealTranslationEntity mealTranslation;
	
	public Long getMealTypeId() {
		return mealTypeId;
	}
	
	public void setMealTypeId(Long mealTypeId) {
		this.mealTypeId = mealTypeId;
	}
	
	public Long getMealId() {
		return mealId;
	}
	
	public void setMealId(Long mealId) {
		this.mealId = mealId;
	}
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String getIsVisible() {
		return isVisible;
	}
	
	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}

	public MealTranslationEntity getMealTranslation() {
		return mealTranslation;
	}

	public void setMealTranslation(MealTranslationEntity mealTranslation) {
		this.mealTranslation = mealTranslation;
	}

}
