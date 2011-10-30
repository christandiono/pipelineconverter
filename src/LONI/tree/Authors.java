package LONI.tree;

public class Authors extends LoniNode {


	public Authors(String fullName, String email, String website) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.website = website;
	}
	public String getFullName() {
		return fullName;
	}
	public String getEmail() {
		return email;
	}
	public String getWebsite() {
		return website;
	}
	private final String fullName;
	private final String email;
	private final String website;
}
