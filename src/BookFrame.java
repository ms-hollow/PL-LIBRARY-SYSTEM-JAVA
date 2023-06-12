import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BookFrame extends JFrame {

	private JPanel contentPane;
	private JPanel addBookPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookFrame frame = new BookFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookFrame() {
		
		setResizable(false); //prevent frame from being resize
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 800, 550);//temporary size
		setBounds(100, 100, 1125, 670); //size ng window; X=1125, Y=670 orig size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel addBookPanel = new JPanel();
		addBookPanel.setBackground(new Color(250, 250, 210));
		addBookPanel.setBounds(0, 0, 1109, 631);
		contentPane.add(addBookPanel);
		
		JPanel updateBook = new JPanel();
		updateBook.setBounds(0, 0, 1109, 631);
		contentPane.add(updateBook);
		
		JPanel deletePanel = new JPanel();
		deletePanel.setBounds(0, 0, 1109, 631);
		contentPane.add(deletePanel);
	}

}
