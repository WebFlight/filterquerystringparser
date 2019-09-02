package nl.webflight.filterparser.impl;

public class ExpressionBuilderFactory {

	public ExpressionBuilder getExpressionBuilder(ExpressionCreatorFactory expressionCreatorFactory) {
		return new ExpressionBuilder(expressionCreatorFactory.getExpressionCreator());
	}
	
}
