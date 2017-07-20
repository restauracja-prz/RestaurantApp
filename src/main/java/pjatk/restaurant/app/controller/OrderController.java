package pjatk.restaurant.app.controller;

import java.util.ArrayList;
import java.util.Iterator;
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
@SessionAttributes("test")
@RequestMapping("/order")
public class OrderController {

	
	
	@Autowired
	private MenuDAO menuDAO;
	
	@Autowired
	private OrderDAO orderDAO;
	
	private List<MenuEntity> orders = new ArrayList<MenuEntity>();
	
	@ModelAttribute
	public void init(Model model) {
		model.addAttribute("menuItems", menuDAO.findVisibleMenu());
	}
	
	@RequestMapping(value = "/ordermeal/{menuId}", method = RequestMethod.GET)
	public String mealOrder(@PathVariable Integer menuId, Model model) {
		orders.addAll(orderDAO.mealOrder(menuId));
		model.addAttribute("test", orders);
		
		return "redirect:/order"; 
	}
	
	@RequestMapping(value = "/delete/{menuId}", method = RequestMethod.GET)
	public String deleteOrder(@PathVariable Long menuId, Model model) {
		
		Iterator<MenuEntity> it = orders.iterator();
		while(it.hasNext()) {
			MenuEntity menuEntity = it.next();
			if(menuEntity.getMenuId() == menuId) {
				it.remove();
				break;
			}
		}
		model.addAttribute("test", orders);
		return "redirect:/order";
	}
	
	
	
	
	@RequestMapping
	public String home(Model model) {
		return "order";
	}
	
	
}
