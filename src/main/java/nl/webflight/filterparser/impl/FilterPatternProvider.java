package nl.webflight.filterparser.impl;

import java.util.regex.Pattern;

import nl.webflight.filterparser.interfaces.OperatorValueExtractor;

public class FilterPatternProvider {
	
	private final String fieldExpression = "([\\w]*)";
	private final String valueExpression = "(('[^']*')|([\\-]?[\\d]+(?:.?\\d+)?)|(true|false))";
	private OperatorValueExtractor operatorValueExtractor;
	
	protected FilterPatternProvider(OperatorValueExtractor operatorValueExtractor) {
		this.operatorValueExtractor = operatorValueExtractor;
	}
	
	protected Pattern getPatternForFullMatch() {
		String partialRegex = buildRegex();
		String regex = String.format("^(%s)+$", partialRegex);
		Pattern pattern = Pattern.compile(regex);
		return pattern;
	}
	
	protected Pattern getPattern() {
		String regex = buildRegex();
		Pattern pattern = Pattern.compile(regex);
		return pattern;
	}
	
	private String buildRegex() {
		String regex = String.format("%s (%s) %s( %s )?" , 
				fieldExpression, 
				getOperatorExpression(operatorValueExtractor.getComparisonOperatorValues()), 
				valueExpression, 
				getOperatorExpression(operatorValueExtractor.getLogicalOperatorValues()));
		return regex;
	}
	
	private String getOperatorExpression(Operator[] operators) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Operator operator : operators) {
			appendWithoutPipeIfEmpty(stringBuilder, operator.getToken());
		}
		return stringBuilder.toString();
	}
	
	private StringBuilder appendWithoutPipeIfEmpty(StringBuilder stringBuilder, String stringToAppend) {
		boolean stringBuilderIsEmpty = (stringBuilder.length() == 0); 
		if(stringBuilderIsEmpty) {
			stringBuilder.append(stringToAppend);
		}
		if(!stringBuilderIsEmpty) {
			stringBuilder.append("|" + stringToAppend);
		}
		return stringBuilder;
	}

}
