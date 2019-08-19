package nl.webflight.filterparser.impl;

import nl.webflight.filterparser.exceptions.UnparsableFilterExpressionException;
import nl.webflight.filterparser.interfaces.OperatorSetter;

public class IntegerExpressionOperatorSetter implements OperatorSetter {
	
	
	protected IntegerExpressionOperatorSetter() {
		
	}

	@Override
	public void set(Expression expression, ComparisonOperator operator) throws UnparsableFilterExpressionException {
		expression.operator = operator;
	}

}
