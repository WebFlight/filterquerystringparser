package nl.webflight.filterparser;

import java.util.List;

/**
* Interface for implementation of your custom Query Builder.
* The implementation receives a parsed expression and returns a query that is used to retrieve data from a back-end system.
* 
*/
public interface QueryBuilder {
	
	/**
	 * Build the query based on the expression.
	 * @param expressions List of expressions.
	 * @return Query that is used to retrieve information from a back-end system.
	 * @throws IncompatibleExpressionException If an expression implementation is not implemented in the QueryBuilder, throw this exception.
	 */
	public String build(List<Expression> expressions) throws IncompatibleExpressionException;

}
