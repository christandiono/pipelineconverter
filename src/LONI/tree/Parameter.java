package LONI.tree;

public class Parameter extends LoniNode {


	private final String id;
	private final String name;
	private final String description;
	private final boolean enabled;
	private final boolean required;
	private final boolean predefined;
	private final boolean isMetadata;
	private final boolean isListFile;
	private final boolean isHideData;
	private final boolean includeTransformedParameter;
	private final int order;
	private final String prefix;
	private final boolean prefixSpaced;
	private final boolean prefixAllArgs;
	
	public Parameter(String id, String name, String description,
			boolean enabled, boolean required, boolean predefined,
			boolean isMetadata, boolean isListFile, boolean isHideData,
			boolean includeTransformedParameter, int order, String prefix,
			boolean prefixSpaced, boolean prefixAllArgs) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.enabled = enabled;
		this.required = required;
		this.predefined = predefined;
		this.isMetadata = isMetadata;
		this.isListFile = isListFile;
		this.isHideData = isHideData;
		this.includeTransformedParameter = includeTransformedParameter;
		this.order = order;
		this.prefix = prefix;
		this.prefixSpaced = prefixSpaced;
		this.prefixAllArgs = prefixAllArgs;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public boolean isRequired() {
		return required;
	}
	public boolean isPredefined() {
		return predefined;
	}
	public boolean isMetadata() {
		return isMetadata;
	}
	public boolean isListFile() {
		return isListFile;
	}
	public boolean isHideData() {
		return isHideData;
	}
	public boolean isIncludeTransformedParameter() {
		return includeTransformedParameter;
	}
	public int getOrder() {
		return order;
	}
	public String getPrefix() {
		return prefix;
	}
	public boolean isPrefixSpaced() {
		return prefixSpaced;
	}
	public boolean isPrefixAllArgs() {
		return prefixAllArgs;
	}
	
	
}
