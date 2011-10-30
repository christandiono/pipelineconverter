package Galaxy.Tree.Tool;

import java.util.ArrayList;
import java.util.List;

public class Inputs {
	private final Boolean nginxUpload;
	private final List<Parameter> inputList;
	
	public Inputs(Boolean nginxUpload) {
		super();
		this.nginxUpload = nginxUpload;
		this.inputList = new ArrayList<Parameter>();
	}
	
	public Boolean getNginxUpload() {
		return nginxUpload;
	}
	public List<Parameter> getInputList() {
		return inputList;
	}
	
	
}
