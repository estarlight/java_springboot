package com.esther.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.esther.dojooverflow.models.Answer;
import com.esther.dojooverflow.models.Question;
import com.esther.dojooverflow.models.Tag;
import com.esther.dojooverflow.models.TagQuestions;
import com.esther.dojooverflow.repositories.AnswerRepository;
import com.esther.dojooverflow.repositories.QuestionRepository;
import com.esther.dojooverflow.repositories.TagQuestionRepository;
import com.esther.dojooverflow.repositories.TagRepository;


@Service
public class OverflowService {
	
	private final QuestionRepository qRepo;
	private final AnswerRepository aRepo;
	private final TagRepository tRepo;
	private final TagQuestionRepository tQRepo;
	
	public OverflowService(QuestionRepository qRepo, AnswerRepository aRepo, TagRepository tRepo, TagQuestionRepository tQRepo) {
		this.qRepo = qRepo;
		this.aRepo = aRepo;
		this.tRepo = tRepo;
		this.tQRepo = tQRepo;
	}
	
	public List<Question> allQuestions(){
		return qRepo.findAll();
	}
	
	public List<Answer> allAnswers(){
		return aRepo.findAll();
	}
	
	public List<Tag> allTags(){
		return tRepo.findAll();
	}
	
	public Question findQuestion(Long id) {
		Optional<Question> q = qRepo.findById(id);
		if (q.isPresent()) {
			return q.get();
		} else {
			return null;
		}
	}
	
	public Answer findAnswer(Long id) {
		Optional<Answer> a = aRepo.findById(id);
		if (a.isPresent()) {
			return a.get();
		} else {
			return null;
		}
	}
	
	public Tag findTag(Long id) {
		Optional<Tag> t = tRepo.findById(id);
		if (t.isPresent()) {
			return t.get();
		} else {
			return null;
		}
	}
	
	public Tag findTagBySubject(String tag) {
		Optional<Tag> t = tRepo.findBySubjectLike(tag);
		if (t.isPresent()) {
			return t.get();
		} else {
			return null;
		}
	}
	
	public Question addQuestion(Question q) {
		System.out.println("addquestion invoked from service");
		return qRepo.save(q);
	}
	
	public Answer addAnswer(String a) {
		Answer answer = new Answer();
		answer.setAnswer(a);
		return aRepo.save(answer);
	}
	
	public TagQuestions addTQ(TagQuestions t) {
		return tQRepo.save(t);
	}
	
	
//	public void addTags(Question question, ArrayList<String> tagsToAdd) {
//		
//		
//		List<Tag> tagList = question.getTags();
//		System.out.println(tagList);
//		
//		for (String t : tagsToAdd) {
//			Tag newTag = new Tag();
//			newTag.setSubject(t);
//			Tag savedTag = tRepo.save(newTag);
//			tagList.add(savedTag);
//		}
//		
//		question.setTags(tagList);
//		qRepo.save(question);	
//	}
	
	public void addTags(Question question, String tag) {
		List<Tag> tagList = question.getTags();
		Tag newTag = new Tag();
		newTag.setSubject(tag);
		Tag savedTag = tRepo.save(newTag);
		tagList.add(savedTag);
		question.setTags(tagList);
		qRepo.save(question);
		
	}
	
	public void addExistingTag(Tag checkTag, Question question) {
		
		List<Tag> tagList = question.getTags();
		tagList.add(checkTag);
		question.setTags(tagList);
		qRepo.save(question);
	}
	
	public Question saveQuestion (String q) {
		Question question = new Question();
		question.setQuestion(q);
		return question;
	}
		
	
	
	
	

}
