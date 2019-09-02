package nl.webflight.filterparser.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import nl.webflight.filterparser.interfaces.OperatorSetter;

class TestStringExpression {

	static StringExpression stringExpression;
	static OperatorSetter operatorSetter;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		operatorSetter = Mockito.mock(OperatorSetter.class);
		stringExpression = new StringExpression(operatorSetter);
	}

	@Test
	void testGetTextualValue() {
		String expectedValue = "-{}q4358asdfjkl";
		stringExpression.setValue(expectedValue);
	
		String actualValue = stringExpression.getTextualValue();
		
		assertEquals(expectedValue, actualValue);
	}

	@Test
	void testGetExpressionType() {
		ExpressionType expressionType = stringExpression.getExpressionType();
		assertEquals(ExpressionType.STRING, expressionType);
	}

	@Test
	void testGetValue() {
		String expectedValue = "-{}q4358asdfjkl";
		stringExpression.setValue(expectedValue);
	
		String actualValue = stringExpression.getValue();
		
		assertEquals(expectedValue, actualValue);
	}

}
