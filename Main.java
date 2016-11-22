//library & framework import
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
	private JFrame frame;
	//Launch 2048 
	public static void main(String[] args) {
		//Runnable interface implementation. If not have return value, use this.
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//exception process
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//create main board
	public Main() {
		CreateBoard();
	}
	//start main board
	private void CreateBoard() {
		//Implementation board frame
		frame = new JFrame();
		System.out.println("Set Main Board");
		frame.getContentPane().setBackground(new Color(249, 247, 234));
		frame.getContentPane().setFont(new Font("돋움", Font.BOLD, 11));
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();//screen size parser
		frame.setBounds((screenSize.width-600)/2, (screenSize.height-400)/2, 600, 600);
		frame.getContentPane().setLayout(null);
		//tutorial button
		JButton btnNewButton = new JButton("Tutorial");
		btnNewButton.setFont(new Font("Castellar", Font.BOLD, 15));
		//event listener
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Hello player, this is a 2048 tutorial.\n"
					+ "\n\njust in case you didn't know how to play.\n"
					+ "\n1. Use your arrow keys to move the tiles.\n"
					+ "\n2. If you click right-arrow-key, tiles move to down\n"
					+ "\n3. \n"
					+ "\n4. When two tiles with the same number touch, the merge into one!\n"
					+ "\n"
				);
			}
		});
		btnNewButton.setBounds(50, 400, 200, 150);
		frame.getContentPane().add(btnNewButton);

		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Castellar", Font.BOLD, 15));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("System exit");
				System.exit(0);
			}
		});
		btnExit.setBounds(350, 400, 200, 150);
		btnExit.setBackground(new Color(249, 247, 234));
		
		frame.getContentPane().add(btnExit);
		
		
		JButton btn2048 = new JButton("2048");
		btn2048.setFont(new Font("Castellar", Font.BOLD, 40));
		btn2048.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new Java2048();
				frame.dispose();
			}
		});
		btn2048.setBounds(50, 50, 500, 300);
		frame.getContentPane().add(btn2048);
	}

}
