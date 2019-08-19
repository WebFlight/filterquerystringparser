package nl.webflight.filterparser.impl;

import nl.webflight.filterparser.exceptions.UnparsableFilterExpressionException;
import nl.webflight.filterparser.interfaces.OperatorSetter;

public class BooleanExpressionOperatorSetter implements OperatorSetter {
	
	public BooleanExpressionOperatorSetter() {

	}

	@Override
	public void set(Expression expression, ComparisonOperator operator) throws UnparsableFilterExpressionException {
		if (operatorIsAllowed(operator)) {
			expression.operator = operator;
			return;
		}
		
		throw new UnparsableFilterExpressionException("Could not add operator " + operator.getToken() + " to expression of type " + this.getClass().getSimpleName());
	}
	
	private boolean operatorIsAllowed(ComparisonOperator operator) {
		if(operator.equals(ComparisonOperator.EQ)) return true;
		if(operator.equals(ComparisonOperator.NE)) return true;
		
		return false;
	}

}
