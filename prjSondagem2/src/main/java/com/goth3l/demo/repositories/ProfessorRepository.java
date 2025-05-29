package com.goth3l.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.goth3l.demo.entities.Professor;

	public interface ProfessorRepository extends JpaRepository<Professor, Long> {
		
}
