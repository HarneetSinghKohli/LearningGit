package resources;

public enum APIResources {

	getSuccess("/getSuccess"),
	deleteSuccess("/getSuccess");
	
	
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;	// At this point constructor assigns value passed in the constructor to the local variable
								//i.e getSuccess , once this is done then constructor assigns value of getSuccess i.e /getSuccess gets assigned
								//to the private global variable resources and when we call getResources then this variable value is returned
	};
	
	public String returnResource() {
		return resource;		// And at this point this value is returned
	}
}
