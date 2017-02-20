package pjatk.restaurant.app.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pjatk.restaurant.app.service.user.UserDAO;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@RequestMapping
	private String home(Model model) {
		model.addAttribute("users", userDAO.findAll());
		
		return "user";
	}
}
