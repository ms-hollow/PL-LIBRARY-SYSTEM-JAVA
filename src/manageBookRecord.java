import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class manageBookRecord extends JFrame {

	private JPanel contentPane;
	private JTextField titleField;
	private JTextField authorField;
	private JTextField editionField;
	private JTextField ISBNField;
	private JTextField textField_4;
	private JTextField genreField;
	private JTextField shelfField;
	private JTextField totalstckField;
	private JTextField currstckField;
	private JTextField searchbookField;
	private JTextField materialField;
	private JTextField nobrrwrField;
	private JTextField yearField;
	
	//private static CBook book = new CBook("","","","","","","",0,0,0);    //creates an instance of an object book para matawag mga methods na nasa class Book 
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
	    // Retrieve the book data
	    //book.retrieveBook();

	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                manageBookRecord frame = new manageBookRecord();
	                frame.setVisible(true);
	                frame.setLocationRelativeTo(null);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	   
	/**
	 * Create the frame.
	 */
	public manageBookRecord() {
		
		setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1125, 670);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 248, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        
	}
}
        	
