package nl.webflight.filterparser.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import nl.webflight.filterparser.impl.ComparisonOperator;
import nl.webflight.filterparser.impl.FilterPatternProvider;
import nl.webflight.filterparser.impl.LogicalOperator;
import nl.webflight.filterparser.impl.Operator;
import nl.webflight.filterparser.interfaces.OperatorValueExtractor;

class TestFilterPatternProvider {

	private static FilterPatternProvider filterPatternProvider;
	private static OperatorValueExtractor operatorValueExtractor;
	
	@BeforeAll
	static void testSetup() {
		operatorValueExtractor = Mockito.mock(OperatorValueExtractor.class);
		filterPatternProvider = new FilterPatternProvider(operatorValueExtractor);
		Operator[] logicalOperators = {LogicalOperator.AND};
		Operator[] comparisonOperators = {
				ComparisonOperator.GT, 
				ComparisonOperator.GE,
				ComparisonOperator.LT,
				ComparisonOperator.LE,
				ComparisonOperator.EQ,
				ComparisonOperator.NE,
				};
		Mockito.when(operatorValueExtractor.getLogicalOperatorValues()).thenReturn(logicalOperators);
		Mockito.when(operatorValueExtractor.getComparisonOperatorValues()).thenReturn(comparisonOperators);
	}
	
	
	@Test
	void getFullPattern() {
		Pattern actualPattern = filterPatternProvider.getPatternForFullMatch();
		String actualRegex = actualPattern.pattern();
		String expectedRegex = "^(([\\w]*) (gt|ge|lt|le|eq|ne) (('[^']*')|([\\-]?[\\d]+(?:.?\\d+)?)|(true|false))( and )?)+$";
		assertEquals(expectedRegex, actualRegex);
	}
	
	@Test
	void testGetPattern() {
		Pattern actualPattern = filterPatternProvider.getPattern();
		String actualRegex = actualPattern.pattern();
		String expectedRegex = "([\\w]*) (gt|ge|lt|le|eq|ne) (('[^']*')|([\\-]?[\\d]+(?:.?\\d+)?)|(true|false))( and )?";
		assertEquals(expectedRegex, actualRegex);
		Mockito.verify(operatorValueExtractor, Mockito.times(1)).getComparisonOperatorValues();
		Mockito.verify(operatorValueExtractor, Mockito.times(1)).getLogicalOperatorValues();
	}

}
