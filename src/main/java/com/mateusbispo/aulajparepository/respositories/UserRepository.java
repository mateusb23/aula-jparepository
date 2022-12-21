package com.mateusbispo.aulajparepository.respositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mateusbispo.aulajparepository.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT obj FROM User obj WHERE obj.salary >= :minSalary AND obj.salary <= :maxSalary")
	Page<User> searchSalary(Double minSalary, Double maxSalary, Pageable pageable);

	@Query("SELECT obj FROM User obj WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))")
	Page<User> searchName(String name, Pageable pageable);
	
	// FAZENDO COM QUERY METHODS
	
	Page<User> findBySalaryBetween(Double minsalary, Double maxSalary, Pageable pageable); // FAZ A MESMA COISA QUE O MÉTODO DA LINHA 12, POIS JÁ ESTÁ PRÉ-CONFIGURADO PELO SPRING, BASTA COLOCAR O NOME CERTO NO MÉTODO.

	Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
	
}
