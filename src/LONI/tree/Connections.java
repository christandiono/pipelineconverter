package LONI.tree;

import java.util.ArrayList;
import java.util.List;

public class Connections extends LoniNode {
	List<Connection> connections;
	
	public Connections(){
		connections = new ArrayList<Connection>();
	}

	public void addConnection(Connection connection){
		connections.add(connection);
	}
	public void addConnections(List<Connection> connections){
		this.connections.addAll(connections);
	}
}
