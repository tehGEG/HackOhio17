import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	
private Thread thread;
	
	private boolean running;
	
	private int FPS = 60;
	
	private long targetTime = 1000 / FPS;
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(game.WIDTH, game.HEIGHT));
		setFocusable(true);
		requestFocus();
	}
	private static final long serialVersionUID = 1L;

	final static int platWidth = 200;
	final static int platLength = 20;
	
	final static int plat1_InitX = 0;
	final static int plat1_InitY = 0;
	
	final static int plat2_InitX = 256;
	final static int plat2_InitY = 144;
	
	final static int plat3_InitX = 2*plat2_InitX;
	final static int plat3_InitY = 2*plat2_InitY;
	
	final static int plat4_InitX = 3*plat2_InitX;
	final static int plat4_InitY = 3*plat2_InitY;
	
	final static int plat5_InitX = 4*plat2_InitX;
	final static int plat5_InitY = 4*plat2_InitY;
		
	final static int plat6_InitX = 5*plat2_InitX;
	final static int plat6_InitY = 5*plat2_InitY;
	
	final static int plat7_InitX = 6*plat2_InitX;
	final static int plat7_InitY = 6*plat2_InitY;
		
	private Platform plat1;
	private Platform plat2;
	private Platform plat3;
	private Platform plat4;
	private Platform plat5;
	private Platform plat6;
	private Platform plat7;

	
	public void addNotify() {
		super.addNotify();
		if (thread == null) {
		thread = new Thread(this);
		thread.start();
		}
		running = true;
	}
	
	
	
	public void init() {
		plat1 = new Platform(plat1_InitX, plat1_InitY, game.WIDTH, game.HEIGHT);
		plat2 = new Platform(plat2_InitX, plat2_InitY, game.WIDTH, game.HEIGHT);
		plat3 = new Platform(plat3_InitX, plat3_InitY, game.WIDTH, game.HEIGHT);
		plat4 = new Platform(plat4_InitX, plat4_InitY, game.WIDTH, game.HEIGHT);
		plat5 = new Platform(plat5_InitX, plat5_InitY, game.WIDTH, game.HEIGHT);
		plat6 = new Platform(plat6_InitX, plat6_InitY, game.WIDTH, game.HEIGHT);
		plat7 = new Platform(plat7_InitX, plat7_InitY, game.WIDTH, game.HEIGHT);
		Vector2D displacement = new Vector2D(-16, -9);
		plat1.setDisplacement(displacement);
		plat2.setDisplacement(displacement);
		plat3.setDisplacement(displacement);
		plat4.setDisplacement(displacement);
		plat5.setDisplacement(displacement);
		plat6.setDisplacement(displacement);
		plat7.setDisplacement(displacement);
	}


	
	@Override
	public void run() {
		init();
		long start;
		long elapsed;
		long wait;
		while (running) {
			start = System.nanoTime();
			update();
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			if (wait < 0 ) wait = 5;
			try {
				Thread.sleep(wait);
				} catch (Exception e) {
					e.printStackTrace();
				}
				repaint();
		}
	}	
	/*
	 * Updates the position of the platforms
	 */
	public void update() {
		plat1.updatePos();
		plat2.updatePos();
		plat3.updatePos();
		plat4.updatePos();
		plat5.updatePos();
		plat6.updatePos();
		plat7.updatePos();
	}



	/*
	 * Updates game objects.
	 */
	public void paintComponent(Graphics2D g) {
			super.paintComponent(g);
			if (plat1 != null) {
				plat1.draw((Graphics2D) g);
			}
			if (plat2 != null) {
				plat2.draw((Graphics2D) g);
			}
			if (plat3 != null) {
				plat3.draw((Graphics2D) g);
			}
			if (plat4 != null) {
				plat4.draw((Graphics2D) g);
			}
			if (plat5 != null) {
				plat5.draw((Graphics2D) g);
			}
			if (plat6 != null) {
				plat6.draw((Graphics2D) g);
			}
			if (plat7 != null) {
				plat7.draw((Graphics2D) g);
			}
	}
	

}

