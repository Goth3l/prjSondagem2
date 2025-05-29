package com.goth3l.demo.repositories;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.goth3l.demo.entities.Departamento;
import com.goth3l.demo.entities.Professor;

	public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
		@Query(value = "SELECT * FROM tb_departamento WHERE LOWER(tb_departamento.nome) LIKE LOWER(CONCAT ('%', :nome,'%'))", nativeQuery = true )
		   List<Departamento> findDepartamentoByProfessor(@Param("nome") String nome);
}
