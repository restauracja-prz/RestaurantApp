package pjatk.restaurant.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pjatk.restaurant.app.entity.MenuEntity;
import pjatk.restaurant.app.service.OrdersDAO;
import pjatk.restaurant.app.service.UserDAO;

@Controller
@Scope("session")
@SessionAttributes({"currentUser"})
@RequestMapping("/")
public class HomeController {

	
	@Autowired
	private UserDAO userDAO;

	@ModelAttribute
	public void init(Model model) {
		
		
		model.addAttribute("currentUser", userDAO.findUser().get(0));
		
		}
	
	
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping
	public String home(Model model) {
//		if(userDAO.findUser().get(0).getUserPosition().equals("client")){
//			return "redirect:/order";
//		}
		return "index";
	}
}
