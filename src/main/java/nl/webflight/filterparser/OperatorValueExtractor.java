package nl.webflight.filterparser;

public interface OperatorValueExtractor {
	
	public Operator[] getLogicalOperatorValues();
	public Operator[] getComparisonOperatorValues();

}
