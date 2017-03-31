package pjatk.restaurant.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pjatk.restaurant.app.service.OrderDAO;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@RequestMapping
	private String home(Model model) {
		model.addAttribute("orders", orderDAO.findOrderEntity());
		
		return "orders";
	}
}
