package com.garrett.m2m.services;

import java.util.List;
import java.util.Optional;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.garrett.m2m.models.Category;
import com.garrett.m2m.models.Product;
import com.garrett.m2m.repositories.ProductRepo;

@Service
public class ProductService {
	private final ProductRepo productRepo;
	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> p = productRepo.findById(id);
		if(p.isPresent()) {
			return p.get();
		} else {
			return null;
		}
	}
	
	public Product prodName(String name) {
		Product p = null;
		System.out.println("Hello");
		List<Product> prods = productRepo.findAll();
		for(Product prod : prods) {
			if(prod.getName().equals(name)) {
				p = prod;
			}
		}
		if(p != null) {
			return p;
		} else {
			return null;
		}
	}
	
	public HashMap<String, Boolean> findCategories(Product p, List<Category> cats) {
		HashMap<String, Boolean> categories = new HashMap<String, Boolean>();
		List<Category> pCats = p.getCategories();
		for(Category cat : pCats) {
			categories.put(cat.getName(), true);
		}
		for(Category cat : cats) {
			if(!categories.containsKey(cat.getName())) {
				categories.put(cat.getName(), false);
			}
		}
		return categories;
	}
	
	public Product addCategory(Product p, Category cat) {
		List<Category> cats = p.getCategories();
		cats.add(cat);
		return productRepo.save(p);
	}

}
