package nl.webflight.filterparser;

import java.util.List;

import nl.webflight.filterparser.exceptions.InvalidExpressionTypeException;
import nl.webflight.filterparser.exceptions.UnparsableFilterExpressionException;
import nl.webflight.filterparser.impl.Expression;
import nl.webflight.filterparser.impl.ExpressionBuilder;
import nl.webflight.filterparser.interfaces.QueryBuilder;

public class QueryFilterParser {
	
	private ExpressionBuilder expressionBuilder;
	private QueryBuilder queryBuilder;
	
	protected QueryFilterParser(QueryBuilder queryBuilder, ExpressionBuilder expressionBuilder) {
		this.expressionBuilder = expressionBuilder;
		this.queryBuilder = queryBuilder;
	}
	
	public String parse(String filterExpression) throws InvalidExpressionTypeException, UnparsableFilterExpressionException {
		List<Expression> expressions = expressionBuilder.build(filterExpression);
		String parsedFilterExpression = queryBuilder.build(expressions);
		return parsedFilterExpression;
	}
}