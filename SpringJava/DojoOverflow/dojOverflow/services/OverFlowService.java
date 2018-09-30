package com.garrett.dojOverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.garrett.dojOverflow.models.Answer;
import com.garrett.dojOverflow.models.Question;
import com.garrett.dojOverflow.models.Tag;
import com.garrett.dojOverflow.repositories.AnswerRepo;
import com.garrett.dojOverflow.repositories.QuestionRepo;
import com.garrett.dojOverflow.repositories.TagRepo;

@Service
public class OverFlowService {
	private final AnswerRepo aRepo;
	private final QuestionRepo qRepo;
	private final TagRepo tRepo;
	
	public OverFlowService(AnswerRepo aRepo, QuestionRepo qRepo, TagRepo tRepo) {
		this.aRepo = aRepo;
		this.qRepo = qRepo;
		this.tRepo = tRepo;
	}
	
	public List<Question> getQuestions() {
		return qRepo.findAll();
	}
	
	public Question createQuestion(String query) {
		Question q = new Question(query);
		return qRepo.save(q);
	}
	
	public void addTag(Question q, List<Tag> tag) {
		q.setTags(tag);
		qRepo.save(q);
	}
	
	public Tag createTag(String tag) {
		Tag t = new Tag(tag);
		return tRepo.save(t);
	}
	
	public Question findQuestion(Long id) {
		Optional<Question> q = qRepo.findById(id);
		if(q.isPresent()) {
			return q.get();
		} else {
			return null;
		}
	}
	
	public Answer createAnswer(String answer, Question q) {
		Answer a = new Answer(answer, q);
		return aRepo.save(a);
	}
	
}
