package com.javastore.produto.api.controller;

import com.javastore.produto.service.ProdutoService;
import com.javastore.produto.jpa.entity.ProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping(value = "produtoController")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> getProdutoByNome(@PathVariable(name = "nome") String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findByNome(nome));
    }

    @PreAuthorize("hasRole('gerente')")
    @PostMapping("")
    public ResponseEntity<Void> createProduto(@RequestBody ProdutoEntity produto) {
        produtoService.save(produto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('gerente')")
    @PutMapping("{id}")
    public ResponseEntity<Void> save(@RequestBody ProdutoEntity produto, @PathVariable Long id) {
        produtoService.update(produto, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PreAuthorize("hasRole('gerente')")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}