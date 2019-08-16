package nl.webflight.filterparser;

public class OperatorValueExtractorImpl implements OperatorValueExtractor {

	@Override
	public Operator[] getLogicalOperatorValues() {
		return LogicalOperator.values();
	}

	@Override
	public Operator[] getComparisonOperatorValues() {
		return ComparisonOperator.values();
	}

}
