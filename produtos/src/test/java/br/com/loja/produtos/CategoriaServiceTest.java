package br.com.loja.produtos;

import br.com.loja.produtos.domain.Categoria;
import br.com.loja.produtos.repository.CategoriaRepository;
import br.com.loja.produtos.service.CategoriaService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoriaServiceTest {

    @Autowired
    private CategoriaService categoriaService;

    @MockBean
    private CategoriaRepository categoriaRepository;


    @Test
    public void salvaCategoria() {
        Mockito.when(categoriaRepository.save(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNome("Brinquedos");
        Categoria save = categoriaService.save(categoria);
        Assert.assertEquals(save.getId(), categoria.getId());

    }

    @Test
    public void validaGetAll(){
        Page<Categoria> categoriaPage = new PageImpl<Categoria>(new ArrayList<>());
        Mockito.when(categoriaRepository.findAll(Mockito.isA(Pageable.class))).thenReturn(categoriaPage);

        Pageable pageable = PageRequest.of(0, 2);
        Page<Categoria> categorias = categoriaService.getAll(pageable);
        Assert.assertNotNull(categorias);
    }
}
