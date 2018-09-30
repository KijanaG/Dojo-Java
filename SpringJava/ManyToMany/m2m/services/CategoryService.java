package com.garrett.m2m.services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.garrett.m2m.models.Category;
import com.garrett.m2m.models.Product;
import com.garrett.m2m.repositories.CategoryRepo;

@Service
public class CategoryService {
	private final CategoryRepo catRepo;
	public CategoryService(CategoryRepo catRepo) {
		this.catRepo = catRepo;
	}
	
	public List<Category> allCategories() {
		return catRepo.findAll();
	}
	
	public Category createCategory(Category cat) {
		return catRepo.save(cat);
	}
	
	public Category findCategory(Long id) {
		Optional<Category> cat = catRepo.findById(id);
		if(cat.isPresent()) {
			return cat.get();
		} else {
			return null;
		}
	}
	
	public Category catName(String name) {
		Category c = null;
		List<Category> cats = catRepo.findAll();
		for(Category cat : cats) {
			if(cat.getName().equals(name)) {
				c = cat;
			}
		}
		if(c != null) {
			return c;
		} else {
			return null;
		}
	}
	
	public HashMap<String, Boolean> findProducts(Category cat, List<Product> products) {
		HashMap<String, Boolean> productos = new HashMap<String, Boolean>();
		List<Product> catProds = cat.getProducts();
		for(Product prod : catProds) {
			productos.put(prod.getName(), true);
		}
		for(Product prod : products) {
			if(!productos.containsKey(prod.getName())) {
				productos.put(prod.getName(), false);
			}
		}
		return productos;
	}
	
	public Category addProduct(Category cat, Product p) {
		List<Product> products = cat.getProducts();
		products.add(p);
		return catRepo.save(cat);
	}

}
