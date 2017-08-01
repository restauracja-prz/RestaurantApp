package pjatk.restaurant.app.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import pjatk.restaurant.app.entity.MenuEntity;
import pjatk.restaurant.app.entity.OrderStatus;
import pjatk.restaurant.app.entity.OrdersEntity;
import pjatk.restaurant.app.service.MealTypeDAO;
import pjatk.restaurant.app.service.MenuDAO;
import pjatk.restaurant.app.service.OrderDAO;
import pjatk.restaurant.app.service.OrderDetailsDAO;
import pjatk.restaurant.app.service.OrdersDAO;

@Controller
@Scope("session")
@SessionAttributes({"orderList", "menuItems"})
@RequestMapping("/order")
public class OrderController {

	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private OrdersDAO ordersDAO;
	
	@Autowired
	private OrderDetailsDAO orderDetailsDAO;
	
	@Autowired
	private MealTypeDAO mealTypeDAO;
	
	@Autowired
	private MenuDAO menuDAO;
	
	private List<MenuEntity> orders = new ArrayList<MenuEntity>();
	private BigDecimal orderCostSum;
	
	
	
	@ModelAttribute
	public void init(Model model) {
		if(model.containsAttribute("menuItems") == false) {
			model.addAttribute("menuItems", menuDAO.findVisibleFilteredMenu("%"));
		}
		
		model.addAttribute("mealTypes", mealTypeDAO.findMealTypes());
		model.addAttribute("orderList", orders);
	}
	
	

	@RequestMapping(value = "/filter/{mealType}", method = RequestMethod.GET)
	public String filter(@PathVariable String mealType, Model model){
		if(mealType.equals("all")) {
			mealType = "%";
		}
		model.addAttribute("menuItems", menuDAO.findVisibleFilteredMenu(mealType));
		
		return "redirect:/order"; 
	}
	
	@RequestMapping(value = "/ordermeal/{menuId}", method = RequestMethod.GET)
	public String mealOrder(@PathVariable Integer menuId, ModelMap model) {
		

		orderCostSum = new BigDecimal(0);
		
		orders.addAll(orderDAO.mealOrder(menuId));
		
		for (MenuEntity o : orders) {
			orderCostSum = orderCostSum.add(o.getUnitPrice());
		}
		
		
		model.addAttribute("orderList", "orders");
		
		
		return "redirect:/order"; 
	}
	
	@RequestMapping(value = "/delete/{indexNumber}", method = RequestMethod.GET)
	public String deleteOrder(@PathVariable Integer indexNumber, ModelMap model) {
	
		orderCostSum = orderCostSum.subtract(orders.get(indexNumber-1).getUnitPrice());
		orders.remove(indexNumber-1);
	
		return "redirect:/order";
	}
	
	
	@RequestMapping(value = "/submitorder")
	public String submitOrder(Model model) {
		
		int lastOrderId;
		if(ordersDAO.findLastOrderId().isEmpty()) {
			lastOrderId = 20170000;
		}
		else {
			List<OrdersEntity> lastOrder = orderDAO.findLastOrderId();
			
			lastOrderId = lastOrder.get(0).getOrderId();
		}
		
		ordersDAO.submitOrder(lastOrderId+1, orderCostSum, currentPrincipalName);
		orderDetailsDAO.insertOrderDetails(orders, lastOrderId+1);
		orders.removeAll(orders);
	
		
		return "redirect:/orderdetails";
	}
	
	
	@RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
	public String saveOrder(HttpServletRequest request) {
	
		OrdersEntity newOrder = new OrdersEntity();
		newOrder.setOrderDate(new Date());
		System.out.println("extra suma "+orderCostSum);
		newOrder.setOrderPriceSum(orderCostSum);
		newOrder.setOrderStatus(OrderStatus.NEW);
		newOrder.setUserId("aduchna");
//		newOrder.setUserId(request.getParameter("userId"));
		ordersDAO.save(newOrder);
		return "redirect:/orders";
	}
	

	@RequestMapping
	public String home(Model model) {
		return "order";
	}
	
	
}
