package pjatk.restaurant.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pjatk.restaurant.app.service.MenuDAO;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuDAO menuDAO;
	
	@RequestMapping
	public String home(Model model) {
		model.addAttribute("menuItems", menuDAO.findVisibleMenu());
		
		return "menu";
	}
	
	
}
