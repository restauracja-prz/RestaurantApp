package pjatk.restaurant.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/order")
public class OrderController {

	@RequestMapping
	public String home() {
		return "order";
	}
}
