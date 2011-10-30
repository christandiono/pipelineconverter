package Taverna.Tree;

import java.util.ArrayList;
import java.util.List;

public class DispatchStack extends TavernaNode {
	public DispatchStack(){
		dispatchLayers = new ArrayList<DispatchLayer>();
	}
	
	private List<DispatchLayer> dispatchLayers;

	public List<DispatchLayer> getDispatchLayers() {
		return dispatchLayers;
	}

	public void setDispatchLayers(List<DispatchLayer> dispatchLayers) {
		this.dispatchLayers = dispatchLayers;
	}
}
