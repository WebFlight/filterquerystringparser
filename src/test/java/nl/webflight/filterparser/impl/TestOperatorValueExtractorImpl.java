package nl.webflight.filterparser.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestOperatorValueExtractorImpl {
	
	static OperatorValueExtractorImpl operatorValueExtractorImpl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		operatorValueExtractorImpl = new OperatorValueExtractorImpl();
	}
	
	@Test
	void testGetLogicalOperatorValues() {
		Operator[] operators = operatorValueExtractorImpl.getLogicalOperatorValues();
		List<Operator> actualOperators = Arrays.asList(operators);
		assertTrue(actualOperators.contains(LogicalOperator.AND));
	}

	@Test
	void testGetComparisonOperatorValues() {
		Operator[] operators = operatorValueExtractorImpl.getComparisonOperatorValues();
		List<Operator> actualOperators = Arrays.asList(operators);
		assertTrue(actualOperators.contains(ComparisonOperator.EQ));
		assertTrue(actualOperators.contains(ComparisonOperator.LT));
		assertTrue(actualOperators.contains(ComparisonOperator.GT));
		assertTrue(actualOperators.contains(ComparisonOperator.LE));
		assertTrue(actualOperators.contains(ComparisonOperator.GE));
		assertTrue(actualOperators.contains(ComparisonOperator.NE));
	}

}
