package nl.webflight.filterparser;

public enum ComparisonOperator implements Operator{
	
	GT(		"gt", 	"Greater Than"),
	GE(		"ge", 	"Greater than or Equal"),
	LT(		"lt", 	"Less Than"),
	LE(		"le", 	"Less than or Equal"),
	EQ(		"eq", 	"Equal"),
	NE(		"ne", 	"Not Equal"),
	;
	
	private String token;
	@SuppressWarnings("unused")
	private String description;
	
	ComparisonOperator(String token, String description) {
		this.token = token;
		this.description = description;
	}
	
	public String getToken() {
		return this.token;
	}
	
}
