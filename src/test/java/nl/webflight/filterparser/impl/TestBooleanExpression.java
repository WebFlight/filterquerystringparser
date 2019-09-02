package nl.webflight.filterparser.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import nl.webflight.filterparser.exceptions.UnparsableFilterExpressionException;
import nl.webflight.filterparser.interfaces.OperatorSetter;

class TestBooleanExpression {

	static BooleanExpression booleanExpression;
	static OperatorSetter operatorSetter;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		operatorSetter = Mockito.mock(OperatorSetter.class);
		booleanExpression = new BooleanExpression(operatorSetter);
	}

	@Test
	void testGetTextualValue() {
		String expectedValue = "false";
		booleanExpression.setValue(expectedValue);
		
		String actualValue = booleanExpression.getTextualValue();
		
		assertEquals(expectedValue, actualValue);
	}

	@Test
	void testGetExpressionType() {
		ExpressionType expressionType = booleanExpression.getExpressionType();
		assertEquals(ExpressionType.BOOLEAN, expressionType);
	}

	@Test
	void testGetValue() {
		String expectedTextualValue = "true";
		booleanExpression.setValue(expectedTextualValue);
	
		boolean actualValue = booleanExpression.getValue();
		boolean expectedValue = Boolean.valueOf(expectedTextualValue);
		
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	void testSetField() {
		String expectedField = "TestField";
		booleanExpression.setField(expectedField);
		String actualField = booleanExpression.getField();
		assertEquals(expectedField, actualField);
	}

	@Test
	void testSetOperator() throws UnparsableFilterExpressionException {
		booleanExpression.setOperator(ComparisonOperator.EQ);
		assertEquals(null, booleanExpression.getOperator());
	}

}
