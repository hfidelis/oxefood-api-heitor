package br.com.ifpe.oxefood.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ProdutoException extends RuntimeException {

    public static final String MSG_VALOR_INVALIDO = "Não é permitido inserir produtos com valores inferiores a R$ 20 e maiores que R$ 100.";

    public ProdutoException(String msg) {
        super(String.format(msg));
    }
}