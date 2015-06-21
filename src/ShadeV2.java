/**
 * @(#)ShadeV2.java
 *
 * ShadeV2 application
 *
 * @author 
 * @version 1.00 2015/6/4
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.OverlayLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShadeV2 extends JPanel{
	
	static boolean jumping;
	
   public static void main(String[] args)
   {
   		
   		JFrame frame = new JFrame("ShadeV2 Game");	  
   		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		JPanel panel = new JPanel(){
		    public boolean isOptimizedDrawingEnabled() {
		        return false;
		    }
		};
   		LayoutManager overlay = new OverlayLayout(panel);
 		panel.setLayout(overlay);
		RobotComponent robotcomp = new RobotComponent();
		panel.add(robotcomp);
		SampleLevelComponent component = new SampleLevelComponent();
		panel.add(component);
		frame.add(panel, BorderLayout.CENTER);
		frame.setSize(640, 480);
		jumping = false;
		
		Timer thing;
		class GravityTimer implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if (jumping == false) {
					robotcomp.move(0, -1);
				}
				frame.repaint();
			}
		}
		ActionListener gravityListener = new GravityTimer();
		thing = new Timer(50, gravityListener);
   	 	thing.start();
   	 	Timer[] timer;
   	  	class TimerListener implements ActionListener
	    {
	    	double time=1.0;
	    	int up = 1;
	    	public void actionPerformed(ActionEvent event)
	       	{
	       		if (time == 8.0)
	       		{
	       			up = -1;
	       		}
	       		time +=  1.0;
				robotcomp.move(0, (int)time);
				frame.repaint();
				if (time == 16.0)
				{
					time = 1.0;
				}
				System.out.println("up " + time);
	        }
	    }
    	ActionListener actionlistener = new TimerListener();
    	timer = new Timer[15];
    	int delay = 50;
    	for (int i = 0; i<15; i++)
    	{
    		timer[i] = new Timer(delay, actionlistener);	
    			delay += 50;
    	}
		
		class KeyPressListener implements KeyListener { //Timer won't work here
			
    		public void keyPressed(KeyEvent event) {
    			
    			System.out.println(event.getKeyCode());
    			if (event.getKeyCode() == 37) {
    				robotcomp.move(-3, 0);
    				frame.repaint();
    			} else if (event.getKeyCode() == 38) {
    				
    				
    				if (!timer[14].isRunning())
    				{
    					
    					robotcomp.move(0, 1);
    					frame.repaint();
    					for (int i = 0; i<15; i++)
    					{
    						timer[i].setRepeats(false);
    						timer[i].start();
    					}
    				}
    				
    				
    				//String keyText = KeyEvent.getKeyText(event.getKeyCode());
    				//ActionEvent actionEvent = new ActionEvent(this,ActionEvent.ACTION_PERFORMED,keyText);
    				//actionlistener.actionPerformed(actionEvent);
    				//frame.repaint();
    				
    				/*
    				try { Thread.sleep(1500); }
        			catch ( Exception e ) { }
        			robotcomp.move(0,2);
    				frame.repaint();
    				try { Thread.sleep(1300); }
        			catch ( Exception e ) { }
        			robotcomp.move(0,3);
    				frame.repaint();
    				try { Thread.sleep(200); }
        			catch ( Exception e ) { }
        			*/
    			} else if (event.getKeyCode() == 39) {
    				robotcomp.move(3, 0);
    				frame.repaint();
    				//frame.getContentPane().repaint();
    				//SwingUtilities.updateComponentTreeUI(frame);
    			} else if (event.getKeyCode() == 40) {
    				robotcomp.move(0, 0);
    				frame.repaint();
    			}
    		}
    		
    		public void keyReleased(KeyEvent event) {
    		}
    		
    		public void keyTyped(KeyEvent event) {
    		}
    	}
    	
    	KeyListener listener = new KeyPressListener();
		frame.addKeyListener(listener); //i think the problem is with the frame having the listener
		
   		frame.setVisible(true);
   		
   		
   }	
}
