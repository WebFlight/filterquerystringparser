package nl.webflight.filterparser.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TestExpressionBuilderFactory {
	
	static ExpressionCreatorFactory expressionCreatorFactory;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		expressionCreatorFactory = Mockito.mock(ExpressionCreatorFactory.class);
	}

	@Test
	void testGetExpressionBuilder() {
		ExpressionBuilderFactory expressionBuilderFactory = new ExpressionBuilderFactory();
		ExpressionBuilder expressionBuilder = expressionBuilderFactory.getExpressionBuilder(expressionCreatorFactory);
		assertEquals(ExpressionBuilder.class, expressionBuilder.getClass());
	}

}
