package nl.webflight.filterparser.impl;

import nl.webflight.filterparser.exceptions.InvalidExpressionTypeException;
import nl.webflight.filterparser.interfaces.ExpressionCreator;

public class ExpressionCreatorImpl implements ExpressionCreator {

	public ExpressionCreatorImpl() {
		
	}
	
	public Expression getExpression(ExpressionType expressionType) throws InvalidExpressionTypeException {
		return getExpression(expressionType.name());
	}
	
	public Expression getExpression(String expressionType) throws InvalidExpressionTypeException {
		if(expressionType.equals(String.valueOf(ExpressionType.INTEGER))) {
			return new IntegerExpression(new IntegerExpressionOperatorSetter());
		}
		
		if(expressionType.equals(String.valueOf(ExpressionType.DECIMAL))) {
			return new DecimalExpression(new DecimalExpressionOperatorSetter());
		}
		
		if(expressionType.equals(String.valueOf(ExpressionType.STRING))) {
			return new StringExpression(new StringExpressionOperatorSetter());
		}
		
		if(expressionType.equals(String.valueOf(ExpressionType.BOOLEAN))) {
			return new BooleanExpression(new BooleanExpressionOperatorSetter());
		}
		
		throw new InvalidExpressionTypeException("Could not parse expression type " + expressionType);
	}
	
}