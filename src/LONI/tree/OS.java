package LONI.tree;

public class OS extends LoniNode {


	private final String name;
	private final String version;
	private final String distribution;
	private final String kernelName;
	private final String kernelVersion;
	
	public OS(String name, String version, String distribution,
			String kernelName, String kernelVersion) {
		super();
		this.name = name;
		this.version = version;
		this.distribution = distribution;
		this.kernelName = kernelName;
		this.kernelVersion = kernelVersion;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public String getDistribution() {
		return distribution;
	}

	public String getKernelName() {
		return kernelName;
	}

	public String getKernelVersion() {
		return kernelVersion;
	}
	
	
	
}
