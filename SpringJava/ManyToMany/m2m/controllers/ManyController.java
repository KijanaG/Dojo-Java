package com.garrett.m2m.controllers;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.garrett.m2m.models.Category;
import com.garrett.m2m.models.Product;
import com.garrett.m2m.services.CategoryService;
import com.garrett.m2m.services.ProductService;

@Controller
public class ManyController {
	private final CategoryService catServe;
	private final ProductService prodServe;
	
	public ManyController(CategoryService catServe, ProductService prodServe) {
		this.catServe = catServe;
		this.prodServe = prodServe;
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/PnC/newProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/products/new";
		} else {
			Product p = prodServe.createProduct(product);
			Long id = p.getId();
			return "redirect:/products/"+id;
		}
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category cat) {
		return "/PnC/newCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category cat, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/categories/new";
		} else {
			Category c = catServe.createCategory(cat);
			Long id = c.getId();
			return "redirect:/categories/"+id;
		}
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model, @ModelAttribute("category") Category cat) {
		Product p = prodServe.findProduct(id);
		List<Category> cats = catServe.allCategories();
		HashMap<String, Boolean> categories = prodServe.findCategories(p, cats);
		model.addAttribute("categories", categories);
		System.out.println(categories);
		model.addAttribute("name", p.getName());
		model.addAttribute("id", p.getId());
		return "/PnC/product.jsp";
	}
	
	@PostMapping("/products/{id}")
	public String addCategory(@PathVariable("id") Long id, @RequestParam("category") String category) {
		Product p = prodServe.findProduct(id);
		Category cat = catServe.catName(category);
		System.out.println("Category: "+cat);
		prodServe.addCategory(p, cat);
		return "redirect:/products/"+id;
	}
	
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model, @ModelAttribute("product") Product p) {
		Category cat = catServe.findCategory(id);
		List<Product> products = prodServe.allProducts();
		HashMap<String, Boolean> productos = catServe.findProducts(cat, products);
		model.addAttribute("products", productos);
		System.out.println("Get list of products "+productos);
		model.addAttribute("name", cat.getName());
		model.addAttribute("id", cat.getId());
		return "/PnC/category.jsp";
	}
	
	@PostMapping("/categories/{id}")
	public String addProduct(@PathVariable("id") Long id, @ModelAttribute("product") String product) {
		Category cat = catServe.findCategory(id);
		System.out.println("Category: "+cat);
		Product prod = prodServe.prodName(product);
		System.out.println("Product: "+prod);
		catServe.addProduct(cat, prod);
		return "redirect:/categories/"+id;
	}
}
