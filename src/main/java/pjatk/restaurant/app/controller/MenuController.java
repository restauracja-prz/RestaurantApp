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

import pjatk.restaurant.app.service.MenuDAO;
import pjatk.restaurant.app.service.entity.MenuEntity;
import pjatk.restaurant.app.service.entity.UserEntity;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuDAO menuDAO;
	
	@RequestMapping
	public String home(Model model) {
		model.addAttribute("menuItems", menuDAO.findFullMenu());
		model.addAttribute("menuForm", new MenuEntity());
		
		return "menu";
	}
	
	@RequestMapping(value = "/disable/{mealId}", method = RequestMethod.GET)
	public String mealDisable(@PathVariable Integer mealId, Model model) {
		menuDAO.mealDisable(mealId);
		
		return "redirect:/menu";
	}
	
	@RequestMapping(value = "/enable/{mealId}", method = RequestMethod.GET)
	public String mealEnable(@PathVariable Integer mealId, Model model) {
		menuDAO.mealEnable(mealId);
		
		return "redirect:/menu";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveOrUpdateMeal(@ModelAttribute("menuForm") @Valid MenuEntity menu,
			BindingResult result, Model model) {
		
		if (result.hasErrors()) {
            return "menu";
        }
	
		menu.setIsVisible("Y");
		menuDAO.menuSave(menu);
		
		return "redirect:/menu";
	}
}
