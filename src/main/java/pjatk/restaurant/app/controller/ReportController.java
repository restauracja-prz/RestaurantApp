package pjatk.restaurant.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pjatk.restaurant.app.service.OrderDAO;
import pjatk.restaurant.app.service.entity.OrderDetailsEntity;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private OrderDAO orderDAO;

	@RequestMapping
	public String home(Model model) {
		return "report";
	}
	
	@RequestMapping(value = "/orders-and-status-report")
	public String ordersAndStatusesReport(Model model) {
		model.addAttribute("reportForm", new ReportModel());
		return "orderAndStatusReport";
	}
	
	@RequestMapping(value = "/orders-and-status-report", method = RequestMethod.POST)
	public String showOrdersAndStatusesReport(@ModelAttribute("reportForm") @Valid ReportModel reportForm,
			BindingResult result, Model model) {
		
		model.addAttribute("reportForm", reportForm);
		return "orderAndStatusReport";
	}
	
	@RequestMapping(value = "/order-details-report")
	public String orderDetailsReport(Model model) {
		model.addAttribute("reportForm", new ReportModel());
		return "orderDetailsReport";
	}
	
	@RequestMapping(value = "/order-details-report", method = RequestMethod.POST)
	public String showOrderDetailsReport(@ModelAttribute("reportForm") @Valid ReportModel reportForm,
			BindingResult result, Model model) {
		model.addAttribute("reportForm", new ReportModel());
		
		List<OrderDetailsEntity> reportResult = orderDAO.findOrderDetailsReport(
				reportForm.getDateFrom(), reportForm.getDateTo());
		
		model.addAttribute("reportResult", reportResult);
		return "orderDetailsReport";
	}
	
	@RequestMapping(value = "/sales-report")
	public String salesReport(Model model) {
		model.addAttribute("reportForm", new ReportModel());
		return "salesReport";
	}
}