package com.javastore.produto.jpa.repository;

import com.javastore.produto.jpa.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    List<ProdutoEntity> findAll();
    List<ProdutoEntity> findByNome(String nome);
}