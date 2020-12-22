package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Defination1 {

	@Given("userName and Password")
	public void username_and_Password() {
	    System.out.println("asda");
	}

	@When("click on button")
	public void click_on_button() {
		System.out.println("asda");
	}

	@Then("home Page Opens")
	public void home_Page_Opens() {
		System.out.println("asda");
	}
	
}
