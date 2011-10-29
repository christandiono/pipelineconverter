package Core;

public class Pair<U,V>{
	private U elem1;
	private V elem2;
	public Pair(U elem1, V elem2){
		this.elem1 = elem1;
		this.elem2 = elem2;
	}
	public U getElem1(){
		return elem1;
	}
	public V getElem2(){
		return elem2;
	}
	public void setElem2( V e2){
		this.elem2 = e2;
	}
	public void setElem1( U e1){
		this.elem1 = e1;
	}
	
	

}
