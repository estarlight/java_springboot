package com.esther.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.esther.relationships.models.Category;
import com.esther.relationships.models.Product;
import com.esther.relationships.services.ProdCatService;

@Controller
public class ProdCatController {
	
	private final ProdCatService pcService;
	
	public ProdCatController(ProdCatService pcService) {
		this.pcService = pcService;
	}
	
	@RequestMapping("products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/product/new.jsp";
	}
	
	@PostMapping("products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
            return "/products/new.jsp";
        } else {
            pcService.newProduct(product);
            return "redirect:/products/new";
        }
	}
	
	@RequestMapping("categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/category/new.jsp";
	}
	
	@PostMapping("categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
            return "/categories/new.jsp";
        } else {
            pcService.newCategory(category);
            return "redirect:/categories/new";
        }
	}
	
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = pcService.findProduct(id);
		List<Category> productCategories = product.getCategories();
		List<Category> nonCategories = pcService.categoriesWithoutProduct(product);
		model.addAttribute("product", product);
		model.addAttribute("categories", productCategories);
		model.addAttribute("noncategories", nonCategories);
		return "/product/show.jsp";
	}
	
	@PostMapping("products/{id}")
	public String addCategory(@PathVariable("id") Long id, @RequestParam(value="categories") Category c) {
		Product product = pcService.findProduct(id);
		pcService.addCategory(product, c);
		return "redirect:/products/{id}";	
		
	}
	
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {

		Category category = pcService.findCategory(id);
		List<Product> categoryProducts = category.getProducts();
		List<Product> nonProducts = pcService.productsNotInCategory(category);
		model.addAttribute("category", category);
		model.addAttribute("products", categoryProducts);
		model.addAttribute("nonproducts", nonProducts);
		
		return "/category/show.jsp";
	}
	
	@PostMapping("categories/{id}")
	public String addProduct(@PathVariable("id") Long id, @RequestParam(value="products") Product p) {
		Category category = pcService.findCategory(id);
		pcService.addProduct(category, p);
		return "redirect:/categories/{id}";	
		
	}
	

}
