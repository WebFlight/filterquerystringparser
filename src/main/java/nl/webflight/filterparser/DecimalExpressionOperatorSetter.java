
package nl.webflight.filterparser;

public class DecimalExpressionOperatorSetter implements OperatorSetter {
	
	
	protected DecimalExpressionOperatorSetter() {
		
	}

	@Override
	public void set(Expression expression, ComparisonOperator operator) throws UnparsableFilterExpressionException {
		expression.operator = operator;
	}

}
