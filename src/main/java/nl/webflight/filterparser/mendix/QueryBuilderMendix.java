package nl.webflight.filterparser.mendix;

import java.util.List;

import nl.webflight.filterparser.BooleanExpression;
import nl.webflight.filterparser.ComparisonOperator;
import nl.webflight.filterparser.Expression;
import nl.webflight.filterparser.ExpressionType;
import nl.webflight.filterparser.IncompatibleExpressionException;
import nl.webflight.filterparser.QueryBuilder;

public class QueryBuilderMendix implements QueryBuilder {
	
	StringBuilder query = new StringBuilder();

	// TODO Implement mapping for field names 
	
	@Override
	public String build(List<Expression> expressions) throws IncompatibleExpressionException {
		
		for (Expression expression : expressions) {
			
			String queryToken = operatorToQueryToken(expression.getOperator());
			
			if(expression.getExpressionType().equals(ExpressionType.BOOLEAN)) {
				BooleanExpression booleanExpression = (BooleanExpression) expression;
				String booleanToken = booleanToQueryToken(booleanExpression.getValue());
				query.append(String.format("[%s %s %s]", booleanExpression.getField(), queryToken, booleanToken));
			}
			
			if(expression.getExpressionType().equals(ExpressionType.INTEGER) ||
				expression.getExpressionType().equals(ExpressionType.DECIMAL)) {
				query.append(String.format("[%s %s %s]", expression.getField(), queryToken, expression.getTextualValue()));
			}
			
			if(expression.getExpressionType().equals(ExpressionType.STRING)) {
				query.append(String.format("[%s %s '%s']", expression.getField(), queryToken, expression.getTextualValue()));
			}
			
		}
		
		return this.query.toString();
	}
	
	private String operatorToQueryToken(ComparisonOperator operator) throws IncompatibleExpressionException {
		if (operator.equals(ComparisonOperator.EQ)) {
			return "=";
		}
		
		if (operator.equals(ComparisonOperator.GE)) {
			return ">=";
		}
		
		if (operator.equals(ComparisonOperator.GT)) {
			return ">";
		}
		
		if (operator.equals(ComparisonOperator.LE)) {
			return "<=";
		}
		
		if (operator.equals(ComparisonOperator.LT)) {
			return "<";
		}
		
		if (operator.equals(ComparisonOperator.NE)) {
			return "!=";
		}
		
		throw new IncompatibleExpressionException("Could not process operator with token" + operator.getToken());
	}
	
	private String booleanToQueryToken(Boolean input) {
		if (input) {
			return "true()";
		}
		
		return "false()";
	}

}
