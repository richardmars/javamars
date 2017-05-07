package io.github.richardmars.exam.thoughtworks;

public class DataLogicException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DataLogicException(String id) {
		super("Conflict found at " + id);
	}
}
