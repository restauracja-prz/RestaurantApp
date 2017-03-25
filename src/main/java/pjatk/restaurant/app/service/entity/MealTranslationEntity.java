package pjatk.restaurant.app.service.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEAL_TRANSLATION")
public class MealTranslationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MEAL_ID")
	private Long mealId;
	
	@Column(name="MEAL_DESC_PL")
	private String mealDescPl;
	
	@Column(name="COST")
	private BigDecimal cost;
	
	public Long getMealId() {
		return mealId;
	}
	
	public void setMealId(Long mealId) {
		this.mealId = mealId;
	}
	
	public String getMealDescPl() {
		return mealDescPl;
	}
	
	public void setMealDescPl(String mealDescPl) {
		this.mealDescPl = mealDescPl;
	}
	
	public BigDecimal getCost() {
		return cost;
	}
	
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
	
}
