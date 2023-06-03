package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import Helper.DriverManager;
import PageObject.TodoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreatingToDoStepDefinition {
	
	private DriverManager dm;
	private static TodoPage todoPage;
	private String url = "https://todomvc.com/examples/vanillajs/";
	//private static DriverManager dm;
	//WebDriver driver = dm.getDriver();
	

	@Given("I am on the todo page")
	public void i_am_on_the_todo_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("I am on the todo page");
	    todoPage = new TodoPage(dm.getDriver());
	    dm.getDriver().get("https://todomvc.com/examples/vanillajs/");
	    
	}
	
	@When("I add {string} to the todo list")
	public void i_add_to_the_todo_list(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("To do added");
		todoPage.addTodo(string);
		assertTrue(todoPage.existTodo() == true);
	}

	@Then("I see {string} in the todo list")
	public void i_see_in_the_todo_list(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Todo visible");
	    
	}
}
