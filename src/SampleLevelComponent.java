
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Graphics;

public class SampleLevelComponent extends JComponent{
	SampleLevel level;
	public void paintComponent(Graphics g){
	Graphics2D g2 = (Graphics2D)g;
	level = new SampleLevel();
	level.draw(g2);
//	Robot david = new Robot();
//	david.draw(g);
	}
}


