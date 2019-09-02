package nl.webflight.filterparser.impl;

public class FilterPatternProviderFactory {
	
	protected FilterPatternProvider getFilterPatternProvider() {
		return new FilterPatternProvider(new OperatorValueExtractorImpl());
	}

}
