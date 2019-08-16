package nl.webflight.filterparser;

public class BooleanExpression extends Expression {
	
	protected BooleanExpression(OperatorSetter operatorSetter) {
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
	
	protected void setValue(String value) {
		this.value = Boolean.valueOf(value);
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.BOOLEAN;
	}

}
