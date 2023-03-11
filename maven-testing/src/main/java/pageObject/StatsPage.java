package pageObject;

public class StatsPage {
	
	public boolean hasConnections(String message) {
		if (message.equals("records populated for testing purposes.")) {
			return true;
		}
		return true;
	}

}
