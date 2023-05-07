package com.mycompany.app;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreatingToDoStepDefinition {

	@Given("I am on the todo page")
	public void i_am_on_the_todo_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("I am on the todo page");
	}

	@When("I add the task to the")
	public void i_add_the_task_to_the() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("I added the task");
	}

	@Then("I see the task in the todo list")
	public void i_see_the_task_in_the_todo_list() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("I see the task on the list");
	}
}
