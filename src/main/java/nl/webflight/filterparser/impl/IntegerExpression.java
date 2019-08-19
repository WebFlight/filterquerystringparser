package nl.webflight.filterparser.impl;

import nl.webflight.filterparser.interfaces.OperatorSetter;

public class IntegerExpression extends Expression {
	
	private Integer value;
	
	public IntegerExpression(OperatorSetter operatorSetter) {
		super(operatorSetter);
	}
	
	public Integer getValue() {
		return this.value;
	}
	
	@Override
	public String getTextualValue() {
		return String.valueOf(this.value);
	}
	
	public void setValue(String value) {
		this.value = Integer.valueOf(value);
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.INTEGER;
	}

}
