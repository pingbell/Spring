package com.interview.hr_choice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.interview.hr_choice.model.Questionaire;
import com.interview.hr_choice.repository.QuestionaireRepository;

@Service
public class QuestionaireService {
	@Autowired
	QuestionaireRepository repository;


	public List<Questionaire>  getAllQuestionaire() 
	{
		List<Questionaire> result = (List<Questionaire>) repository.findAll();


		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Questionaire>();
		}
	}
	
	
	public Questionaire getById(long id) throws Exception {
		Optional<Questionaire> question = repository.findById(id);
		if(question.isPresent()) {
			return question.get();
		} else {
			throw new Exception("No employee record exist for given id");
		}
		
	}
	
	public Questionaire createOrUpdate(Questionaire question) {
		if(question.getId()==null) {
			repository.save(question);
			return question;
		}else {
			Optional<Questionaire> quest = repository.findById(question.getId());
			if(quest.isPresent()) {
				Questionaire q = quest.get();
				q.setAnswer(question.getAnswer());
				q.setLevel(question.getLevel());
				q.setMarks(question.getMarks());
				q.setOption1(question.getOption1());
				q.setOption2(question.getOption2());
				q.setOption3(question.getOption3());
				q.setOption4(question.getOption4());
				q.setTopic(question.getTopic());
				q.setSubject(question.getSubject());
				q.setSubtopic(question.getSubtopic());
				Questionaire newEntity = repository.save(q);
				return newEntity;
			}else {
	           question = repository.save(question);
			   return question;
			}
				
		}
		
	}
	
	public void delete(long id) {
		Optional <Questionaire> question = repository.findById(id);
		if(question.isPresent()) {
			repository.deleteById(id);
		}else {
			throw new RuntimeException("Not Found");
		}
	
		
	}
	
}
