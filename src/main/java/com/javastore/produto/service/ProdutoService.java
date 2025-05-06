package  com.javastore.produto.service;

import com.javastore.produto.jpa.entity.ProdutoEntity;
import com.javastore.produto.jpa.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoEntity> findAll(){
        return produtoRepository.findAll();
    }

    public ProdutoEntity findById(Long id) { return produtoRepository.findById(id).orElseThrow();}

    public List<ProdutoEntity> findByNome(String nome){
        return produtoRepository.findByNome(nome);
    }

    public void save(ProdutoEntity produto) { produtoRepository.save(produto); }

    public void update(ProdutoEntity produto, Long id) {
        ProdutoEntity exist = produtoRepository.findById(id).orElseThrow();
        exist.setNome(produto.getNome());
        exist.setDescricao(produto.getDescricao());
        exist.setPreco(produto.getPreco());
        produtoRepository.save(exist);
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }
}