package nl.webflight.filterparser;

import java.util.List;

public class QueryFilterParser {
	
	private ExpressionBuilder expressionBuilder;
	private QueryBuilder queryBuilder;
	
	protected QueryFilterParser(QueryBuilder queryBuilder, ExpressionBuilder expressionBuilder) {
		this.expressionBuilder = expressionBuilder;
		this.queryBuilder = queryBuilder;
	}
	
	public String parse(String filterExpression) throws InvalidExpressionTypeException, UnparsableFilterExpressionException, IncompatibleExpressionException {
		List<Expression> expressions = expressionBuilder.build(filterExpression);
		String parsedFilterExpression = queryBuilder.build(expressions);
		return parsedFilterExpression;
	}
}