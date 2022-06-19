package ptq.estore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ptq.estore.jpa.entity.Product;
import ptq.estore.jpa.service.ProductService;
import ptq.estore.service.MailService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@RequestMapping("/product/category/{id}")
	public String findByCategoryId(@PathVariable("id") Integer id ,Model model, @RequestParam("p") Optional<Integer> popt) {
		Integer p=popt.orElse(0);
		Page<Product> page=productService.findByCategory(id,PageRequest.of(p, 6));
		model.addAttribute("page", page);
		return "product/list";
	}
	
	@RequestMapping("/product/search")
	public String findByName(Model model,@RequestParam("keyword") String name, @RequestParam("p") Optional<Integer> popt) {
		Integer p=popt.orElse(0);
		Page<Product> page=productService.findByName(name,PageRequest.of(p, 6));
		model.addAttribute("page", page);
		return "product/list";
	}
	
	
	
	@RequestMapping("/product/discount")
	public String findByDiscount(Model model, @RequestParam("p") Optional<Integer> popt) {
		Integer p=popt.orElse(0);
		Page<Product> page=productService.findByDiscount(PageRequest.of(p, 6));
		model.addAttribute("page", page);
		return "product/list";
	}
	
	@RequestMapping("/product/best")
	public String findByBest(Model model, @RequestParam("p") Optional<Integer> popt) {
		Integer p=popt.orElse(0);
		Page<Product> page=productService.findByBest(PageRequest.of(p, 6));
		model.addAttribute("page", page);
		return "product/list";
	}
	
	@RequestMapping("/product/favorite")
	public String findByFavorite(Model model, @RequestParam("p") Optional<Integer> popt) {
		Integer p=popt.orElse(0);
		Page<Product> page=productService.findByFavorite(PageRequest.of(p, 6));
		model.addAttribute("page", page);
		return "product/list";
	}
	
	@RequestMapping("/product/latest")
	public String findByLatest(Model model, @RequestParam("p") Optional<Integer> popt) {
		Integer p=popt.orElse(0);
		Page<Product> page=productService.findByLatest(PageRequest.of(p, 6));
		model.addAttribute("page", page);
		return "product/list";
	}
	
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product product=productService.findById(id);
		model.addAttribute("item", product);
		return "product/detail";
	}
	
	//API
	@ResponseBody
	@RequestMapping("/product/like/{id}")
	public Object like(@PathVariable("id") Integer id, Model model) {
		Product product=productService.findById(id);
		product.setLikeCount(product.getLikeCount()+1);
		model.addAttribute("item",product);
		productService.update(product);
		return product.getLikeCount();
		
	}
	
	
	@Autowired
	MailService mailService;
	@ResponseBody
	@RequestMapping("/product/send")
	public Object send(@RequestParam("id") Integer id,@RequestParam("email") String email,Model model) {
		mailService.sendProduct(email, id);
		return "OK";
		
	}
	
	
	
	
}
