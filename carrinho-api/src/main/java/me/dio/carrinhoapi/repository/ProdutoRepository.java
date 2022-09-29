package me.dio.carrinhoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.carrinhoapi.model.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Long>{

}
