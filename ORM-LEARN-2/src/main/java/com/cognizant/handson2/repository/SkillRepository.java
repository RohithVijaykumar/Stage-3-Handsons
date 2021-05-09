package com.cognizant.handson2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.handson2.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
