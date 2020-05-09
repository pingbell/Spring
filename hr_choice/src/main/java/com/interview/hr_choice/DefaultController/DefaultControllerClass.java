package com.interview.hr_choice.DefaultController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.interview.hr_choice.model.Questionaire;
import com.interview.hr_choice.repository.QuestionaireRepository;
import com.interview.hr_choice.service.QuestionaireService;

@Controller
@RequestMapping("/")
public class DefaultControllerClass {

	@Autowired QuestionaireService service;
	@RequestMapping("/index")
	public String index(Model model) {
	
		return "index";
	}
	
	@RequestMapping("getAll")
	public String getAll(Model model) {
		List<Questionaire> list =  service.getAllQuestionaire();
		model.addAttribute("list", list);
		return "getAll";
	}
	
	@RequestMapping("getById")
	public String getById(@PathVariable("id") long id,Model model) throws Exception {
		Questionaire quest =  service.getById(id);
		model.addAttribute("quest", quest);
		return "getById";
	}
	
	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String edit(Model model,@PathVariable("id") Optional<Long> id) throws Exception {
		if(id.isPresent()) {
			Questionaire quest = service.getById(id.get());
			model.addAttribute("question", quest);
		}else {
			model.addAttribute("question", new Questionaire());
		}
		return "edit_id";
		
	}
	@RequestMapping(path = {"/delete/id"})
	public String delete(Model model,@PathVariable("id") long id) throws Exception {

		service.delete(id);
		return "redirect:/";
		
	}

	@RequestMapping(path = "/createQuestion", method = RequestMethod.POST)
	public String createOrUpdateEmployee(Questionaire question) 
	{
		service.createOrUpdate(question);
		return "redirect:/";
	}
}
