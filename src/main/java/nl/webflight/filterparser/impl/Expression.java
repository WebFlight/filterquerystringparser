package nl.webflight.filterparser.impl;

import nl.webflight.filterparser.exceptions.UnparsableFilterExpressionException;
import nl.webflight.filterparser.interfaces.OperatorSetter;

public abstract class Expression {
	
	private String field;
	protected ComparisonOperator operator;
	private OperatorSetter operatorSetter;
	
	protected Expression(OperatorSetter operatorSetter) {
		this.operatorSetter = operatorSetter;
	}
	
	public String getField() {
		return field;
	}
	
	public void setField(String field) {
		this.field = field;
	}
	
	public ComparisonOperator getOperator() {
		return operator;
	}
	
	public void setOperator(ComparisonOperator operator) throws UnparsableFilterExpressionException {
		this.operatorSetter.set(this, operator);
	}
	
	public abstract void setValue(String value);
	
	public abstract String getTextualValue();
	
	public abstract ExpressionType getExpressionType();
}
