package com.github.vinifroth.coreeng.tema6.exception;

public class ConexaoException extends Exception {

	private static final long serialVersionUID = -3517170452748690517L;

	public ConexaoException(String erro) {
		super(erro);
	}

	public ConexaoException(Exception e) {
		super(e.getMessage());
	}

	public ConexaoException(String erro, Exception e) {
		super(erro, e);
	}

}
