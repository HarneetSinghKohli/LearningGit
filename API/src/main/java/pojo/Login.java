package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Login {

	

	private String userName;
	private String password;
	private String Status;
	private String Scope;
	
	@JsonProperty("userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@JsonProperty("Status")
	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}
	
	@JsonProperty("Scope")
	public String getScope() {
		return Scope;
	}

	public void setScope(String scope) {
		Scope = scope;
	}
}
