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

import com.goth3l.demo.entities.Departamento;
import com.goth3l.demo.entities.Professor;
import com.goth3l.demo.services.DepartamentoService;



@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

	private final DepartamentoService departamentoService;

	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Departamento> findDepartamentoById(@PathVariable Long id) {
		Departamento departamento = departamentoService.getDepartametoByid(id);
		if (departamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/buscar")
	public ResponseEntity<List<Departamento>> findAllDepartamento() {
		List<Departamento> departamentos = departamentoService.getAllDepartamentos();
		return ResponseEntity.ok(departamentos);
	}
	
	@PostMapping("/inserir")
	public ResponseEntity<Departamento> insertDepartamento(@RequestBody Departamento departamento) {
		Departamento novoDepartamento = departamentoService.saveDepartamento(departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoDepartamento);
	}
	
	   @DeleteMapping("/{id}")
	   public void deleteDepartamentoById (@PathVariable Long id) {
	       departamentoService.deletDepartamento(id);
	   }
	   
	  @GetMapping("/DP-por-Professor/{nome}")
	  public List<Departamento> getDepartamentoByProfessor(@PathVariable String nome) {
	   	return departamentoService.findDepartamentoByProfessor(nome);
	  }
	
}
