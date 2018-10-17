package com.esther.relationships.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.esther.relationships.models.Category;
import com.esther.relationships.models.Dojo;
import com.esther.relationships.models.Product;
import com.esther.relationships.repositories.CategoryRepo;
import com.esther.relationships.repositories.ProductRepo;

@Service
public class ProdCatService {
	
	private final ProductRepo pRepo;
	private final CategoryRepo cRepo;
	
	public ProdCatService (ProductRepo pRepo, CategoryRepo cRepo) {
		this.pRepo = pRepo;
		this.cRepo = cRepo;
	}
	
	public List<Product> allProducts(){
		return pRepo.findAll();
	}
	
	public List<Category> allCategories(){
		return cRepo.findAll();
	}
	
	public Product newProduct(Product p) {
		return pRepo.save(p);
	}
	
	public Category newCategory(Category c) {
		return cRepo.save(c);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> p = pRepo.findById(id);
		if (p.isPresent()) {
			return p.get();
		} else {
			return null;
		}
	}
	
	public Category findCategory(Long id) {
		Optional<Category> c = cRepo.findById(id);
		if (c.isPresent()) {
			return c.get();
		} else {
			return null;
		}
	}

	
	public List<Category> categoriesWithoutProduct(Product product) {
		
		List<Category> allCategories = cRepo.findAll();
		List<Category> pCategories = product.getCategories();
		
		for(Category c : pCategories) {
			allCategories.remove(c);
		}
		
		return allCategories;
	}
	
	public List<Product> productsNotInCategory(Category category){
		
		List<Product> allProducts = pRepo.findAll();
		List<Product> cProducts = category.getProducts();
		
		for (Product p : cProducts) {
			allProducts.remove(p);
		}
		return allProducts;

	}
	
	
	public void addCategory(Product p, Category c) {
		List<Category> list = p.getCategories();
		list.add(c);
		p.setCategories(list);
		pRepo.save(p);
	}
	
	public void addProduct(Category c, Product p) {
		List<Product> list = c.getProducts();
		list.add(p);
		c.setProducts(list);
		cRepo.save(c);
	}


}
