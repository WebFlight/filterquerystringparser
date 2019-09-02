package nl.webflight.filterparser;

import nl.webflight.filterparser.impl.ExpressionBuilderFactory;
import nl.webflight.filterparser.impl.ExpressionCreatorFactory;
import nl.webflight.filterparser.interfaces.QueryBuilder;

public class QueryFilterParserCreator {
	
	public static QueryFilterParser getQueryFilterParser(QueryBuilder queryBuilder, ExpressionBuilderFactory expressionBuilderFactory, ExpressionCreatorFactory expressionCreatorFactory) {
		return new QueryFilterParser(queryBuilder, expressionBuilderFactory.getExpressionBuilder(expressionCreatorFactory));
	}

}
