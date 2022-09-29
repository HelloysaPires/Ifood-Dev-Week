package me.dio.carrinhoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.carrinhoapi.model.Restaurante;

@Repository
public interface RestauranteRepository  extends JpaRepository<Restaurante, Long> {

}
