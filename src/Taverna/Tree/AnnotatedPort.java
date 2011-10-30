package Taverna.Tree;
import java.util.List;
import java.util.ArrayList;

public class AnnotatedPort extends Port {
	public List<Annotations> annotations;
	
	AnnotatedPort() {
		annotations = new ArrayList<Annotations>();
	}
	
	public List<Annotations> getAnnotations() {
		return annotations;
	}
	
	public void addAnnotions(Annotations annotation) {
		annotations.add(annotation);
	}
}