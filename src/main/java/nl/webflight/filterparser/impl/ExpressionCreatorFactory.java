package nl.webflight.filterparser.impl;

import nl.webflight.filterparser.interfaces.ExpressionCreator;

public class ExpressionCreatorFactory {
	
	public ExpressionCreator getExpressionCreator() {
		return new ExpressionCreatorImpl();
	}

}
