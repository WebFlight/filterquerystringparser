package nl.webflight.filterparser;

public interface ExpressionCreator {
	Expression getExpression(String expressionType) throws InvalidExpressionTypeException;
	
	Expression getExpression(ExpressionType expressionType) throws InvalidExpressionTypeException;
}
