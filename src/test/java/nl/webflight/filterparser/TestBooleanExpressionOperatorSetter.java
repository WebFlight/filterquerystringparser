package nl.webflight.filterparser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestBooleanExpressionOperatorSetter {
	
	private static OperatorSetter operatorSetter;
	private static Expression expression;

	@BeforeAll
	static void setUp() throws Exception {
		operatorSetter = new BooleanExpressionOperatorSetter();
		expression = new BooleanExpression(operatorSetter);
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
