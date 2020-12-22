package resources;

import pojo.Login;

public class TestData {
	Login L=new Login();

	public Login credentialsPayload(String userName,String password,String scope,String Status) {
		
		L.setUserName(userName);
		L.setPassword(password);
		L.setScope(scope);
		L.setStatus(Status);
		return L;
	
		
		
	}
	
}
