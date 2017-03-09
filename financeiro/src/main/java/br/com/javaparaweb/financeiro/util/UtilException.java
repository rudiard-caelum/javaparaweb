package br.com.javaparaweb.financeiro.util;

public class UtilException extends Exception {

	private static final long serialVersionUID = -8425156254151114722L;

	public UtilException() {
	}

	public UtilException(String message) {
		super(message);
	}

	public UtilException(Throwable cause) {
		super(cause);
	}

	public UtilException(String message, Throwable cause) {
		super(message, cause);
	}

	public UtilException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
