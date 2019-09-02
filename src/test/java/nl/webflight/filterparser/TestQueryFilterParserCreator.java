package nl.webflight.filterparser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import nl.webflight.filterparser.impl.ExpressionBuilderFactory;
import nl.webflight.filterparser.impl.ExpressionCreatorFactory;
import nl.webflight.filterparser.interfaces.QueryBuilder;

class TestQueryFilterParserCreator {
	
	static QueryBuilder queryBuilder;
	static ExpressionBuilderFactory expressionBuilderFactory;
	static ExpressionCreatorFactory expressionCreatorFactory;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		queryBuilder = Mockito.mock(QueryBuilder.class);
		expressionBuilderFactory = Mockito.mock(ExpressionBuilderFactory.class);
		expressionCreatorFactory = Mockito.mock(ExpressionCreatorFactory.class);
	}

	@Test
	void testGetQueryFilterParser() {
		QueryFilterParser queryFilterParser = QueryFilterParserCreator.getQueryFilterParser(queryBuilder, expressionBuilderFactory, expressionCreatorFactory);
		assertEquals(QueryFilterParser.class, queryFilterParser.getClass());
	}
	
	@Test
	void testGInstantiateQueryFilterParser() {
		QueryFilterParserCreator queryFilterParserCreator = new QueryFilterParserCreator();
		assertEquals(QueryFilterParserCreator.class, queryFilterParserCreator.getClass());
	}

}
