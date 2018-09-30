package com.garrett.dojOverflow.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.garrett.dojOverflow.models.Answer;
import com.garrett.dojOverflow.models.Question;
import com.garrett.dojOverflow.models.Tag;
import com.garrett.dojOverflow.services.OverFlowService;

@Controller
public class OverFlowController {
	private final OverFlowService flowService;
	public OverFlowController(OverFlowService flowService) {
		this.flowService = flowService;
	}
	
	@GetMapping("/questions")
	public String allQuestions(Model model) {
		List<Question> queries = flowService.getQuestions();
		HashMap<String, ArrayList<String>> hash = new HashMap<String, ArrayList<String>>();
		for(Question q : queries) {
			ArrayList<String> tags = new ArrayList<String>();
			for(Tag t : q.getTags()) {
				tags.add(t.getTag());
			}
			tags.add(Long.toString(q.getId()));
			hash.put(q.getQuery(), tags);
		}
		model.addAttribute("questions", hash);
		return "/overflow/allQuestions.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion() {
		return "/overflow/newQuestion.jsp";
	}
	
	@PostMapping("/questions/new")
	public String createQuestion(@RequestParam("query") String query, @RequestParam("tags") String tags) {
		List<Tag> ts = new ArrayList<Tag>();
		Question q = flowService.createQuestion(query);
		String[] tagsArray = tags.split(",");
		for(int i=0;i<tagsArray.length;i++) {
			Tag t = flowService.createTag(tagsArray[i]);
			ts.add(t);
		}
		flowService.addTag(q, ts);
		return "redirect:/questions";
	}
	
	@GetMapping("/questions/{id}")
	public String showQuestion(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model model) {
		Question q = flowService.findQuestion(id);
		model.addAttribute("query", q.getQuery());
		model.addAttribute("id", q.getId());
		model.addAttribute("Q", q);
		ArrayList<String> tags = new ArrayList<String>();
		for(Tag t : q.getTags()) {
			tags.add(t.getTag());
		}
		model.addAttribute("tags", tags);
		ArrayList<String> answers = new ArrayList<String>();
		for(Answer a : q.getAnswers()) {
			answers.add(a.getAnswer());
		}
		model.addAttribute("answers", answers);
		return "/overflow/oneQuestion.jsp";
	}
	
	@PostMapping("/questions/{id}")
	public String addAnswer(@PathVariable("id") Long id, @RequestParam("answer") String answer) {
		Question q = flowService.findQuestion(id);
		flowService.createAnswer(answer, q);
		return "redirect:/questions";
	}
	
}
