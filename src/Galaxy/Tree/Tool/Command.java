package Galaxy.Tree.Tool;

public class Command {
	private final String interpereter;
	private final String command;
	
	public Command(String interpereter, String command){
		this.interpereter = interpereter;
		this.command = command;
	}

	public String getInterpereter() {
		return interpereter;
	}

	public String getCommand() {
		return command;
	}
}
