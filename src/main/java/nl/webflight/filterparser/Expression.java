package nl.webflight.filterparser;

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
	
	protected void setField(String field) {
		this.field = field;
	}
	
	public ComparisonOperator getOperator() {
		return operator;
	}
	
	protected void setOperator(ComparisonOperator operator) throws UnparsableFilterExpressionException {
		this.operatorSetter.set(this, operator);
	}
	
	protected abstract void setValue(String value);
	
	public abstract String getTextualValue();
	
	public abstract ExpressionType getExpressionType();
}
