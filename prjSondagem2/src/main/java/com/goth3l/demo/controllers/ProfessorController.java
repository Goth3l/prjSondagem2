package com.goth3l.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goth3l.demo.entities.Professor;
import com.goth3l.demo.services.ProfessorService;


@RestController
@RequestMapping("/professor")
public class ProfessorController {

	private final ProfessorService professorService;

	public ProfessorController(ProfessorService professorService) {
		this.professorService = professorService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Professor> findDProfessorById(@PathVariable Long id) {
		Professor professor = professorService.getProfessorById(id);
		if (professor != null) {
			return ResponseEntity.ok(professor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/buscar")
	public ResponseEntity<List<Professor>> findAllProfessor() {
		List<Professor> professor = professorService.getAllProfessor();
		return ResponseEntity.ok(professor);
	} 
	
	
	
	@PostMapping("/inserir")
	public ResponseEntity<Professor> insertProfessor(@RequestBody Professor professor) {
		Professor novoProfessor = professorService.saveProfessor(professor);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoProfessor);
	}
	
	   @DeleteMapping("/{id}")
	   public void deleteProfessorById (@PathVariable Long id) {
	       professorService.deletProfessor(id);
	   }
	   
	  
			

}
