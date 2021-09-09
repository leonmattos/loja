package br.com.loja.produtos.controller;

import br.com.loja.produtos.domain.Categoria;
import br.com.loja.produtos.dto.BaseDTO;
import br.com.loja.produtos.dto.CategoriaDTO;
import br.com.loja.produtos.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaDTO> save(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = BaseDTO.parse(categoriaDTO, new Categoria());
        categoriaService.save(categoria);

        return ResponseEntity.ok(categoriaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Long id, @Valid @RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = BaseDTO.parse(categoriaDTO, new Categoria());
        categoria.setId(id);
        categoriaService.save(categoria);

        return ResponseEntity.ok(categoriaDTO);
    }

    @GetMapping
    public Page<CategoriaDTO> findAllPageable(Pageable pageable) {
        Page<Categoria> categorias = categoriaService.getAll(pageable);
        return categorias.map(this::convert);
    }

    private CategoriaDTO convert(Categoria categoria) {
        return BaseDTO.parse(categoria, new CategoriaDTO());
    }
}
