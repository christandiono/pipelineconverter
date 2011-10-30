package LONI.tree;

public class DataModule extends LoniNode {



	public DataModule(String id, String name, String myPackage, String version,
			String description, int posX, int posY, int rotation, String type,
			boolean source, boolean dirSource, boolean dirDump,
			boolean useDirSourceFilters, int dirSourceFilterType,
			boolean recursive, FileTypes fileTypes, Metadata metadata) {
		super();
		this.id = id;
		this.name = name;
		this.myPackage = myPackage;
		this.version = version;
		this.description = description;
		this.posX = posX;
		this.posY = posY;
		this.rotation = rotation;
		this.type = type;
		this.source = source;
		this.dirSource = dirSource;
		this.dirDump = dirDump;
		this.useDirSourceFilters = useDirSourceFilters;
		this.dirSourceFilterType = dirSourceFilterType;
		this.recursive = recursive;
		this.fileTypes = fileTypes;
		this.metadata = metadata;
	}
	public FileTypes getFileTypes() {
		return fileTypes;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getMyPackage() {
		return myPackage;
	}
	public String getVersion() {
		return version;
	}
	public String getDescription() {
		return description;
	}
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	public int getRotation() {
		return rotation;
	}
	public String getType() {
		return type;
	}
	public boolean isSource() {
		return source;
	}
	public boolean isDirSource() {
		return dirSource;
	}
	public boolean isDirDump() {
		return dirDump;
	}
	public boolean isUseDirSourceFilters() {
		return useDirSourceFilters;
	}
	public int getDirSourceFilterType() {
		return dirSourceFilterType;
	}
	public boolean isRecursive() {
		return recursive;
	}
	public Metadata getMetadata() {
		return metadata;
	}
	private final String id;
	private final String name;
	private final String myPackage;
	private final String version;
	private final String description;
	private final int posX;
	private final int posY;
	private final int rotation;
	private final String type;
	private final boolean source;
	private final boolean dirSource;
	private final boolean dirDump;
	private final boolean useDirSourceFilters;
	private final int dirSourceFilterType;
	private final boolean recursive;
	private final FileTypes fileTypes;
	private final Metadata metadata;

}
