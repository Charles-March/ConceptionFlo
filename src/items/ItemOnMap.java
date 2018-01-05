package items;

import java.awt.Image;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import main.Main;

public class ItemOnMap {
	public int refId;
	public List<Integer> toControllerid=new LinkedList<Integer>();
	public List<Integer> fromControllerid=new LinkedList<Integer>();
	public Configuration config = null;
	public String name;
	
	
	public Image getImage(){
		return Main.item_list.get(refId).getImage();
	}
	
	private ItemOnMap(){
		
	}
	
	public ItemOnMap(Item i){
		refId = i.id;
		
		if(i.toController>0){
			Main.to_pc_list.add(this);
			name="Output"+(Main.toController+1);
			for(int j=0;j<i.toController;j++){
				Main.toController++;
				toControllerid.add(new Integer(Integer.valueOf(Main.toController)));
			}
		}
		
		if(i.fromController>0){
			name="Input"+(Main.fromController+1);
			for(int j=0;j<i.fromController;j++){
				Main.fromController++;
				fromControllerid.add(new Integer(Main.fromController));
			}
			
			config=new Configuration();
		}
		
	}
	
	public ItemOnMap(Item i, String itemName, String groupName,int groupId) {
		refId = i.id;
		
		if(i.toController>0){
			Main.to_pc_list.add(this);
			for(int j=0;j<i.toController;j++){
				Main.toController++;
				toControllerid.add(new Integer(Integer.valueOf(Main.toController)));
			}
		}
		
		if(i.fromController>0){
			for(int j=0;j<i.fromController;j++){
				Main.fromController++;
				fromControllerid.add(new Integer(Main.fromController));
			}
			
			config=new Configuration();
		}
		name = groupName+groupId+"."+itemName;
	}

	public ItemOnMap clone(){
		ItemOnMap i = new ItemOnMap();
		i.refId=refId;
		
		i.fromControllerid = new LinkedList<Integer>();
		for(int j=0;j<fromControllerid.size();j++){
			i.fromControllerid.add(fromControllerid.get(j));
		}
		
		i.name=name;
		i.config = new Configuration(config);
		
		if(toControllerid.size()>0){
			i.toControllerid = new LinkedList<Integer>();
			for(int j=0;j<toControllerid.size();j++){
				i.toControllerid.add(toControllerid.get(j));
			}
			
			Main.to_pc_list.set(Main.to_pc_list.indexOf(this), i);
		}
		return i;
	}
	
	public static boolean toNext(Point from, Point to){
		if(Main.grille[from.x][from.y]!=null && Main.grille[to.x][to.y]!=null){
			Connection c =new Connection(from,to);
			if(!Connection.isOnList(c)){
				Main.connection_list.add(c);
				System.out.println("Connection added");
				Main.disp.repaintGrid();
				return true;
			}
		}
		return false;
		
	}
	
	public void addConfig(int id,boolean state){
		BooleanEquation be = new BooleanEquation(id, state);
		for(int i=0;i<config.equation_list.size();i++){
			if(config.equation_list.get(i).id==id){
				config.equation_list.remove(i);
			}
		}
		config.addBool(be);
	}
	
	public static void deleteItem(int x,int y){
		ItemOnMap i = Main.grille[x][y];
		if(i.toControllerid.size()>0){
			int controllerId = i.toControllerid.get(0);
		

			int index = Main.to_pc_list.indexOf(i);
			for(int k=0;k<Main.grilleX;k++){
				for(int j=0;j<Main.grilleY;j++){
					
					if(Main.grille[k][j]!= null){
						/*
						 * ControllerId part
						 */
						if(Main.grille[k][j].toControllerid!=null && Main.grille[k][j].toControllerid.size()>0 && Main.grille[k][j].toControllerid.get(0)>controllerId){
							Main.grille[k][j].toControllerid.set(0, Main.grille[k][j].toControllerid.get(0)-1);
						}
						
						
						/*
						 * CONFIG PART
						 */
						if(Main.grille[k][j].config!=null){
							Configuration c = Main.grille[k][j].config;
							for(int l=0;l<c.equation_list.size();l++){
								if(c.equation_list.get(l).id==index){
									c.equation_list.remove(l);
									l--;
								}
							}
						}
					}
				}
			}
			
			Main.to_pc_list.remove(i);
			Main.toController--;
		}
		
		
		if(i.fromControllerid.size()>0){
			int controllerId = i.fromControllerid.get(0);
			
			for(int k=0;k<Main.grilleX;k++){
				for(int j=0;j<Main.grilleY;j++){
					
					if(Main.grille[k][j]!= null){
						/*
						 * ControllerId part
						 */
						if(Main.grille[k][j].fromControllerid!= null && Main.grille[k][j].fromControllerid.size()>0 && Main.grille[k][j].fromControllerid.get(0)>controllerId){
							Main.grille[k][j].fromControllerid.set(0, Main.grille[k][j].fromControllerid.get(0)-1);
						}
					}
		
				}
			}
			Main.fromController--;
		}
		
		Main.grille[x][y]=null;
		
	}
}
