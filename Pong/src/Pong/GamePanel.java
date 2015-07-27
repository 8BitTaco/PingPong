package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author 8Bit-Taco
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Player player = new Player();
    Ball ball = new Ball();
    Computer computer = new Computer(this);

    public GamePanel() {
        Timer time = new Timer(50, this);
        time.start();

        this.addKeyListener(this);
        this.setFocusable(true);
        setBackground(Color.BLUE);
        
    }

    private void update() {
        player.update();
        ball.update();
        computer.update();

        ball.checkCollisionWith(player);
        ball.checkCollisionWith(computer);
        ball.hitWall();

    }

    
    public void paintComponent(Graphics g) {
		g.setColor(Color.black);
        g.fillRect(0, 0, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT);

        player.paint(g);
        ball.paint(g);
        computer.paint(g);
        ball.paint1(g);

        g.setColor(Color.cyan);
        g.drawLine(0, 30, Pong.WINDOW_WIDTH, 30);
        g.drawLine(Pong.WINDOW_WIDTH / 2, 30, Pong.WINDOW_WIDTH / 2, Pong.WINDOW_HEIGHT);
        g.setColor(Color.red);



    }

    public Ball getBall() {
        return ball;
    }

    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.setYVelocity(-5);
            if (player.getY() < 30) {
                player.setYVelocity(0);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.setYVelocity(5);
            if (player.getY() + 40 > Pong.WINDOW_HEIGHT - 28) {
                player.setYVelocity(0);
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
            player.setYVelocity(0);

        }
    }

    public void keyTyped(KeyEvent e) {
    }

	public void setColor(Color black) {
		// TODO Auto-generated method stub
		
	}
}
