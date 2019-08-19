package nl.webflight.filterparser.impl;

import nl.webflight.filterparser.interfaces.OperatorSetter;

public class StringExpression extends Expression {
	
	private String value;
	
	public StringExpression(OperatorSetter operatorSetter) {
		super(operatorSetter);
	}
	
	public String getValue() {
		return this.value;
	}
	
	@Override
	public String getTextualValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value.replaceAll("'", "");
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.STRING;
	}

}
