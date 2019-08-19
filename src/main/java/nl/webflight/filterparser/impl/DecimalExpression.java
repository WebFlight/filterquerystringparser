package nl.webflight.filterparser.impl;

import nl.webflight.filterparser.interfaces.OperatorSetter;

public class DecimalExpression extends Expression {
	
	private Double value;
	
	public DecimalExpression(OperatorSetter operatorSetter) {
		super(operatorSetter);
	}
	
	public Double getValue() {
		return this.value;
	}
	
	@Override
	public String getTextualValue() {
		return String.valueOf(this.value);
	}
	
	public  void setValue(String value) {
		this.value = Double.valueOf(value);
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.DECIMAL;
	}

}
