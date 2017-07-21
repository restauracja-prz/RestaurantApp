package pjatk.restaurant.app.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import pjatk.restaurant.app.entity.MenuEntity;
import pjatk.restaurant.app.service.MenuDAO;
import pjatk.restaurant.app.service.OrderDAO;

@Controller
@Scope("session")
@SessionAttributes({"orderList", "sum"})
@RequestMapping("/order")
public class OrderController {

	
	
	@Autowired
	private MenuDAO menuDAO;
	
	@Autowired
	private OrderDAO orderDAO;
	
	private List<MenuEntity> orders = new ArrayList<MenuEntity>();
	private BigDecimal orderCostSum;
	@ModelAttribute
	public void init(Model model) {
		model.addAttribute("menuItems", menuDAO.findVisibleMenu());
	}
	
	@RequestMapping(value = "/ordermeal/{menuId}", method = RequestMethod.GET)
	public String mealOrder(@PathVariable Integer menuId, Model model) {
		

		orderCostSum = new BigDecimal(0);
		
		orders.addAll(orderDAO.mealOrder(menuId));
		for (MenuEntity o : orders) {
			orderCostSum = orderCostSum.add(o.getUnitPrice());
		}
		
		model.addAttribute("sum", orderCostSum);
		model.addAttribute("orderList", orders);
		
		return "redirect:/order"; 
	}
	
	@RequestMapping(value = "/delete/{indexNumber}", method = RequestMethod.GET)
	public String deleteOrder(@PathVariable Integer indexNumber, Model model) {
	
		orderCostSum = orderCostSum.subtract(orders.get(indexNumber-1).getUnitPrice());
		orders.remove(indexNumber-1);
			
		model.addAttribute("sum", orderCostSum);
		model.addAttribute("orderList", orders);
		
		return "redirect:/order";
	}
	

	@RequestMapping
	public String home(Model model) {
		return "order";
	}
	
	
}
