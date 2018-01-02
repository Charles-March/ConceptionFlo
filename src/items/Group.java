package items;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import xmlParser.ParserGroup;

public class Group {
	public LinkedList<Item_In_Group> item_list;
	public String name;
	public String entireName;
	
	public Group(String name,String entireName,LinkedList<Item_In_Group> itemList){
		this.name=name;
		this.entireName=entireName;
		item_list = new LinkedList<Item_In_Group>();
		for(int i=0;i<itemList.size();i++){
			Item_In_Group item = itemList.get(i).clone();
			if(item!=null){
				item_list.add(itemList.get(i).clone());
			}
		}
		
		if(itemList.size() != item_list.size()){
			System.out.println("probléme lors du chargement d'un item dans le groupe : "+name);
		}
	}
	
	private Group(String path){
		Group g = ParserGroup.parse(path);
		if(g==null){
			System.out.println("Probléme avec le groupe : "+path);
		}
		else{
			copy(g);
		}
	}
	
	private void copy(Group g) {
		this.name=g.name;
		this.entireName=g.entireName;
		item_list = new LinkedList<Item_In_Group>();
		for(int i=0;i<g.item_list.size();i++){
			item_list.add(g.item_list.get(i));
		}
	}

	public static List<Group> get_all_groups(){
		LinkedList<Group> group_list = new LinkedList<Group>();
		
		File repertoire = new File(System.getProperty("user.dir") + Item.systemSeparator + "groups");
		File[] files=repertoire.listFiles();
		for(int i=0;i<files.length;i++){
			if(files[i].isFile() && files[i].getName().endsWith(".xml")){
				group_list.add(new Group(files[i].getAbsolutePath()));
			}
		}
		return group_list;
	}
	
}
