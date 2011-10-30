package LONI.tree;

public class Variable extends LoniNode {


	private final String name;
	private final String description;
	private final boolean required;
	private final boolean secret;
	private final int order;
	
	public Variable(String name, String description, boolean required,
			boolean secret, int order) {
		super();
		this.name = name;
		this.description = description;
		this.required = required;
		this.secret = secret;
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isRequired() {
		return required;
	}

	public boolean isSecret() {
		return secret;
	}

	public int getOrder() {
		return order;
	}
	
	
	
}
