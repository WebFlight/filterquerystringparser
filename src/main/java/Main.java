
import nl.webflight.filterparser.IncompatibleExpressionException;
import nl.webflight.filterparser.InvalidExpressionTypeException;
import nl.webflight.filterparser.QueryBuilder;
import nl.webflight.filterparser.QueryFilterParser;
import nl.webflight.filterparser.QueryFilterParserCreator;
import nl.webflight.filterparser.UnparsableFilterExpressionException;
import nl.webflight.filterparser.mendix.QueryBuilderMendix;

public class Main {
	public static void main(String[] args) {
		String filterExpression = "name eq 'test eq' and price eq 100 and type eq 'room eq and' and temp lt -20 and diff ge -14.28 and active eq true";
		 
		QueryBuilder queryBuilder = new QueryBuilderMendix();
		
			QueryFilterParser queryFilterParser = QueryFilterParserCreator.getQueryFilterParser(queryBuilder);
			String query;
			try {
				query = queryFilterParser.parse(filterExpression);
				System.out.format("Input: %s\nQuery: %s", filterExpression, query);
			} catch (InvalidExpressionTypeException | UnparsableFilterExpressionException | IncompatibleExpressionException e) {
				e.printStackTrace();
			}
			
		 
	}
}
