
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
    final private double gravity = -3.0;
    private int time;
    private double time2; // experimenting with precision
    private final int BLOCK_SIZE = 16;
    BufferedImage robot;
    double yPosinitial;
    
	public Robot(){
		xPos = BLOCK_SIZE*5; // variables for sample level
    	yPos = BLOCK_SIZE*21 - 28;
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
    
    	
    	if((time-1.0)<0.01){ //can't directly do double == double because of floating point precision
    		yPosinitial = yPos;
    		System.out.println("yPosinitial = " + yPosinitial);
    	}
    	double yacurrent = ya;
    	//time=1;
    	time2=time;
	    //yPos=-6*(double)time2+0.5*(double)time2*(double)time2+yPosinitial;
	    yPos=-24*time2+1.5*time2*time2+yPosinitial;
	    System.out.println("yPos1=" + yPos);
	}
    public double getXPos(){
    	return xPos;
    }	
    public double getYPos(){
    	return yPos;
    }
}

