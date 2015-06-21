
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RobotComponent extends JComponent{
	//private static Robot david = Robot.createOrGetInstance();
	static Robot david = new Robot();
	Graphics2D g2;
	double time;
	boolean a=true;
	boolean b=false;
	boolean done = false;
	
	public RobotComponent(){
		
	}
	
	public void paintComponent(Graphics g){
		g2 = (Graphics2D)g; 
		david.draw(g2);
	}
	
	public void move(int x, int y) { //time from shadev2 class = y here
		
		System.out.println("Move");
		if (x > 0) {
			david.moveRight();
			david.draw(g2);
		} else if (x < 0) {
			david.moveLeft();
			david.draw(g2);
		}
		else if(y != 0){  //collision block top left corner is at (576, 256). Robot is (13 x 28) // make y range larger
			if(!done){
				if(b==false){
					b=true;
					a=false;
				}
				
				if(a==false && b==true && david.getXPos()<576 || david.getXPos()>(576+16)&& david.getYPos()!=(256)){
					david.jump((double)y);
				}
				
				if(a==false && b==true && (david.getYPos()==308 || david.getXPos()>576 && david.getXPos()<(576+16) && david.getYPos()!=(256))){
					done=true;
					System.out.println(done);
				}
			david.draw(g2);
			System.out.println("redrawn");
			}
			if(done){
				a=true;
				b=false;
				if(y>14){
					done=false;
					System.out.println(done);
				}
			}	
		}
	}
}


