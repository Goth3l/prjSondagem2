package com.goth3l.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goth3l.demo.entities.Professor;
import com.goth3l.demo.repositories.ProfessorRepository;

@Service
public class ProfessorService {
	private ProfessorRepository professorRepository;
	
	@Autowired
	private ProfessorService(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;
	}
	
	public Professor getProfessorById(Long id){
		return professorRepository.findById(id).orElse(null);
	}
	
	public List<Professor> getAllProfessor(){
		return professorRepository.findAll();
	}
	
	public Professor saveProfessor(Professor professor) {
		return professorRepository.save(professor);
	}
	
	public void deletProfessor(Long id) {
		professorRepository.deleteById(id);
	}
	
	

	

}
