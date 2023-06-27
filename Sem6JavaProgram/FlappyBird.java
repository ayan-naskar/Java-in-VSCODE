import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
	
	private Timer timer;
	private int width, height;
	private int x, y, velocity;
	private BufferedImage image;
	private boolean gameOver;
	
	public FlappyBird(int width, int height) {
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.WHITE);
		addKeyListener(this);
		setFocusable(true);
		
		try {
			image = ImageIO.read(new File("bird.png"));
		} catch (IOException e) {
			System.out.println("Error loading image: " + e);
		}
		
		timer = new Timer(50, this);
		timer.start();
		
		x = 100;
		y = height / 2;
		velocity = 0;
		gameOver = false;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Draw the bird
		g.drawImage(image, x, y, null);
		
		// Draw the score
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Score: 0", 10, 25);
		
		// Draw game over message if the game is over
		if (gameOver) {
			g.setColor(Color.RED);
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Game Over!", width/2-100, height/2);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		// Move the bird
		velocity += 2;
		y += velocity;
		
		// Check for collision with top or bottom of screen
		if (y < 0 || y > height - image.getHeight()) {
			gameOver = true;
			timer.stop();
		}
		
		repaint();
	}
	
	public void keyPressed(KeyEvent e) {
		// Jump the bird when spacebar is pressed
		if (e.getKeyCode() == KeyEvent.VK_SPACE && !gameOver) {
			velocity = -20;
		}
	}
	
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Flappy Bird");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().add(new FlappyBird(400, 600));
		frame.pack();
		frame.setVisible(true);
	}
}
