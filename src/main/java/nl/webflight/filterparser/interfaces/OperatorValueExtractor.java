package nl.webflight.filterparser.interfaces;

import nl.webflight.filterparser.impl.Operator;

public interface OperatorValueExtractor {
	
	public Operator[] getLogicalOperatorValues();
	public Operator[] getComparisonOperatorValues();

}
