package pjatk.restaurant.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pjatk.restaurant.app.entity.MenuEntity;
import pjatk.restaurant.app.service.MealTypeDAO;
import pjatk.restaurant.app.service.MenuDAO;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuDAO menuDAO;
	
	@Autowired
	private MealTypeDAO mealTypeDAO;
	
	@ModelAttribute
	public void init(Model model) {
		model.addAttribute("menuItems", menuDAO.findFullMenu());
		model.addAttribute("menuForm", new MenuEntity());
		model.addAttribute("mealTypes", mealTypeDAO.findTypes());
	}
	
	@RequestMapping
	public String home(Model model) {
		return "menu";
	}
	
	@RequestMapping(value = "/disable/{menuId}", method = RequestMethod.GET)
	public String mealDisable(@PathVariable Integer menuId, Model model) {
		menuDAO.mealDisable(menuId);
		
		return "redirect:/menu";
	}
	
	@RequestMapping(value = "/enable/{menuId}", method = RequestMethod.GET)
	public String mealEnable(@PathVariable Integer menuId, Model model) {
		menuDAO.mealEnable(menuId);
		
		return "redirect:/menu";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveOrUpdateMeal(@ModelAttribute("menuForm") @Valid MenuEntity menu,
			BindingResult result, Model model) {
		
		if (result.hasErrors()) {
            return "menu";
        }
	
		if (menu.getMenuId() == null) {
			menu.setIsVisible("Y");
		}
		
		menuDAO.menuSaveOrUpdate(menu);
		
		return "redirect:/menu";
	}
	
	@RequestMapping(value = "/edit/{menuId}", method = RequestMethod.GET)
	public String menuEdit(@PathVariable Long menuId, Model model) {
		MenuEntity menuToEdit = menuDAO.findMenuById(menuId);
		model.addAttribute("menuForm", menuToEdit);
		
		return "menu";
	}
	
	@RequestMapping(value = "/cancelEdit", method = RequestMethod.GET)
	public String cancelEdit(Model model) {
		return "redirect:/menu";
	}
}
