package LONI.tree;


public class Connection extends LoniNode {
	String Source;
	String Sink;
	
	public Connection(String source, String sink){
		this.Source = source;
		this.Sink = sink;
	}
}
