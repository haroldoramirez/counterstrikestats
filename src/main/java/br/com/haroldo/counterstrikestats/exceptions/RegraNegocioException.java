package br.com.haroldo.counterstrikestats.exceptions;

import java.io.Serial;

public class RegraNegocioException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public RegraNegocioException(String msg) {
        super(msg);
    }
}