package Taverna.Tree;
import java.util.List;
import java.util.ArrayList;

public class AnnotatedGranularDepthPort extends GranularDepthPort {
	public List<Annotations> annotations;
	
	AnnotatedGranularDepthPort() {
		annotations = new ArrayList<Annotations>();
	}
	
	public List<Annotations> getAnnotations() {
		return annotations;
	}
	
	public void addAnnotions(Annotations annotation) {
		annotations.add(annotation);
	}
}