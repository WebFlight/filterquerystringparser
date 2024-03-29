package nl.webflight.filterparser.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import nl.webflight.filterparser.exceptions.InvalidExpressionTypeException;
import nl.webflight.filterparser.impl.BooleanExpression;
import nl.webflight.filterparser.impl.DecimalExpression;
import nl.webflight.filterparser.impl.Expression;
import nl.webflight.filterparser.impl.ExpressionCreatorImpl;
import nl.webflight.filterparser.impl.ExpressionType;
import nl.webflight.filterparser.impl.IntegerExpression;
import nl.webflight.filterparser.impl.StringExpression;
import nl.webflight.filterparser.interfaces.ExpressionCreator;

class TestExpressionCreatorImpl {
	static private ExpressionCreator expressionCreator;

	@BeforeAll
	static void testSetup() {
		expressionCreator = new ExpressionCreatorImpl();
		
	}
	
	@Test
	void testGetExpressionBoolean() throws InvalidExpressionTypeException {
		Expression expression = expressionCreator.getExpression(ExpressionType.BOOLEAN);
		assertEquals(BooleanExpression.class, expression.getClass());
	}
	
	@Test
	void testGetExpressionDecimal() throws InvalidExpressionTypeException {
		Expression expression = expressionCreator.getExpression(ExpressionType.DECIMAL);
		assertEquals(DecimalExpression.class, expression.getClass());
	}
	
	@Test
	void testGetExpressionInteger() throws InvalidExpressionTypeException {
		Expression expression = expressionCreator.getExpression(ExpressionType.INTEGER);
		assertEquals(IntegerExpression.class, expression.getClass());
	}
	
	@Test
	void testGetExpressionString() throws InvalidExpressionTypeException {
		Expression expression = expressionCreator.getExpression(ExpressionType.STRING);
		assertEquals(StringExpression.class, expression.getClass());
	}
	
	@Test
	void testGetExpressionException() throws InvalidExpressionTypeException {
		assertThrows(InvalidExpressionTypeException.class, () -> expressionCreator.getExpression("INVALID_EXPRESSION_TYPE"));
	}

}
