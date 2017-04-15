package pjatk.restaurant.app.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="MENU")
public class MenuEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MENU_ID")
	private Long menuId;
	
	@Column(name="MEAL_TYPE_ID")
	private Long mealTypeId;
	
	@NotNull
	@Column(name="UNIT_PRICE")
	private BigDecimal unitPrice;
	
	@Column(name="IS_VISIBLE")
	private String isVisible;

	@Valid
	@ManyToOne
	@JoinColumn(name = "MEAL_TRANSLATION_ID")
	private MealTranslationEntity mealTranslation;
	
	public Long getMealTypeId() {
		return mealTypeId;
	}
	
	public void setMealTypeId(Long mealTypeId) {
		this.mealTypeId = mealTypeId;
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
