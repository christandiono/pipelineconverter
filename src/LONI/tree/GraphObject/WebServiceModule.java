package LONI.tree.GraphObject;

import LONI.tree.LoniNode;

public class WebServiceModule extends LoniNode {

	private final String name;
	private final String id;
	private final String description;
	private final String version;
	private final String myPackage;
	private final String icon;
	private final String wsdlLocation;
	private final String selectedInterface;
	private final String selectedOperation;
	private final String executionServer;
	private final int rotation;
	
	
	public WebServiceModule(String name, String id, String description,
			String version, String myPackage, String icon, String wsdlLocation,
			String selectedInterface, String selectedOperation,
			String executionServer, int rotation) {
		super();
		this.name = name;
		this.id = id;
		this.description = description;
		this.version = version;
		this.myPackage = myPackage;
		this.icon = icon;
		this.wsdlLocation = wsdlLocation;
		this.selectedInterface = selectedInterface;
		this.selectedOperation = selectedOperation;
		this.executionServer = executionServer;
		this.rotation = rotation;
	}
	
}
