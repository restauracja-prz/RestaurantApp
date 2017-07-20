package pjatk.restaurant.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pjatk.restaurant.app.service.OrdersDAO;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	private OrdersDAO orderDAO;
	
	@RequestMapping
	public String home(Model model) {
		model.addAttribute("orders", orderDAO.findOrders());
		
		return "orders";
	}
}
