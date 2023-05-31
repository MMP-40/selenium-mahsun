package PageObject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TodoPage {
	
	@FindBy(how = How.XPATH, using = "/html/body/section/header/input")
	private WebElement inputTodo;
	
	@FindBy(how = How.XPATH, using = "/html/body/section/section/ul")
	private List<WebElement> listTodo;
	
	@FindBy(how = How.XPATH, using = "/html/body/section/footer/ul/li[1]/a")
	private WebElement allTodo;
	
	@FindBy(how = How.XPATH, using = "/html/body/section/footer/ul/li[2]/a")
	private WebElement activeTodo;
	
	@FindBy(how = How.XPATH, using = "/html/body/section/footer/ul/li[3]/ae")
	private WebElement completedTodo;
	
	@FindBy(how = How.XPATH, using = "/html/body/section/footer/button")
	private WebElement clearCompletedTodo;
	
	@FindBy(how = How.XPATH, using = "/html/body/section/section/ul/li[2]/div/button")
	private WebElement destroyTodo;
	
	private WebDriver driver;
	
	public TodoPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	// add a todo
	public void addTodo(String textTodo) {
		inputTodo.clear();
		inputTodo.sendKeys(textTodo);
		inputTodo.sendKeys(Keys.RETURN);
	}
	
	// check if there are existing todo(s)
	public boolean existTodo() {
		allTodo.click();
		if (listTodo.size() > 0) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	

}
