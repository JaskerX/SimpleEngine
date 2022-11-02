package de.jaskerx.engine.simple.main;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import de.jaskerx.engine.simple.objects.Stage;

public class Engine {

	private Timer timer;
	private JFrame frame;
	private Thread backgroundThread;
	
	private Stage[] stages;
	private Stage renderedStage;
	
	private BufferedImage img;
    private Graphics2D g2d;
	
    JLabel label;
    int fps = 0;
    
	
	public Engine(int fps) {
		this.fps = fps;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backgroundThread = new Thread();
	}

	
	public void render(int index) {

		timer = new Timer();		
		setRenderedStage(stages[index]);
		img = new BufferedImage(renderedStage.getWidth(), renderedStage.getHeight(), BufferedImage.TYPE_INT_RGB);
		g2d = img.createGraphics();
		g2d.setFont(new Font(null, Font.PLAIN, 30));
		
		g2d.setColor(renderedStage.getColor());
		g2d.fillRect(0, 0, renderedStage.getWidth(), renderedStage.getHeight());
				
		frame.setTitle(renderedStage.getTitle());
		label = new JLabel(new ImageIcon(img));
		frame.getContentPane().add(label);
		frame.pack();
		frame.setVisible(true);
		
		backgroundThread = new Thread(() -> {
			while(renderedStage.getCode() != null) {
				renderedStage.getCode().executeBackground();
			}
		});
		backgroundThread.setName("GameThread-Background");
		backgroundThread.start();
		
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if(!renderedStage.doWait()) {
					g2d.setColor(renderedStage.getColor());
					g2d.fillRect(0, 0, renderedStage.getWidth(), renderedStage.getHeight());
					
					if(renderedStage.getCode() != null) {
						renderedStage.getCode().executeForeground();
					}
					
					label = new JLabel(new ImageIcon(img));
					frame.getContentPane().repaint();
				}
			}
		}, 0, 1000 / fps);
	}
	
	public void stop() {
		backgroundThread.interrupt();
		timer.cancel();
		frame.getContentPane().removeAll();
	}
	

	public Stage[] getStages() {
		return stages;
	}

	public void setStages(Stage... stages) {
		this.stages = stages;
	}

	public Stage getRenderedStage() {
		return renderedStage;
	}

	public void setRenderedStage(Stage renderedStage) {
		this.renderedStage = renderedStage;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public Graphics2D getGraphics() {
		return g2d;
	}
	
}
