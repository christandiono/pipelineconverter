package Taverna.Tree;

import Taverna.Tree.TavernaNode;

public class Annotations extends TavernaNode {
	public Annotations()
	{
		
	}
	
	public AnnotationChain getAnnotationChain()
	{
		return annotationChain;
	}
	
	public void setAnnotationChain(AnnotationChain ac){
		annotationChain = ac;
	}
	
	// The .xsd file says you have a choice between two AnnotationChains with different names,
	// one is annotation_chain and another is annotation_chain_2_2, not sure if that will matter
	private AnnotationChain annotationChain;
}
