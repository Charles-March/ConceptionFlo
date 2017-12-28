package items;

import java.util.LinkedList;
import java.util.List;

public class Configuration {
	public List<BooleanEquation> equation_list;
	
	public Configuration(List<BooleanEquation> el){
		equation_list=el;
	}
	
	public Configuration(Configuration c){
		equation_list=c.equation_list;
	}
	
	public Configuration(){
		equation_list=new LinkedList<BooleanEquation>();
	}
	
	
	
}
