package nl.webflight.filterparser.interfaces;

import nl.webflight.filterparser.exceptions.UnparsableFilterExpressionException;
import nl.webflight.filterparser.impl.ComparisonOperator;
import nl.webflight.filterparser.impl.Expression;

public interface OperatorSetter {
	
	void set(Expression expression, ComparisonOperator operator) throws UnparsableFilterExpressionException;

}
