
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
	boolean[][] coll1;
	boolean[][] coll2;
	
	public RobotComponent(){
		coll1 = new boolean[480][640];

		for (int i = 0; i < coll1[0].length; i++) {
			for (int j = 284; j < coll1.length; j++) {
				coll1[j][i] = true;
			}
		}
		
		coll2 = new boolean[480][640];

		for (int i = 0; i < 163; i++) {
			for (int j = 284; j < coll2.length; j++) {
				coll2[j][i] = true;
			}
		}
		
		for (int i = 255; i < 493; i++) {
			for (int j = 328; j < coll2.length; j++) {
				coll2[j][i] = true;
			}
		}
		
		for (int i = 544; i < coll2[0].length; i++) {
			for (int j = 222; j < coll2.length; j++) {
				coll2[j][i] = true;
			}
		}
	}
	
	public void paintComponent(Graphics g){
		g2 = (Graphics2D)g; 
		david.draw(g2);
	}
	
	public void move(int x, int y) {
		
		System.out.println("Move");
		if (x > 0 && david.getXPos() < 640 && coll2[(int)david.getYPos()][(int)david.getXPos() + 3] == false) {
			david.moveRight();
			david.draw(g2);
		} else if (x < 0 && david.getXPos() > 0 && coll2[(int)david.getYPos()][(int)david.getXPos() - 3] == false) {
			david.moveLeft();
			david.draw(g2);
		}
		else if(y > 0){
			david.jump((double)y);
			david.draw(g2);
			
			System.out.println("redrawn");
		}
		else if (y < 0 && david.getYPos() < 480 && coll2[(int)david.getYPos() + 30][(int)david.getXPos()] == false) {
			david.fall();
			david.draw(g2);
		}
		
		if (david.getXPos() > 640) {
			//change picture;
		}
	}
}


