package com.esther.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esther.dojooverflow.models.TagQuestions;

@Repository
public interface TagQuestionRepository extends CrudRepository<TagQuestions, Long>{
	
	List<TagQuestions> findAll();

}
