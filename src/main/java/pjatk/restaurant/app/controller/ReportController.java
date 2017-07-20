package pjatk.restaurant.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pjatk.restaurant.app.entity.OrderDetailsEntity;
import pjatk.restaurant.app.entity.OrdersEntity;
import pjatk.restaurant.app.entity.TransactionEntity;
import pjatk.restaurant.app.service.OrdersDAO;
import pjatk.restaurant.app.service.ReportService;
import pjatk.restaurant.app.service.TransactionDAO;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private OrdersDAO ordersDAO;
	
	@Autowired
	private TransactionDAO transactionDAO;
	
	@Autowired
	private ReportService reportService;

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
	
	@RequestMapping(value = "/orders-and-status-report", method = RequestMethod.POST, params = "action_show_report")
	public String showOrderAndStatusReport(@ModelAttribute("reportForm") @Valid ReportModel reportForm,
			BindingResult result, Model model) {
		
		model.addAttribute("reportForm", reportForm);
		
		if (!result.hasErrors()) {
			List<OrdersEntity> reportResult = ordersDAO.findOrderAndStatusReport(
					reportForm.parseDateFrom(), reportForm.parseDateTo());
			
			model.addAttribute("reportResult", reportResult);
		}
		
		return "orderAndStatusReport";
	}
	
	@RequestMapping(value = "/order-details-report", method = RequestMethod.GET)
	public String orderDetailsReport(Model model) {
		model.addAttribute("reportForm", new ReportModel());

		return "orderDetailsReport";
	}
	
	@RequestMapping(value = "/order-details-report", method = RequestMethod.POST, params = "action_show_report")
	public String showOrderDetailsReport(@ModelAttribute("reportForm") @Valid ReportModel reportForm,
			BindingResult result, Model model) {
		
		model.addAttribute("reportForm", reportForm);
		
		if (!result.hasErrors()) {
			List<OrderDetailsEntity> reportResult = ordersDAO.findOrderDetailsReport(
					reportForm.parseDateFrom(), reportForm.parseDateTo());
			
			model.addAttribute("reportResult", reportResult);
		}
		
		return "orderDetailsReport";
	}
	
	@RequestMapping(value = "/sales-report", method = RequestMethod.POST, params = "action_show_report")
	public String showSalesReport(@ModelAttribute("reportForm") @Valid ReportModel reportForm,
			BindingResult result, Model model) {
		
		model.addAttribute("reportForm", reportForm);
		
		if (!result.hasErrors()) {
			List<TransactionEntity> reportResult = transactionDAO.findSalesReport(
					reportForm.parseDateFrom(), reportForm.parseDateTo());
			
			model.addAttribute("reportResult", reportResult);
		}
		
		return "salesReport";
	}
	
	@RequestMapping(value = "/order-details-report", method = RequestMethod.POST, params = "action_export_report", 
			produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public String exportOrderDetailsReport(@ModelAttribute("reportForm") @Valid ReportModel reportForm,
			BindingResult result, Model model, HttpServletResponse response) {
		
		model.addAttribute("reportForm", reportForm);
		
		if (!result.hasErrors()) {
			try {
				response.setHeader("Content-Disposition", "attachment; filename=order_details_report.xlsx");
				reportService.exportOrderDetailsReport(reportForm.parseDateFrom(), reportForm.parseDateTo(), 
						response.getOutputStream());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		return "orderDetailsReport";
	}
	
	@RequestMapping(value = "/orders-and-status-report", method = RequestMethod.POST, params = "action_export_report", 
			produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public String exportOrdersAndStatusReport(@ModelAttribute("reportForm") @Valid ReportModel reportForm,
			BindingResult result, Model model, HttpServletResponse response) {
		
		model.addAttribute("reportForm", reportForm);
		
		if (!result.hasErrors()) {
			try {
				response.setHeader("Content-Disposition", "attachment; filename=order_and_status_report.xlsx");
				reportService.exportOrdersAndStatusReport(reportForm.parseDateFrom(), reportForm.parseDateTo(), 
						response.getOutputStream());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		return "orderAndStatusReport";
	}
	
	@RequestMapping(value = "/sales-report", method = RequestMethod.POST, params = "action_export_report", 
			produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public String exportSalesReport(@ModelAttribute("reportForm") @Valid ReportModel reportForm,
			BindingResult result, Model model, HttpServletResponse response) {
		
		model.addAttribute("reportForm", reportForm);
		
		if (!result.hasErrors()) {
			try {
				response.setHeader("Content-Disposition", "attachment; filename=seles_report.xlsx");
				reportService.exportSalesReport(reportForm.parseDateFrom(), reportForm.parseDateTo(), 
						response.getOutputStream());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		return "salesReport";
	}
}