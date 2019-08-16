package nl.webflight.filterparser;

public class DecimalExpression extends Expression {
	
	private Double value;
	
	protected DecimalExpression(OperatorSetter operatorSetter) {
		super(operatorSetter);
	}
	
	public Double getValue() {
		return this.value;
	}
	
	@Override
	public String getTextualValue() {
		return String.valueOf(this.value);
	}
	
	protected void setValue(String value) {
		this.value = Double.valueOf(value);
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.DECIMAL;
	}

}
