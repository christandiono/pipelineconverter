package Taverna.Tree;

public class DispatchLayer extends TavernaNode {
	public DispatchLayer(){}
	
	public DispatchLayer(Raven r, String c, ConfigBean cb){
		raven = r;
		className = c;
		configBean = cb;
	}
	
	Raven raven;
	public Raven getRaven() {
		return raven;
	}

	public void setRaven(Raven raven) {
		this.raven = raven;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public ConfigBean getConfigBean() {
		return configBean;
	}

	public void setConfigBean(ConfigBean configBean) {
		this.configBean = configBean;
	}

	String className;
	ConfigBean configBean;
}
