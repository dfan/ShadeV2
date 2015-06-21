
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
	
	public class SampleLevel extends JComponent /*implements Environment*/ {
		// variables to determine size of blocks being used
		private final int BLOCKS_IN_ROW = 40;
		private final int BLOCKS_IN_COLUMN = 30;
		private final int BLOCK_SIZE = 16;
		// the y-value when the black meet the tiles 
		private final int TILE_BORDER = 21;
		
		BufferedImage img1;
		BufferedImage img2;
		
	    public SampleLevel() {  
	    	
    	}
    	
    	public void draw(Graphics g) {  	
    		Graphics2D g2 = (Graphics2D) g;
    		
    		String levelCounter = "level2";
    		
			try {
			    img1 = ImageIO.read(new File(levelCounter + ".jpg"));
			} catch (IOException e) {
			}
	    	
	    	g2.drawImage(img1, 0, 0, null);
    	
    }
		
}
