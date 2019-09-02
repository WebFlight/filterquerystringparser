package nl.webflight.filterparser.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import nl.webflight.filterparser.exceptions.InvalidExpressionTypeException;
import nl.webflight.filterparser.exceptions.UnparsableFilterExpressionException;
import nl.webflight.filterparser.interfaces.ExpressionCreator;

class TestExpressionBuilder {
	
	static ExpressionCreator expressionCreator;
	static FilterPatternProviderFactory filterPatternProviderFactory;
	static FilterPatternProvider filterPatternProvider;
	static ExpressionBuilder expressionBuilder;
	static Expression expression;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		expressionCreator = Mockito.mock(ExpressionCreator.class);
		filterPatternProviderFactory = Mockito.mock(FilterPatternProviderFactory.class);
		filterPatternProvider = Mockito.mock(FilterPatternProvider.class);
		expression = Mockito.mock(Expression.class);
		
		Mockito.when(expressionCreator.getExpression(Mockito.any(ExpressionType.class))).thenReturn(expression);
		Mockito.when(filterPatternProviderFactory.getFilterPatternProvider()).thenReturn(filterPatternProvider);
		Mockito.when(filterPatternProvider.getPattern()).thenReturn(Pattern.compile("([\\w]*) (gt|ge|lt|le|eq|ne) (('[^']*')|([\\-]?[\\d]+(?:.?\\d+)?)|(true|false))( and )?"));
		Mockito.when(filterPatternProvider.getPatternForFullMatch()).thenReturn(Pattern.compile("^(([\\w]*) (gt|ge|lt|le|eq|ne) (('[^']*')|([\\-]?[\\d]+(?:.?\\d+)?)|(true|false))( and )?)+$"));
		
		expressionBuilder = new ExpressionBuilder(expressionCreator, filterPatternProviderFactory);
	}

	@Test
	void testExpressionBuilder() {
		assertEquals(ExpressionBuilder.class, expressionBuilder.getClass());
	}

	@Test
	void testBuild() throws InvalidExpressionTypeException, UnparsableFilterExpressionException {
		List<Expression> actualExpressions = expressionBuilder.build("price gt 10 and description eq 'test description' and precision lt 0.01 and active eq true");
		int actualExpressionCount = actualExpressions.size();
		
		int expectedExpressionCount = 4;
		
		assertEquals(expectedExpressionCount, actualExpressionCount);
		Mockito.verify(expression, Mockito.times(1)).setField("price");
		Mockito.verify(expression, Mockito.times(1)).setField("description");
		Mockito.verify(expression, Mockito.times(1)).setField("precision");
		Mockito.verify(expression, Mockito.times(1)).setField("active");
		
		Mockito.verify(expression, Mockito.times(1)).setOperator(ComparisonOperator.GT);
		Mockito.verify(expression, Mockito.times(2)).setOperator(ComparisonOperator.EQ);
		Mockito.verify(expression, Mockito.times(1)).setOperator(ComparisonOperator.LT);
		
		Mockito.verify(expression, Mockito.times(1)).setValue("10");
		Mockito.verify(expression, Mockito.times(1)).setValue("'test description'");
		Mockito.verify(expression, Mockito.times(1)).setValue("0.01");
		Mockito.verify(expression, Mockito.times(1)).setValue("true");
	}
	
	@Test
	void testBuildUnparsableFilterExpcetion() throws InvalidExpressionTypeException, UnparsableFilterExpressionException {
		assertThrows(UnparsableFilterExpressionException.class, () -> {
			expressionBuilder.build("this is an incorrect expression");
		}, "Expression this is an incorrect expression is invalid");
		
	}

}
