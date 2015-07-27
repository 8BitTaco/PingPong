package Pong;

/**
 *
 * @author 8Bit
 */
import javax.swing.*;

public class Pong extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static int WINDOW_WIDTH = 500;
    final static int WINDOW_HEIGHT = 375;

    public Pong() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new GamePanel());
        setVisible(true);
        
    }

    public static void main(String[] args) {
    new Pong();
   }
}
