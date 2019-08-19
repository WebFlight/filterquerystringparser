package nl.webflight.filterparser.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nl.webflight.filterparser.exceptions.InvalidExpressionTypeException;
import nl.webflight.filterparser.exceptions.UnparsableFilterExpressionException;
import nl.webflight.filterparser.interfaces.ExpressionCreator;

public class ExpressionBuilder {
	
	private static final String INTEGER_DEFINITION = "^\\-?[0-9]+$";
	private static final String STRING_DEFINITION = "^'[\\W\\w]*'$";
	private static final String DECIMAL_DEFINITION = "^\\-?[0-9]+\\.[0-9]+$";
	private static final String BOOLEAN_DEFINITION = "^true|false$";
	
	private ExpressionCreator expressionCreator;
	private FilterPatternProvider regexPatternProvider = new FilterPatternProvider(new OperatorValueExtractorImpl());
	
	public ExpressionBuilder(ExpressionCreator expressionCreator) {
		this.expressionCreator = expressionCreator;
	}
	
	public List<Expression> build(String filterExpression) throws InvalidExpressionTypeException, UnparsableFilterExpressionException {
		
		if (entireExpressionDoesNotMatchPattern(filterExpression)) {
			throw new UnparsableFilterExpressionException("Expression " + filterExpression + " is invalid");
		}
		
		Pattern pattern = regexPatternProvider.getPattern();
		Matcher matcher = pattern.matcher(filterExpression);
		List<Expression> expressions = new ArrayList<>();
		
		while(matcher.find()) {
			String expression = matcher.group(0);
			String field = matcher.group(1);
			String operator = matcher.group(2);
			String value = matcher.group(3);
			
			Expression parsedExpression = getExpressionBasedOnValue(value);
			ComparisonOperator parsedOperator = getOperator(operator).orElseThrow(() -> new UnparsableFilterExpressionException("Could not find operator in expression " + expression));
			parsedExpression.setField(field);
			parsedExpression.setOperator(parsedOperator);
			parsedExpression.setValue(value);
			expressions.add(parsedExpression);	
		}
		
		return expressions;
	}
	
	private boolean entireExpressionDoesNotMatchPattern(String filterExpression) {
		Pattern pattern = regexPatternProvider.getPatternForFullMatch();
		Matcher matcher = pattern.matcher(filterExpression);
		boolean expressionDoesNotMatch = (matcher.matches() == false);
		return expressionDoesNotMatch;
	}
	
	private Expression getExpressionBasedOnValue(String value) throws UnparsableFilterExpressionException, InvalidExpressionTypeException {
		
		if(value.matches(STRING_DEFINITION)) {
			return expressionCreator.getExpression(ExpressionType.STRING);
		}
		
		if(value.matches(INTEGER_DEFINITION)) {
			return expressionCreator.getExpression(ExpressionType.INTEGER);
		}
		
		if(value.matches(DECIMAL_DEFINITION)) {
			return expressionCreator.getExpression(ExpressionType.DECIMAL);
		}
		
		if(value.matches(BOOLEAN_DEFINITION)) {
			return expressionCreator.getExpression(ExpressionType.BOOLEAN);
		}
		
		throw new UnparsableFilterExpressionException("Could not parse expression with value: " + value);
	}
	
	private Optional<ComparisonOperator> getOperator(String input) {
		ComparisonOperator[] operators = ComparisonOperator.values();
		List<ComparisonOperator> operatorList = Arrays.asList(operators);
		Optional<ComparisonOperator> operator = operatorList.stream()
				.filter(o -> o.getToken().equals(input))
				.findFirst();
		return operator;
	}
	
}