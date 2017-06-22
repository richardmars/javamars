package io.github.richardmars.designpattern.interpreter;

public class TerminalExpression implements Expression {

	// input 
	private String data;
	
	public TerminalExpression(String data) {
		this.data = data;
	}
	@Override
	public boolean interprete(String context) {
		if (context.contains(data)) {
			return true;
		}
		return false;
	}

}
