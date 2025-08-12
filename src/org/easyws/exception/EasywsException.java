package org.easyws.exception;

public class EasywsException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	protected EasywsException() {
		super();
	}
	

	public EasywsException(String message) {
		super("Easyws found an error :" +message);	
	}




}
