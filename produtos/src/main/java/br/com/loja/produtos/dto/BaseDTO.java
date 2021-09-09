package br.com.loja.produtos.dto;


import org.springframework.beans.BeanUtils;

public class BaseDTO {

    private BaseDTO() {
        throw new IllegalStateException("Utility class");
    }
    public static <T, K> K parse(T origem, K destino) {
        BeanUtils.copyProperties(origem, destino);
        return destino;
    }
}
