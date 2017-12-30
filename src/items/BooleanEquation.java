package items;

public class BooleanEquation {
	public int id;
	public int controller=0;
	public boolean state;
	
	public BooleanEquation(int id,boolean state){
		this.id=id;
		this.state = state;
	}
	
	public BooleanEquation(int id,int controller,boolean state){
		this.id=id;
		this.state=state;
		this.controller=controller;
	}
}
