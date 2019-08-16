package nl.webflight.filterparser;

public class IntegerExpression extends Expression {
	
	private Integer value;
	
	protected IntegerExpression(OperatorSetter operatorSetter) {
		super(operatorSetter);
	}
	
	public Integer getValue() {
		return this.value;
	}
	
	@Override
	public String getTextualValue() {
		return String.valueOf(this.value);
	}
	
	protected void setValue(String value) {
		this.value = Integer.valueOf(value);
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.INTEGER;
	}

}
