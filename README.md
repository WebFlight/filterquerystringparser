# FilterQueryStringParser

[![CircleCI](https://circleci.com/gh/WebFlight/filterquerystringparser.svg?style=svg)](https://circleci.com/gh/WebFlight/filterquerystringparser) [![codecov](https://codecov.io/gh/WebFlight/filterquerystringparser/branch/master/graph/badge.svg)](https://codecov.io/gh/WebFlight/filterquerystringparser)

A Java library that parses a query string parameter containing a filter expression according to the [Microsoft API guidelines](https://github.com/microsoft/api-guidelines/blob/vNext/Guidelines.md#97-filtering). This allows for advanced filtering in a collection without the need for the specification of each field. The library requires an implementation to translate a parsed expression into a database query.

## Supported operations
The operations below are supported by the library.

| Operator             | Description           | Example |
| -------------------- | --------------------- | ----------------------------------------------------- |
| Comparison Operators |                       | |
| eq                   | Equal                 | city eq 'Redmond' |
| ne                   | Not equal             | city ne 'London' |
| gt                   | Greater than          | price gt 20 |
| ge                   | Greater than or equal | price ge 10 |
| lt                   | Less than             | price lt 20 |
| le                   | Less than or equal    | price le 100 |
| Logical Operators    |                       | |
| and                  | Logical and           | price le 200 and price gt 3.5 |

## Implementation
Implement the ```QueryBuilder``` interface to create your own implementation for a backend. The implementation contains a method with the signature ```public String build(List<Expression> expressions)```. Construct a backend query based on the different types of expressions. The library distinguised four types of expressions:
* ```ExpressionType.BOOLEAN```
* ```ExpressionType.INTEGER```
* ```ExpressionType.DECIMAL```
* ```ExpressionType.STRING```

Expressions types can be derived using the ```expression.getType()``` method or check the ```instanceof``` that returns the appropriate subclass of the ```Expression``` class.

### Example Mendix backend
For a [Mendix](https://www.mendix.com) an implementation is already created that translates a list of expressions into an XPath (the supported format by Mendix for database queries).
```
package filterquerystring.impl;

import java.util.List;
import java.util.Optional;

import filterquerystring.proxies.FieldNameMapping;
import nl.webflight.filterparser.impl.BooleanExpression;
import nl.webflight.filterparser.impl.ComparisonOperator;
import nl.webflight.filterparser.impl.Expression;
import nl.webflight.filterparser.impl.ExpressionType;
import nl.webflight.filterparser.interfaces.QueryBuilder;

public class QueryBuilderMendix implements QueryBuilder {
	
	private StringBuilder query;
	private List<FieldNameMapping> fieldNameMappings;
	

	public QueryBuilderMendix(List<FieldNameMapping> fieldNameMappings) {
		this.query = new StringBuilder();
		this.fieldNameMappings = fieldNameMappings;
	}
	
	@Override
	public String build(List<Expression> expressions) {
		
		for (Expression expression : expressions) {
			String fieldName = getFieldNameFromMapping(expression.getField());
			
			String queryToken = operatorToQueryToken(expression.getOperator());
			
			if(expression.getExpressionType().equals(ExpressionType.BOOLEAN)) {
				BooleanExpression booleanExpression = (BooleanExpression) expression;
				String booleanToken = booleanToQueryToken(booleanExpression.getValue());
				query.append(String.format("[%s %s %s]", fieldName, queryToken, booleanToken));
			}
			
			if(expression.getExpressionType().equals(ExpressionType.INTEGER) ||
				expression.getExpressionType().equals(ExpressionType.DECIMAL)) {
				query.append(String.format("[%s %s %s]", fieldName, queryToken, expression.getTextualValue()));
			}
			
			if(expression.getExpressionType().equals(ExpressionType.STRING)) {
				query.append(String.format("[%s %s '%s']", fieldName, queryToken, expression.getTextualValue()));
			}
			
		}
		
		return this.query.toString();
	}
	
	private String getFieldNameFromMapping(String fieldName) {
		Optional<FieldNameMapping> fieldNameMapping = fieldNameMappings.stream()
				.filter(m -> m.getFilterName().equals(fieldName))
				.findFirst();
		
		if(fieldNameMapping.isPresent()) {
			return fieldNameMapping.get().getAttributeFieldName();
		}
		
		return fieldName;
	}
	
	private String operatorToQueryToken(ComparisonOperator operator){
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
		
		return "";
	}
	
	private String booleanToQueryToken(Boolean input) {
		if (input) {
			return "true()";
		}
		
		return "false()";
	}

}
```

## Usage
When the ```QueryBuilder``` interface has been implemented, the library can be used as follows:
```
QueryBuilder queryBuilderImplementation = new QueryBuilderImplementation();
QueryFilterParser queryFilterParser = QueryFilterParserCreator.getQueryFilterParser(queryBuilderImplementation, new ExpressionBuilderFactory(), new ExpressionCreatorFactory());
String query = queryFilterParser.parse(filterQueryString);
```

## Contributions
For your contributions, issue a pull request to the develop branch. CircleCI will run the unit tests and check code coverage. Make sure the following requirements are met:
* All unit tests pass
* Each class should have at least one test
* Bundle code coverage should be at least 95%
