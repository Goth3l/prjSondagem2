package com.goth3l.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goth3l.demo.entities.Departamento;
import com.goth3l.demo.entities.Professor;
import com.goth3l.demo.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}
	
	public Departamento getDepartametoByid(Long id) {
		return departamentoRepository.findById(id).orElse(null);
	}
	
	public List<Departamento> getAllDepartamentos(){
		return departamentoRepository.findAll();
	}
	
	public Departamento saveDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}
	
	public void deletDepartamento(Long id) {
		departamentoRepository.deleteById(id);
	}
	
	public List<Departamento> findDepartamentoByProfessor(String nome) {
		return departamentoRepository.findDepartamentoByProfessor(nome);
	}

}
