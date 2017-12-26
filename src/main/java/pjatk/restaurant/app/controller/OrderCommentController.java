package pjatk.restaurant.app.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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
import pjatk.restaurant.app.service.OrderCommentDAO;

@Controller
@RequestMapping("/ordercomment")
public class OrderCommentController {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private OrderCommentDAO orderCommentDAO;
	
	@RequestMapping
	public String home(Model model) {
		return "ordercomment";
	}

	
	
	
	@ModelAttribute
	public void init(Model model) {
		List<Integer> numberList = new ArrayList<Integer>();
		numberList.add(1);
		numberList.add(2);
		numberList.add(3);
		numberList.add(4);
		numberList.add(5);
		
		model.addAttribute("numberList", numberList);
		model.addAttribute("commentForm", new OrderCommentEntity());
		
	}
	
	
	
	@RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
	public String ordercomment(@ModelAttribute("commentForm") @Valid OrderCommentEntity commentForm, @PathVariable Integer orderId, Model model) {
		//OrderCommentEntity clientComment = new OrderCommentEntity();
		
		if(orderCommentDAO.findOrderComment(orderId).isEmpty() == false) {

			return "redirect:/orderdetails";
		}
		
		if(commentForm.getClientComment() != null) {
		model.addAttribute("order", orderDAO.findOrderById(orderId));
		orderCommentDAO.insertComment(orderId, commentForm.getMealQuality(), commentForm.getServiceQuickness(), commentForm.getServiceQuality(), commentForm.getClientComment());
			return "redirect:/orderdetails";
		}
		return "ordercomment";
		
		//return "redirect:/orderdetails";
	}
	
}
	
	
