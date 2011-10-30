package Taverna.Tree;

public class Role extends TavernaNode {
	public Role(){}
	
	public Role(String r){
		role = r;
	}
	
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
