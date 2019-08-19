package nl.webflight.filterparser.impl;

import nl.webflight.filterparser.interfaces.OperatorSetter;

public class BooleanExpression extends Expression {
	
	public BooleanExpression(OperatorSetter operatorSetter) {
		super(operatorSetter);
	}

	private Boolean value;
	
	public Boolean getValue() {
		return this.value;
	}
	
	@Override
	public String getTextualValue() {
		return String.valueOf(this.value);
	}
	
	public void setValue(String value) {
		this.value = Boolean.valueOf(value);
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.BOOLEAN;
	}

}
