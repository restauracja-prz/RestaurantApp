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
@Table(name="MEAL_TRANSLATION")
public class MealTranslationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MEAL_ID")
	private Long mealId;
	
	@NotNull
	@Size(min=2, max=64)
	@Column(name="MEAL_DESC_PL")
	private String mealDescPl;
	
	@Column(name = "MEAL_DESC_EN")
	private String mealDescEn;
	
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

	public String getMealDescEn() {
		return mealDescEn;
	}

	public void setMealDescEn(String mealDescEn) {
		this.mealDescEn = mealDescEn;
	}
}
