package items;

public class Item_In_Group {
	public int id;
	public String name;
	
	public Item_In_Group(int id,String name){
		this.id=id;
		this.name=name;
	}
	
	public Item_In_Group clone(){
		return new Item_In_Group(id, name);
	}
}
