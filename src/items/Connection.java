package items;

import java.awt.Point;

import main.Main;

public class Connection {
	public Point from;
	public Point to;
	
	public Connection(Point from, Point to){
		this.from = from;
		this.to = to;
	}
	
	public Connection(){
		from=null;
		to=null;
	}
	
	public static boolean isSame(Connection c1, Connection c2){
		return (c1.from==c2.from && c1.to==c2.to);
	}
	
	public static boolean isOnList(Connection c){
		for(int i=0;i<Main.connection_list.size();i++){
			if(Connection.isSame(Main.connection_list.get(i),c)){
				return true;
			}
		}
		return false;
	}
}
