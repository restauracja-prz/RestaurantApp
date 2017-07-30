package pjatk.restaurant.app.controller;

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
import pjatk.restaurant.app.service.OrdersDAO;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	private OrdersDAO orderDAO;
	
	@RequestMapping
	public String home(Model model,HttpServletRequest request) {
		
//		System.out.println("IS IT STATUS "+model.getModel().containsKey("orders"));
//		String status = request.getParameter("statusToFiltr");
//		System.out.println("CO JEST W STATUSIE "+status);
//		if(status != null && !status.equals("-") && !status.equals("DEFAULT")){
//		System.out.println("STUSIATKO "+status);
//		OrderStatus newStatus = OrderStatus.valueOf(status);
//		List<OrdersEntity> order = orderDAO.findOrdersByStatus(newStatus);
//		System.out.println("LISTA ORDEROW "+order.size());
////		model.getModelMap().put("orders", order);
//		model.addAttribute("orders", order);
//		}
//		else{
//			System.out.println("laduje co mam");
////			model.getModelMap().put("orders", orderDAO.findOrders());
			model.addAttribute("orders", orderDAO.findOrders());
//		}
		
		
		return "orders";
	}
	
	@RequestMapping(value="/changeStatus/{orderId}", method = RequestMethod.POST)
	public String changeStatus(@PathVariable Integer orderId, HttpServletRequest request, Model model) {
		String status = request.getParameter("status");
		System.out.println("STUSIATKO "+status);
		OrderStatus newStatus = OrderStatus.valueOf(status);
		OrdersEntity order = orderDAO.findOrderById(orderId);
		System.out.println("ORDEREK "+order.getOrderId());
		order.setOrderStatus(newStatus);
		orderDAO.save(order);
		return "redirect:/orders"; 
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
			System.out.println("STUSIATKO "+status);
			OrderStatus newStatus = OrderStatus.valueOf(status);
			List<OrdersEntity> order = orderDAO.findOrdersByStatus(newStatus);
			System.out.println("LISTA ORDEROW "+order.size());
//			model.getModelMap().put("orders", order);
			model.addAttribute("orders", order);
			}
			else{
				System.out.println("laduje co mam");
//				model.getModelMap().put("orders", orderDAO.findOrders());
				model.addAttribute("orders", orderDAO.findOrders());
			}
		return "ordersFiltered"; 
	}
		
}
