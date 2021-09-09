package br.com.loja.produtos.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    private String message;
    private String error;
    private String exceptionName;
    private Date time;

    public ApiError(String message, String error, String exceptionName) {
        this.message = message;
        this.error = error;
        this.exceptionName = exceptionName;
        this.time = new Date();
    }
}
