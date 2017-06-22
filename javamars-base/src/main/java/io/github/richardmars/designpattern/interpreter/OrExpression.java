package io.github.richardmars.designpattern.interpreter;

public class OrExpression implements Expression{
	
	private Expression expr1 = null;
	private Expression expr2 = null;
	
	public OrExpression(Expression expr1, Expression expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	@Override
	public boolean interprete(String context) {
		return expr1.interprete(context) || expr2.interprete(context);
	}
	
}
