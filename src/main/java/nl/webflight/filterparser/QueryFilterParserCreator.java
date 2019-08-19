package nl.webflight.filterparser;

import nl.webflight.filterparser.impl.ExpressionBuilder;
import nl.webflight.filterparser.impl.ExpressionCreatorImpl;
import nl.webflight.filterparser.interfaces.QueryBuilder;

public class QueryFilterParserCreator {
	
	public static QueryFilterParser getQueryFilterParser(QueryBuilder queryBuilder) {
		return new QueryFilterParser(queryBuilder, new ExpressionBuilder(new ExpressionCreatorImpl()));
	}

}
