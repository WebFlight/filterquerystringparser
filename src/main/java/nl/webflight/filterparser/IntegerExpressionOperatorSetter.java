package nl.webflight.filterparser;

public class IntegerExpressionOperatorSetter implements OperatorSetter {
	
	
	protected IntegerExpressionOperatorSetter() {
		
	}

	@Override
	public void set(Expression expression, ComparisonOperator operator) throws UnparsableFilterExpressionException {
		expression.operator = operator;
	}

}
