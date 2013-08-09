package buildings;
import main.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.Timer;

import units.*;


public class TownHall extends Building{
	//makes workers
	private int gold=0;
	private int goldtic=0;
	//private Timer worktime=new Timer(1000,new createUnit());
	boolean timing=false;
	int count=0;
	int ticcount=5;
	private ArrayList<Worker>workerlist=new ArrayList<Worker>();
	private String name="Town Hall";
//	private Image image;
	public TownHall(int race, int x, int y){
		super(Building.TOWNHALL, 4000, 200, race, 100, 100, 300, Unit.WORKER, x, y);
		image=new ImageIcon("Images/TownHall.gif").getImage();
	}
//	@Override
//	public void draw(Graphics2D g, int x, int y, int w, int h) {
//		g.drawImage(image, x, y, w, h, null);
//	}
//	@Override
//	public void miniDraw(Graphics2D g, int x, int y, int w, int h) {
//		g.setColor(Color.pink);
//		g.fillRect(x,y,w,h);
//	}
	@Override
	public void tic(){
		if(constructed){
			goldtic++;
		}
		if(goldtic>10){
			gold+=5;
			goldtic=0;
		}
		if(timing==true){
			count++;
		}
		if(count>=ticcount){
			Unit u = createandcollectUnit();
			if(u!=null)
				myworld.getUnits().add(u);
		}
	}
	public void makeUnit(){
		if(constructed){
			timing=true;
		}
	}
	public Unit createandcollectUnit(){
		boolean found = false;
		int tempcount = 0;
		Worker a = null;
		while(!found && tempcount++<20) {
			double ran = Math.random();
			if(ran<.25) {
				a=new Worker(getPlayer().race(),0,x()-Worker.WIDTH,(int) (y()-Worker.HEIGHT+Math.random()*(h()+Worker.HEIGHT)));
			} else if(ran<.5) {
				a=new Worker(getPlayer().race(),0,x()+w()+Worker.WIDTH,(int) (y()-Worker.HEIGHT+Math.random()*(h()+Worker.HEIGHT)));
			} else if(ran<.75) {
				a=new Worker(getPlayer().race(),0,(int) (x()-Worker.WIDTH+Math.random()*(w()+Worker.WIDTH)),y()-Worker.HEIGHT);
			} else {
				a=new Worker(getPlayer().race(),0,(int) (x()-Worker.WIDTH+Math.random()*(w()+Worker.WIDTH)),y()+h()+Worker.HEIGHT);
			}
			found = !myworld.doesthiscollide(a, 0, 0);
		}
		if(!found)
			return null;
		if(a==null)
			return null;
		a.setPlayer(getPlayer());
		workerlist.add(a);
		timing=false;
		count=0;
		return a;
	}
	public Unit collectUnit(){
		if(workerlist.size()>0){
			return workerlist.remove(0);
		}
		return null;
	}
	public boolean hasUnits(){
		if(workerlist.size()>0){
			return true;
		}
		return false;
	}
	public int collectResources(){
		int ret=gold;
		gold=0;
		return ret;
	}
	public void drawGUI(Graphics2D g, int x, int y, int w, int h) {
		super.drawbuildGUI(g, x, y, w, h);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.PLAIN, 40));
		g.drawString("TownHall", x+40, y+50);
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.drawString("Worker", x+345, y+100);
	}
	@Override
	public void setDifficulty(int diff) {
		ticcount=(int)(10/diff);
	}
}