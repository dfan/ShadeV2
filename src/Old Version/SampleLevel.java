
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
    	//	BufferedImage img1 = null;
    	//	BufferedImage img2 = null;
			try {
			    img1 = ImageIO.read(new File("BrickTile.jpg"));
			    img2 = ImageIO.read(new File("SampleBackground1.jpg"));
			} catch (IOException e) {
			}
	    	
	    	for (int i = 0; i < BLOCKS_IN_ROW; i++) {
	    		for (int j = 0; j < TILE_BORDER; j++) {
	    			g2.drawImage(img2, BLOCK_SIZE*i, BLOCK_SIZE*j, null);
	    			g2.finalize();
	    			repaint();
	    		}
	    	}
	    	
	    	for (int i = 0; i < BLOCKS_IN_ROW; i++) {
	    		for (int j = TILE_BORDER; j < BLOCKS_IN_COLUMN; j++) {
	    			g2.drawImage(img1, BLOCK_SIZE*i, BLOCK_SIZE*j, null);
	    			g2.finalize();
	    			repaint();
	    		}
	    	}
			
			// testing overlapping images
			g2.drawImage(img1, BLOCK_SIZE*36, BLOCK_SIZE*16, null);
	    	g2.drawImage(img1, BLOCK_SIZE*24, BLOCK_SIZE*13, null);
    	
    }
		
}
