package me.dio.carrinhoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.carrinhoapi.model.Sacola;

@Repository
public interface SacolaRepository extends JpaRepository<Sacola, Long>{
	

}
