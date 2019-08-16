package nl.webflight.filterparser;

public class StringExpression extends Expression {
	
	private String value;
	
	protected StringExpression(OperatorSetter operatorSetter) {
		super(operatorSetter);
	}
	
	public String getValue() {
		return this.value;
	}
	
	@Override
	public String getTextualValue() {
		return this.value;
	}
	
	protected void setValue(String value) {
		this.value = value.replaceAll("'", "");
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.STRING;
	}

}
