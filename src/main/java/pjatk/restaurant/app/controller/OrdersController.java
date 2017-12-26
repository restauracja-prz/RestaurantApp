package pjatk.restaurant.app.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import pjatk.restaurant.app.entity.OrderStatus;
import pjatk.restaurant.app.entity.OrdersEntity;
import pjatk.restaurant.app.service.OrderDAO;
import pjatk.restaurant.app.service.OrdersDAO;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private OrdersDAO ordersDAO;
	
	@RequestMapping
	public String home(Model model,HttpServletRequest request) {
			model.addAttribute("orders", ordersDAO.findOrders());
		return "orders";
	}
	
	@RequestMapping(value="/changeStatus/{orderId}", method = RequestMethod.POST)
	public String changeStatus(@PathVariable Integer orderId, HttpServletRequest request, Model model) {
		changeOrderStatus(orderId, request);
		return "redirect:/ordersFiltered";
	}
	
	@RequestMapping(value="/changeStatusWhileOrder/{orderId}", method = RequestMethod.POST)
	public String changeStatusWhileOrder(@PathVariable Integer orderId, HttpServletRequest request, Model model) {
		changeOrderStatus(orderId, request);
		return "redirect:/order"; 
	}

	private void changeOrderStatus(Integer orderId, HttpServletRequest request) {
		String status = request.getParameter("status");
		OrderStatus newStatus = OrderStatus.valueOf(status);
		OrdersEntity order = orderDAO.findOrderById(orderId);
		order.setOrderStatus(newStatus);
		orderDAO.save(order);
	}

	
	
}
