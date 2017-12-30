package items;

import java.util.LinkedList;
import java.util.List;

public class Configuration {
	public List<BooleanEquation> equation_list;
	
	public Configuration(List<BooleanEquation> el){
		equation_list=el;
	}
	
	public Configuration(Configuration c){
		if(c!=null && c.equation_list!=null){
			equation_list = new LinkedList<BooleanEquation>();
			for(int i=0;i<c.equation_list.size();i++){
				equation_list.add(c.equation_list.get(i));
			}
		}
	}
	
	public Configuration(){
		equation_list=new LinkedList<BooleanEquation>();
	}
	
	public void addBool(BooleanEquation be){
		equation_list.add(be);
	}
	
	
}
