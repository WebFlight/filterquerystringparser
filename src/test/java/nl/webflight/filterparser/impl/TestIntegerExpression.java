package nl.webflight.filterparser.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import nl.webflight.filterparser.interfaces.OperatorSetter;

class TestIntegerExpression {

	static IntegerExpression integerExpression;
	static OperatorSetter operatorSetter;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		operatorSetter = Mockito.mock(OperatorSetter.class);
		integerExpression = new IntegerExpression(operatorSetter);
	}

	@Test
	void testGetTextualValue() {
		String expectedTextualValue = "21";
		integerExpression.setValue(expectedTextualValue);
		
		String actualValue = integerExpression.getTextualValue();
		String expectedValue = String.valueOf(Integer.valueOf(expectedTextualValue));
		
		assertEquals(expectedValue, actualValue);
	}

	@Test
	void testGetExpressionType() {
		ExpressionType expressionType = integerExpression.getExpressionType();
		assertEquals(ExpressionType.INTEGER, expressionType);
	}

	@Test
	void testGetValue() {
		String expectedTextualValue = "-14";
		integerExpression.setValue(expectedTextualValue);
	
		double actualValue = integerExpression.getValue();
		double expectedValue = Double.valueOf(expectedTextualValue);
		
		assertEquals(expectedValue, actualValue);
	}

}
