package br.com.loja.produtos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    @NotNull
    @Size(max = 250)
    private String nome;
    @NotNull
    private CategoriaDTO categoria;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=5, fraction=2)
    private BigDecimal valor;

    @NotNull
    @Min(0)
    private Integer estoque;

    @NotNull
    @Size(max = 500)
    private String descricao;
}
