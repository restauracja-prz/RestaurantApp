package pjatk.restaurant.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pjatk.restaurant.app.service.OrderDAO;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@RequestMapping
	private String home(Model model) {
		model.addAttribute("orderStatus", orderDAO.findOrderEntity());
		
		return "order";
	}
}
