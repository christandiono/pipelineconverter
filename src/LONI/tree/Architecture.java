package LONI.tree;

public class Architecture extends LoniNode {


	public String getName() {
		return name;
	}

	public String getVendor() {
		return vendor;
	}

	public String getModel() {
		return model;
	}

	public String getProcessorFlags() {
		return processorFlags;
	}

	private final String name;
	private final String vendor;
	private final String model;
	private final String processorFlags;
	
	public Architecture(String name, String vendor, String model,
			String processorFlags) {
		super();
		this.name = name;
		this.vendor = vendor;
		this.model = model;
		this.processorFlags = processorFlags;
	}
}
