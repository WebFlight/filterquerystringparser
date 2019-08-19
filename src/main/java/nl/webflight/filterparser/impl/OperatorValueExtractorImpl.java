package nl.webflight.filterparser.impl;

import nl.webflight.filterparser.interfaces.OperatorValueExtractor;

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
