package nl.webflight.filterparser.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import nl.webflight.filterparser.exceptions.UnparsableFilterExpressionException;
import nl.webflight.filterparser.impl.ComparisonOperator;
import nl.webflight.filterparser.impl.DecimalExpression;
import nl.webflight.filterparser.impl.DecimalExpressionOperatorSetter;
import nl.webflight.filterparser.impl.Expression;
import nl.webflight.filterparser.interfaces.OperatorSetter;

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
