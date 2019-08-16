package nl.webflight.filterparser;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TestQueryFilterParser {
	
	private static QueryBuilder queryBuilder;
	private static ExpressionBuilder expressionBuilder;
	private static QueryFilterParser queryFilterParser;
	private static String queryStringFilter = "testfield eq true";
	private static List<Expression> expressions;

	@BeforeAll
	static void setUp() throws Exception {
		expressionBuilder = Mockito.mock(ExpressionBuilder.class);
		queryBuilder = Mockito.mock(QueryBuilder.class);
		queryFilterParser = new QueryFilterParser(queryBuilder, expressionBuilder);
		
		expressions = new ArrayList<>();
		Expression expression = new BooleanExpression(new BooleanExpressionOperatorSetter());
		expression.setField("testfield");
		expression.setOperator(ComparisonOperator.EQ);
		expression.setValue("true");
		expressions.add(expression);
		Mockito.when(expressionBuilder.build(queryStringFilter)).thenReturn(expressions);
		Mockito.when(queryBuilder.build(expressions)).thenReturn("testfield eq true");
	}

	@Test
	void testParse() throws InvalidExpressionTypeException, UnparsableFilterExpressionException, IncompatibleExpressionException {
		String actualQuery = queryFilterParser.parse(queryStringFilter);
		String expectedQuery = "testfield eq true";
		assertEquals(expectedQuery, actualQuery);
		Mockito.verify(queryBuilder).build(expressions);
		Mockito.verify(expressionBuilder).build(queryStringFilter);
	}

}
