package pjatk.restaurant.app.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pjatk.restaurant.app.entity.MenuEntity;
import pjatk.restaurant.app.entity.OrdersEntity;
import pjatk.restaurant.app.service.OrderDetailsDAO;

@Controller
@Scope("request")
@RequestMapping("/orderdetails")
public class OrderDetailsController {

	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	
	
	@Autowired
	private OrderDetailsDAO orderDetailsDAO;
	
	
	private List<OrdersEntity> orders = new ArrayList<OrdersEntity>();
	private List<Integer> orderNumbers = new ArrayList<Integer>();
	
	
	
	@ModelAttribute
	public void init(Model model) {
		
		orders = orderDetailsDAO.findUserOrders(currentPrincipalName);
		if(orders.isEmpty() == false) {
		for (OrdersEntity o : orders) {
			orderNumbers.add(o.getOrderId());
		}
		model.addAttribute("orderNumbers", orderNumbers);
		}
		
		
		model.addAttribute("orderItems", orderDetailsDAO.findUserOrderDetails(currentPrincipalName));
		
	}	
	
	
	
	
	
	@RequestMapping
	public String home(Model model) {
		return "orderdetails";
	}
}
