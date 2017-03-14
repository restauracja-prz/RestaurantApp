package pjatk.restaurant.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")

public class ReportController {

	@RequestMapping
	private String home(Model model) {
		return "report";
	}
}