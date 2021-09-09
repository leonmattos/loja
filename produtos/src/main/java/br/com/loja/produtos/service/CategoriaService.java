package br.com.loja.produtos.service;

import br.com.loja.produtos.domain.Categoria;
import br.com.loja.produtos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;


    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Page<Categoria> getAll(Pageable pageable){
        return categoriaRepository.findAll(pageable);
    }

}
