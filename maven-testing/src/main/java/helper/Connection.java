package helper;

public class Connection {
	private String firstName;
	private String lastName;
	
	public Connection(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastname() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
//	public ConnectionPage addConnection(Connection c)
//	{
//		fldFirstName.sendKeys(c.getFirstName());
//	}

}
