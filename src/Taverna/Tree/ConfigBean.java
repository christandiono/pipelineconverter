package Taverna.Tree;

public class ConfigBean extends TavernaNode {
	public ConfigBean(){}
	
	public ConfigBean(String enc){
		encoding = enc;
	}
	
	private String encoding;

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
}
