package Taverna.Tree.Layers;
import Taverna.Tree.TavernaNode;

public class LoopConfig extends TavernaNode {
	private final String conditionXML;
	private final boolean runFirst;
	private final Properties properties;
	
	public LoopConfig(String conditionXML, boolean runFirst, Properties properties){
		this.conditionXML = conditionXML;
		this.runFirst = runFirst;
		this.properties = properties;
	}

	public String getConditionXML() {
		return conditionXML;
	}

	public boolean isRunFirst() {
		return runFirst;
	}

	public Properties getProperties() {
		return properties;
	}
}