package FileOps.JSON;

public interface JSONGenerator<T>{
	public void bindHandler(JSONHandler handler);
	public void bindTag(Class<?> parent, String field, String tag);
	public void generate(T object);
	public void generate(T object, String path);

}
