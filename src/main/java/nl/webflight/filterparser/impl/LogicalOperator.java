package nl.webflight.filterparser.impl;

public enum LogicalOperator implements Operator{
	
	//NOT(	"not", 	"Logical Negation"),
	AND(	"and", 	"Logical And"),
	//OR(		"or", 	"Logical Or")
	;
	
	private String token;
	@SuppressWarnings("unused")
	private String description;
	
	LogicalOperator(String token, String description) {
		this.token = token;
		this.description = description;
	}
	
	public String getToken() {
		return this.token;
	}
	
}
