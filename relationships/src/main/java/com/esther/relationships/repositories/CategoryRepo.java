package com.esther.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esther.relationships.models.Category;
import com.esther.relationships.models.Product;

@Repository
public interface CategoryRepo extends CrudRepository <Category,Long>{
	
	List<Category> findAll();
	
//	List<Category> findByProductsNotIn(List<Product> list);

}
