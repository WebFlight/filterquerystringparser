package nl.webflight.filterparser.interfaces;

import nl.webflight.filterparser.exceptions.InvalidExpressionTypeException;
import nl.webflight.filterparser.impl.Expression;
import nl.webflight.filterparser.impl.ExpressionType;

public interface ExpressionCreator {
	Expression getExpression(String expressionType) throws InvalidExpressionTypeException;
	
	Expression getExpression(ExpressionType expressionType) throws InvalidExpressionTypeException;
}
