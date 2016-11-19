import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Display extends JFrame implements Runnable {

	int f_width = 650;
	int f_height = 400;
	int x, y;
	
	Thread th;
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image img_run = tk.getImage("run.gif");
	
	Image buffImage;
	Graphics buffg;
	
	public Display() {
		init();
		start();
		
		String title = "Cookie Run~~";

		setTitle(title);
		setSize(f_width, f_height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void init() {
		x = 150;
		y = 250;
	}
	
	public void start(){
		th = new Thread(this);
		th.start();
	}
	
	public void run(){
		try{
			while(true){
				repaint();
				Thread.sleep(20);
			}
		}catch(Exception e){}
	}
	
	public void paint(Graphics g){
		buffImage = createImage(f_width,f_height);
		buffg = buffImage.getGraphics();
		
		update(g);
	}
	
	public void update(Graphics g){
		Draw_Char();
		g.drawImage(buffImage, 0, 0, this);
	}
	public void Draw_Char(){
		buffg.clearRect(0, 0, f_width, f_height);
		buffg.drawImage(img_run, x, y, this);
	}
}