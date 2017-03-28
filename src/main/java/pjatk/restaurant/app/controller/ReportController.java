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
import pjatk.restaurant.app.service.TransactionDAO;
import pjatk.restaurant.app.service.entity.OrderDetailsEntity;
import pjatk.restaurant.app.service.entity.OrderEntity;
import pjatk.restaurant.app.service.entity.TransactionEntity;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private TransactionDAO transactionDAO;

	@RequestMapping
	public String home(Model model) {
		return "report";
	}
	
	@RequestMapping(value = "/orders-and-status-report")
	public String ordersAndStatusReport(Model model) {
		model.addAttribute("reportForm", new ReportModel());
		return "orderAndStatusReport";
	}
	
	@RequestMapping(value = "/sales-report")
	public String salesReport(Model model) {
		model.addAttribute("reportForm", new ReportModel());
		return "salesReport";
	}
	
	@RequestMapping(value = "/order-and-status-report")
	public String orderAndStatusReport(@ModelAttribute("reportForm") @Valid ReportModel reportForm,
			BindingResult result, Model model) {
		model.addAttribute("reportForm", new ReportModel());
		
		List<OrderEntity> reportResult = orderDAO.findOrderAndStatusReport(
				reportForm.getDateFrom(), reportForm.getDateTo());
		
		model.addAttribute("reportResult", reportResult);
		return "orderAndStatusReport";
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
	
	@RequestMapping(value = "/sales-report", method = RequestMethod.POST)
	public String salesReport(@ModelAttribute("reportForm") @Valid ReportModel reportForm,
			BindingResult result, Model model) {
		model.addAttribute("reportForm", new ReportModel());
		
		List<TransactionEntity> reportResult = transactionDAO.findSalesReport(
				reportForm.getDateFrom(), reportForm.getDateTo());
		
		model.addAttribute("reportResult", reportResult);
		return "salesReport";
	}
}