package nl.webflight.filterparser.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import nl.webflight.filterparser.interfaces.ExpressionCreator;

class TestExpressionCreatorFactory {

	@Test
	void testGetExpressionCreator() {
		ExpressionCreatorFactory expressionCreatorFactory = new ExpressionCreatorFactory();
		ExpressionCreator expressionCreator = expressionCreatorFactory.getExpressionCreator();
		assertEquals(ExpressionCreatorImpl.class, expressionCreator.getClass());
	}

}
