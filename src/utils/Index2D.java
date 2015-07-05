package utils;

public class Index2D {

	private int i , j;
	
	public Index2D(int i, int j){
		this.i = i;
		this.j = j;
	}
	
	public int getI(){
		return this.i;
	}
	public int getJ(){
		return this.j;
	}
	public void setIJ(int i, int j){
		this.i = i;
		this.j = j;
	}
	
	public String toString(){
		return "[" + this.i + ", " + this.j + "]";
	}
	
	
}
