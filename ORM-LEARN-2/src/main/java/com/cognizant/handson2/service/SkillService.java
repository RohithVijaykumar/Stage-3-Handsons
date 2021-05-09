package com.cognizant.handson2.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.handson2.model.Skill;
import com.cognizant.handson2.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository repo;

	@Transactional
	public Skill get(int id) {
		return repo.findById(id).get();
	}

	@Transactional
	public void save(Skill skill) {
		repo.save(skill);
	}
}
