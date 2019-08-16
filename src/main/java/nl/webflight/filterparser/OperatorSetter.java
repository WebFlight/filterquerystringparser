package nl.webflight.filterparser;

public interface OperatorSetter {
	
	void set(Expression expression, ComparisonOperator operator) throws UnparsableFilterExpressionException;

}
