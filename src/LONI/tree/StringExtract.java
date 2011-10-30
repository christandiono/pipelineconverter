package LONI.tree;

public class StringExtract extends LoniNode {


	private final String source;
	private final String rule;
	private final String startString;
	private final String endString;
	private final boolean caseSensitive;
	private final String delimiter;
	private final int row;
	private final int col;
	
	public StringExtract(String source, String rule, String startString,
			String endString, boolean caseSensitive, String delimiter, int row,
			int col) {
		super();
		this.source = source;
		this.rule = rule;
		this.startString = startString;
		this.endString = endString;
		this.caseSensitive = caseSensitive;
		this.delimiter = delimiter;
		this.row = row;
		this.col = col;
	}

	public String getSource() {
		return source;
	}

	public String getRule() {
		return rule;
	}

	public String getStartString() {
		return startString;
	}

	public String getEndString() {
		return endString;
	}

	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	public String getDelimiter() {
		return delimiter;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	
}
