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
import pjatk.restaurant.app.entity.OrderCommentEntity;
import pjatk.restaurant.app.entity.OrdersEntity;
import pjatk.restaurant.app.service.OrderDAO;
import pjatk.restaurant.app.service.OrderDetailsDAO;

@Controller
@RequestMapping("/ordercomment")
public class OrderCommentController {
	
	@Autowired
	private OrderDAO orderDAO;
	
	
	@ModelAttribute
	public void init(Model model) {
		model.addAttribute("order", new OrdersEntity());
		model.addAttribute("commentForm", new OrderCommentEntity());
		
	}
	
	
	
	@RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
	public String ordercomment(@PathVariable Integer orderId, Model model) {
		
		
		
		model.addAttribute("order", orderDAO.findOrderById(orderId));
		
		
		return "ordercomment";
	}
	
	
	
	
	@RequestMapping
	public String home(Model model) {
		return "ordercomment";
	}
}