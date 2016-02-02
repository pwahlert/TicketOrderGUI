import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
/**
 * 
 */

/**
 * @author Paula
 *
 */
public class StatusBarBintner extends JComponent {
	
	/**
	 * 
	 */
	double x = 0;
	Color tempC = Color.black;
	public void paintComponent(Graphics g){
		g.setColor(Color.black);
		g.drawRect(20, 10, 200, 200);
		g.fillRect(20, 10, (int) x, 200);
	}
	public void setNewValues(double tempX){
		x = tempX;
		repaint();
	}
	
} 

