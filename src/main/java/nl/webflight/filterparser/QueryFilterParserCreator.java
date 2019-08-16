package nl.webflight.filterparser;

public class QueryFilterParserCreator {
	
	public static QueryFilterParser getQueryFilterParser(QueryBuilder queryBuilder) {
		return new QueryFilterParser(queryBuilder, new ExpressionBuilder(new ExpressionCreatorImpl()));
	}

}
