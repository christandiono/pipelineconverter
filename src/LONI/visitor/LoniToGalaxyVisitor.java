package LONI.visitor;

import Galaxy.Tree.Workflow.Workflow;
import LONI.tree.Pipeline;

public class LoniToGalaxyVisitor extends DFSVisitor {

	public Object visit(Pipeline pipeline) {
		Workflow workflow;

		workflow = new Workflow(null, null, null, false);
		return workflow;
	}

}
