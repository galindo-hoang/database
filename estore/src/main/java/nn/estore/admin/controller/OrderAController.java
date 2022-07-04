package nn.estore.admin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import nn.estore.jpa.entity.Order;
import nn.estore.jpa.entity.OrderState;
import nn.estore.jpa.service.OrderService;
import nn.estore.jpa.service.OrderStateService;
import nn.estore.security.AuthService;
import nn.estore.service.SessionService;

@Controller
public class OrderAController {
	@Autowired
	OrderService orderService;
	@Autowired
	OrderStateService stateService;
	@Autowired
	SessionService sessionService;
	@Autowired
	AuthService authService;
	
	List<Order> getOrders(){
		Integer id = sessionService.get("sid");
		return orderService.findByOrderState(stateService.findById(id));
	}
	@RequestMapping({"/admin/order/index", "/admin/order/index/{sid}"})
	public String index(Model model, 
			@PathVariable("sid") Optional<Integer> sid) {
		sessionService.set("sid", sid.orElse(0));
		List<Order> list = this.getOrders();
		Order order = new Order();
		order.setMaster(authService.getUser());
		model.addAttribute("form", order);
		model.addAttribute("list", list);
		return "admin/order/index";
	}
	@RequestMapping("/admin/order/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long id) {
		Order order = orderService.findById(id);
		order.setMaster(authService.getUser());
		List<Order> list = this.getOrders();
		model.addAttribute("form", order);
		model.addAttribute("list", list);
		return "admin/order/index";
	}
	@RequestMapping("/admin/order/delete/{id}")
	public String delete(Model model, @PathVariable("id") Long id) {
		orderService.deleteById(id);
		List<Order> list = this.getOrders();
		model.addAttribute("form", new Order());
		model.addAttribute("list", list);
		return "admin/order/index";
	}

	@RequestMapping("/admin/order/update")
	public String update(Model model, 
			@ModelAttribute("form") Order entity) {
		orderService.update(entity);
		List<Order> list = this.getOrders();
		model.addAttribute("list", list);
		return "admin/order/index";
	}
	
	@ModelAttribute("states")
	public List<OrderState> getOrderStates(){
		return stateService.findAll();
	}
}
