package nl.webflight.filterparser.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import nl.webflight.filterparser.exceptions.UnparsableFilterExpressionException;
import nl.webflight.filterparser.impl.ComparisonOperator;
import nl.webflight.filterparser.impl.Expression;
import nl.webflight.filterparser.impl.StringExpression;
import nl.webflight.filterparser.impl.StringExpressionOperatorSetter;
import nl.webflight.filterparser.interfaces.OperatorSetter;

class TestStringExpressionOperatorSetter {
	
	private static OperatorSetter operatorSetter;
	private static Expression expression;

	@BeforeAll
	static void setUp() throws Exception {
		operatorSetter = new StringExpressionOperatorSetter();
		expression = new StringExpression(operatorSetter);
	}

	@Test
	void testSetEquals() throws UnparsableFilterExpressionException {
		operatorSetter.set(expression, ComparisonOperator.EQ);
		assertEquals(ComparisonOperator.EQ, expression.getOperator());
	}
	
	@Test
	void testSetNotEquals() throws UnparsableFilterExpressionException {
		operatorSetter.set(expression, ComparisonOperator.NE);
		assertEquals(ComparisonOperator.NE, expression.getOperator());
	}
	
	@Test
	void testSetExceptionOperatorNotAllowed() throws UnparsableFilterExpressionException {
		assertThrows(UnparsableFilterExpressionException.class, () -> operatorSetter.set(expression, ComparisonOperator.LT));
	}

}
