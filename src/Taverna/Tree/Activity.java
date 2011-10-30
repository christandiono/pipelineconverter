package Taverna.Tree;

import Taverna.Tree.TavernaNode;

public class Activity extends TavernaNode {
	public Activity()
	{
		
	}
	
	private Raven raven;
	private String theClass;
	
	public String getTheClass() {
		return theClass;
	}
	public void setTheClass(String theClass) {
		this.theClass = theClass;
	}
	public Raven getRaven() {
		return raven;
	}
	public void setRaven(Raven raven) {
		this.raven = raven;
	}
	public TavMap getInputMap() {
		return inputMap;
	}
	public void setInputMap(TavMap inputMap) {
		this.inputMap = inputMap;
	}
	public TavMap getOutputMap() {
		return outputMap;
	}
	public void setOutputMap(TavMap outputMap) {
		this.outputMap = outputMap;
	}
	public ConfigBean getConfigBean() {
		return configBean;
	}
	public void setConfigBean(ConfigBean configBean) {
		this.configBean = configBean;
	}
	public Annotations getAnnotations() {
		return annotations;
	}
	public void setAnnotations(Annotations annotations) {
		this.annotations = annotations;
	}

	private TavMap inputMap;
	private TavMap outputMap;
	private ConfigBean configBean;
	private Annotations annotations;
}
