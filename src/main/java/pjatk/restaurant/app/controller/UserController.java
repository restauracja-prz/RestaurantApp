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

import pjatk.restaurant.app.entity.UserEntity;
import pjatk.restaurant.app.service.UserDAO;

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
	public String saveOrUpdateUser(@ModelAttribute("userForm") @Valid UserEntity user,
			BindingResult result, Model model) {
		
		if (result.hasErrors()) {
            return "user";
        }
		
		user.setIsEnabled(true);
		userDAO.userSaveOrUpdate(user);
		
		return "redirect:/user";
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
	
	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
	public String userEdit(@PathVariable String userId, Model model) {
		model.addAttribute("userForm", userDAO.findUserById(userId));
		
		return "user";
	}
	
	@RequestMapping(value = "/cancelEdit", method = RequestMethod.GET)
	public String cancelEdit(Model model) {
		return "redirect:/user";
	}
}
