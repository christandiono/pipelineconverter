package Galaxy.Visitor;

import Galaxy.Tree.Workflow.*;

public interface GalaxyVisitor<T> {
	
	public T visit(Workflow workflow);
	public T visit(Step step);
	public T visit(ExternalInput externalInput);
	public T visit(ExternalOutput externalOutput);
	public T visit(InputConnection inputConnection);
	public T visit(Position position);
	
	
	

}
