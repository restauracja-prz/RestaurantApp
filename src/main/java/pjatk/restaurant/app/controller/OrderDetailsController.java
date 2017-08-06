package pjatk.restaurant.app.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
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

import pjatk.restaurant.app.entity.MenuEntity;
import pjatk.restaurant.app.entity.OrderDetailsEntity;
import pjatk.restaurant.app.entity.OrderStatus;
import pjatk.restaurant.app.entity.OrdersEntity;
import pjatk.restaurant.app.service.OrderDAO;
import pjatk.restaurant.app.service.OrderDetailsDAO;
import pjatk.restaurant.app.service.OrdersDAO;

@Controller
@Scope("request")
@RequestMapping("/orderdetails")
public class OrderDetailsController {

	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	
	
	@Autowired
	private OrderDetailsDAO orderDetailsDAO;
	
	@Autowired
	private OrdersDAO orderDAO;
	
	
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
		System.out.println("co my tutaj mamy "+authentication.getPrincipal());
		System.out.println("USER??? "+currentPrincipalName);
		model.addAttribute("orderItems", orderDetailsDAO.findUserOrderDetails(currentPrincipalName));
		
	}	
	
	
	@RequestMapping(value="/filtrByStatus", method = RequestMethod.POST)
	public String filtrByStatus(HttpServletRequest request, Model model) {
//		ModelAndView modelTmp = new ModelAndView("redirect:/orders");
//		String status = request.getParameter("statusToFiltr");
//		System.out.println("STUSIATKO "+status);
//		OrderStatus newStatus = OrderStatus.valueOf(status);
//		List<OrdersEntity> order = orderDAO.findOrdersByStatus(newStatus);
//		System.out.println("LISTA ORDEROW "+order.size());
//		modelTmp.addObject("orders", order);
//		return new ModelAndView(new RedirectView(home(model, request)));
		
		String status = request.getParameter("statusToFiltr");
		if(status != null && !status.equals("-") && !status.equals("DEFAULT")){
			OrderStatus newStatus = OrderStatus.valueOf(status);
			List<OrdersEntity> order = orderDAO.findOrdersByStatus(newStatus);
			for(OrdersEntity o :order) {
			List<OrderDetailsEntity> orderDetails = orderDetailsDAO.findOrderDetailsByOrderId(o.getOrderId());
			o.setOrderDetails(new HashSet<OrderDetailsEntity>(orderDetails));
			}
			for(OrdersEntity ot : order) {
				System.out.println("...."+ot.getOrderId()+" size zamowieni "+ot.getOrderDetails().size());
			}
			model.addAttribute("ord", order);
			
			}
			else{
//				model.getModelMap().put("orders", orderDAO.findOrders());
				model.addAttribute("orders", orderDetailsDAO.findOrderDetails());
			}
		return "ordersFiltered"; 
	}
	
	
	
	
	
	@RequestMapping
	public String home(Model model) {
		return "orderdetails";
	}
}
