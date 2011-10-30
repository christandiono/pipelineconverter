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
}
