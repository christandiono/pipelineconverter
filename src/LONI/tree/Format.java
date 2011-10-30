package LONI.tree;

public class Format extends LoniNode {


	public Format(String type, int cardinality, String cardinalityBase,
			String transformationBase) {
		super();
		this.type = type;
		this.cardinality = cardinality;
		this.cardinalityBase = cardinalityBase;
		this.transformationBase = transformationBase;
	}
	public String getType() {
		return type;
	}
	public int getCardinality() {
		return cardinality;
	}
	public String getCardinalityBase() {
		return cardinalityBase;
	}
	public String getTransformationBase() {
		return transformationBase;
	}
	private final String type;
	private final int cardinality;
	private final String cardinalityBase;
	private final String transformationBase;
}
