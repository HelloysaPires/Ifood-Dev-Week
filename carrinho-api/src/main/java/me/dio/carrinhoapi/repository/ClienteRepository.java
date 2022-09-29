package me.dio.carrinhoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.carrinhoapi.model.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long>{

}
