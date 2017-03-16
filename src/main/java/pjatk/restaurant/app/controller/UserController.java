package pjatk.restaurant.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pjatk.restaurant.app.service.UserDAO;
import pjatk.restaurant.app.service.entity.UserEntity;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDAO userDAO;

	
	@ModelAttribute
	public void init(Model model) {
		model.addAttribute("users", userDAO.findAll());
		model.addAttribute("userForm", new UserEntity());
	}
	
	@RequestMapping
	public String home(Model model) {
		return "user";
	}
		
	@RequestMapping(method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("userForm") UserEntity user,
		BindingResult result, Model model) {
		
		userDAO.userSave(user);
		
		return "user";
	}
	
	@RequestMapping(value = "/disable/{userId}", method = RequestMethod.GET)
	public String userDisable(@PathVariable String userId, Model model) {
		userDAO.userDisable(userId);
		
		return "redirect:/user";
	}
	
	@RequestMapping(value = "/enable/{userId}", method = RequestMethod.GET)
	public String userEnable(@PathVariable String userId, Model model) {
		userDAO.userEnable(userId);
		
		return "redirect:/user";
	}

}
