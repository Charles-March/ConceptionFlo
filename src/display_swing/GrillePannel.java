package display_swing;

import items.Connection;
import items.ItemOnMap;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import main.Main;

public class GrillePannel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6340708146688459670L;
	private Point clickedOnPosition=null;
	private Point clickedLeft = null;
	public GrillePannel(){
		super();
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON3){
					rightClickReleased(e.getPoint());
				}
				else if(e.getButton()==MouseEvent.BUTTON1){
					leftClickReleased(e.getPoint());
				}
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1){
					leftClick(e.getPoint());
				}
				else if(e.getButton()==MouseEvent.BUTTON3){
					rightClick(e.getPoint());
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void leftClick(Point position){	
		int pos_x= position.x/Main.pic_size;
		int pos_y= position.y/Main.pic_size;
		clickedLeft=new Point(pos_x,pos_y);
	}
	
	public void leftClickReleased(Point position){
		int pos_x= position.x/Main.pic_size;
		int pos_y= position.y/Main.pic_size;
		if(pos_x>=0 && pos_y>0 && Main.grille[pos_x][pos_y]==null && Main.selected!=-1 && Main.selected<Main.item_list.size() && pos_x==clickedLeft.x && pos_y==clickedLeft.y){
			Main.grille[pos_x][pos_y]=new ItemOnMap(Main.item_list.get(Main.selected));
			repaint();
		}
		else if(pos_x>=0 && pos_y>0 && (pos_x!=clickedLeft.x || pos_y!=clickedLeft.y)){
			if(Main.grille[clickedLeft.x][clickedLeft.y]!=null && Main.grille[pos_x][pos_y]==null){			
				Main.grille[pos_x][pos_y]= Main.grille[clickedLeft.x][clickedLeft.y].clone();
				Main.grille[clickedLeft.x][clickedLeft.y]=null;
				repaint();
			}
		}
	}
	
	public void rightClick(Point position){
		System.out.println("Right click");
		int pos_x= position.x/Main.pic_size;
		int pos_y= position.y/Main.pic_size;
		
		if(Main.grille[pos_x][pos_y]!=null){
			System.out.println("Position Saved");
			clickedOnPosition=new Point(pos_x,pos_y);
		}
		
	}
	
	public void rightClickReleased(Point position){
		int pos_x= position.x/Main.pic_size;
		int pos_y= position.y/Main.pic_size;
		if(clickedOnPosition!=null && (pos_x!=clickedOnPosition.x || pos_y!=clickedOnPosition.y) && Main.grille[pos_x][pos_y]!=null){
			System.out.println("toNext");
			ItemOnMap.toNext(clickedOnPosition,new Point(pos_x,pos_y));
		}
		else if(clickedOnPosition!= null && pos_x==clickedOnPosition.x && pos_y==clickedOnPosition.y){
			if(Main.grille[pos_x][pos_y].fromControllerid.size()>0){
				new ConfigurationWindow(pos_x,pos_y);
			}
			else if(Main.grille[pos_x][pos_y].toControllerid.size()>0){
				/*
				 * CHANGER LE NOM
				 */
				new ChangeNameDialog(pos_x, pos_y);
			}
			
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		/*
		 *  DISPLAYING MAP
		 */
			System.out.println("Displaying");
			for(int i=0;i<Main.grilleX;i++){
				for(int j=0;j<Main.grilleY;j++){
					ItemOnMap item =Main.grille[i][j];
					int pos_x = i*Main.pic_size;
					int pos_y = j*Main.pic_size;
					if(item!=null){
						g.drawImage(item.getImage(), pos_x, pos_y, Main.pic_size, Main.pic_size, null, null);
						if(Main_swing.display_conectors){
							/*
							 * DISPLAYING CONNECTORS ID
							 */
							g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
							if(item.fromControllerid.size()>1){
								g.setColor(new Color(50,150,50));
								String s = item.fromControllerid.get(0) + ".." + item.fromControllerid.get(item.fromControllerid.size()-1);
								g.drawChars(s.toCharArray(), 0, s.length(), (int) (pos_x), pos_y-5);
							}
							else if(item.fromControllerid.size()==1){
								g.setColor(new Color(50,150,50));
								g.drawChars(Integer.toString(item.fromControllerid.get(0)).toCharArray(), 0, Integer.toString(item.fromControllerid.get(0)).length(), (int) (pos_x+Main.pic_size*0.1), pos_y-5);
							}
							
							if(item.toControllerid.size()>1){
								g.setColor(new Color(150,50,50));
								String s = item.toControllerid.get(0)+ ".." + item.toControllerid.get(item.toControllerid.size()-1);
								g.drawChars(s.toCharArray(), 0, s.length(), (int) (pos_x), pos_y-5);
							}
							else if(item.toControllerid.size()==1){
								g.setColor(new Color(150,50,50));
								g.drawChars(Integer.toString(item.toControllerid.get(0)).toCharArray(), 0, Integer.toString(item.toControllerid.get(0)).length(), (int) (pos_x+Main.pic_size*0.1), pos_y-5);
							}
							g.setColor(new Color(0,0,0));
						}
						
						if(Main_swing.display_names){
							g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
							g.drawChars(item.name.toCharArray(), 0, item.name.length(),(int)( pos_x-(Main.pic_size*0.2)), (int)(pos_y + (Main.pic_size * 1.3)));
						}
					}
					/*
					 * DISPLAYING GRID 
					 */
					if(Main_swing.display_grille){
						g.drawRect(pos_x, pos_y, Main.pic_size, Main.pic_size);
					}
					
					/*
					 *  DISPLAYING NAMES
					 */
					
				}
			}
		
		/*
		 *  DISPLAYING CONNECTIONS
		 */
		for(int i=0;i<Main.connection_list.size();i++){
			Connection c = Main.connection_list.get(i);
			g.drawLine(c.from.x*Main.pic_size + Main.pic_size/2, c.from.y*Main.pic_size + Main.pic_size/2, c.to.x*Main.pic_size + Main.pic_size/2,c.to.y*Main.pic_size + Main.pic_size/2 );
		}
		
		
	}
}
