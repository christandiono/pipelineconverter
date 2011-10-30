package LONI.tree;

public class Style extends LoniNode {


	private final String name;
	private final String fontSize;
	private final boolean isBold;
	private final boolean isItalic;
	
	public Style(String name, String fontSize, boolean isBold, boolean isItalic) {
		super();
		this.name = name;
		this.fontSize = fontSize;
		this.isBold = isBold;
		this.isItalic = isItalic;
	}

	public String getName() {
		return name;
	}

	public String getFontSize() {
		return fontSize;
	}

	public boolean isBold() {
		return isBold;
	}

	public boolean isItalic() {
		return isItalic;
	}
	
}
