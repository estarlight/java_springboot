package com.esther.relationships.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esther.relationships.models.Category;
import com.esther.relationships.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{
	
	List<Product> findAll();

//	List<Product> findByCategoriesNotIn(List<Category> list, Category categories);
	
}
