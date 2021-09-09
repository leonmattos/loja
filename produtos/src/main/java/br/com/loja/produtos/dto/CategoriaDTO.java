package br.com.loja.produtos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO{
    @NotNull
    @Size(max = 100)
    private String nome;
    private List<ProdutoDTO> produtos;

}
