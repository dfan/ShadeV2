
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class Robot extends JComponent{
	private double xPos;
    private double yPos;
    final private double xa = 3.0; //velocity
    final private double ya = 24.0; 
    final private double gravity = -1.0;
    private int time;
    private double time2; // experimenting with precision
    private final int BLOCK_SIZE = 16;
    BufferedImage robot;
    double yPosinitial;
    
	public Robot(){
		xPos = BLOCK_SIZE*5; // variables for sample level
    	yPos = BLOCK_SIZE*18 - 30;
    	try {
			    robot = ImageIO.read(new File("RobotRight.png"));
			} catch (IOException e) {
			}
	}
	
	public void draw(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(robot, (int)xPos, (int)yPos, null);
	}
	
	public void moveRight() {
    	System.out.println("xPos1=" + xPos);		
		xPos += xa;
    	System.out.println("xPos2=" + xPos);
    	try {
			    robot = ImageIO.read(new File("RobotRight.png"));
			} catch (IOException e) {
			}
	}
	
	public void moveLeft() {
    	System.out.println("xPos1=" + xPos);
    	xPos -= xa;
    	System.out.println("xPos2=" + xPos);
    	try {
			    robot = ImageIO.read(new File("RobotLeft.png"));
			} catch (IOException e) {
			}
    } 
    
    public void jump(double time){ //set Timer here with ActionListener (action being a jump)
    	yPos -= 10.0;
	}
	
	public void fall() {
		yPos += 5.0;
	}
    	
    public double getXPos() {
    	return xPos;
    }
    
    public double getYPos() {
    	return yPos;
    }	
}

