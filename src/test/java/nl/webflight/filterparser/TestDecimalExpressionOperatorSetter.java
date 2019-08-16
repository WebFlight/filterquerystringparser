package nl.webflight.filterparser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestDecimalExpressionOperatorSetter {
	
	private static OperatorSetter operatorSetter;
	private static Expression expression;

	@BeforeAll
	static void setUp() throws Exception {
		operatorSetter = new DecimalExpressionOperatorSetter();
		expression = new DecimalExpression(operatorSetter);
	}

	@Test
	void testSetAllPosibleOperators() throws UnparsableFilterExpressionException {
		ComparisonOperator[] operators = ComparisonOperator.values();
		for (ComparisonOperator operator : operators) {
			operatorSetter.set(expression, operator);
			assertEquals(operator, expression.getOperator());
		}
	}

}
