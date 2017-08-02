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
@Table(name="MEAL_TYPE_DICTIONARY")
public class MealTypeEntity {
	
	@Id
	@Column(name="MEAL_TYPE_ID")
	private Long mealTypeId;
	

	@Column(name="MEAL_TYPE_PL")
	private String mealTypePl;
	
	@Column(name = "MEAL_TYPE_EN")
	private String mealTypeEn;

	public Long getMealTypeId() {
		return mealTypeId;
	}

	public void setMealTypeId(Long mealTypeId) {
		this.mealTypeId = mealTypeId;
	}

	public String getMealTypePl() {
		return mealTypePl;
	}

	public void setMealTypePl(String mealTypePl) {
		this.mealTypePl = mealTypePl;
	}

	public String getMealTypeEn() {
		return mealTypeEn;
	}

	public void setMealTypeEn(String mealTypeEn) {
		this.mealTypeEn = mealTypeEn;
	}

	
	
}

	

