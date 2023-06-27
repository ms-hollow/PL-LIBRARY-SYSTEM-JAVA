import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField TUPID_Field;
	private JLabel tupIDLabel;
	private JLabel Passwordlbl;
	private JPasswordField password_Field;
	private JButton btn_LogIn;
	private JLabel lbl_register;
	private JLabel lblNotRegistered;
	private JLabel lblNewLabel;

	private static CBorrower borrower = new CBorrower("","","","","","");  
	private static CBook book = new CBook("","","","","","","",0,0,0);    //creates an instance of an object book para matawag mga methods na nasa class Book
	private static CTransaction transaction = new CTransaction("","","","","","","","","","");
	

	public static void main(String[] args) {
		
		//--------MAIN MAGRE-RETRIEVE NG LIST---------------//
		borrower.retrieveBorrower();
		book.retrieveBook();
		transaction.retrieveTransaction();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LoginFrame() {
		//setUndecorated(true); //para maging windowless
		setResizable(false); //prevent frame from being resize
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 800, 550);//temporary size
		setBounds(100, 100, 1125, 670); //size ng window; X=1125, Y=670 orig size
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel LeftPanel = new JPanel();
		LeftPanel.setBounds(0, 0, 613, 631);
		contentPane.add(LeftPanel);
		LeftPanel.setLayout(null);
		
		JPanel RightPanel = new JPanel();
		RightPanel.setBounds(570, 0, 539, 631);
		contentPane.add(RightPanel);
		RightPanel.setLayout(null);
		
		JLabel Title_1 = new JLabel("TUP Reads");
		Title_1.setForeground(new Color(255, 245, 238));
		Title_1.setFont(new Font("Segoe UI", Font.BOLD, 40));
		Title_1.setBounds(96, 124, 201, 54);
		RightPanel.add(Title_1);
		
		JLabel lblWlcm = new JLabel("F l y   t h e   w o r l d   o n   o u r   s h e l v e s");
		lblWlcm.setForeground(new Color(255, 245, 238));
		lblWlcm.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		lblWlcm.setBounds(48, 178, 297, 34);
		RightPanel.add(lblWlcm);
		
		TUPID_Field = new JTextField();
		TUPID_Field.setColumns(10);
		TUPID_Field.setBounds(76, 315, 227, 26);
		RightPanel.add(TUPID_Field);
		
		tupIDLabel = new JLabel("TUP ID");
		tupIDLabel.setForeground(new Color(255, 245, 238));
		tupIDLabel.setBackground(new Color(255, 245, 238));
		tupIDLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		tupIDLabel.setBounds(76, 290, 46, 14);
		RightPanel.add(tupIDLabel);
		
		Passwordlbl = new JLabel("PASSWORD");
		Passwordlbl.setForeground(new Color(255, 245, 238));
		Passwordlbl.setBackground(new Color(255, 245, 238));
		Passwordlbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		Passwordlbl.setBounds(76, 363, 83, 14);
		RightPanel.add(Passwordlbl);
		
		password_Field = new JPasswordField();
		password_Field.setBounds(76, 388, 227, 26);
		RightPanel.add(password_Field);
		
		//////LOGIN//////
		btn_LogIn = new JButton("Log In");
		btn_LogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if (TUPID_Field.getText().equals("ADMIN")){
					
					if (borrower.logInAdmin(TUPID_Field.getText(), String.valueOf(password_Field.getPassword()))) {
						Admin_Portal admin = new Admin_Portal(); //punta sa student main frame
						admin.setVisible(true);
						admin.setLocationRelativeTo(null);
						setVisible(false);
					}					
				} 
				else {
					if (borrower.loginBorrower(TUPID_Field.getText(), String.valueOf(password_Field.getPassword()))) {
							
					CTransaction.accountIndex= borrower.locateBorrower(TUPID_Field.getText()); 		//sets the accountIndex ng CTransaction, para makuha ron ang account.
						
					Student_Portal student = new Student_Portal(); //punta sa student main frame
					student.setVisible(true);
					student.setLocationRelativeTo(null);
					setVisible(false);
					}
				}	
			}
		});
		
		btn_LogIn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btn_LogIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_LogIn.setBounds(134, 446, 111, 35);
		RightPanel.add(btn_LogIn);
		
		
		//////REGISTER//////
		lbl_register = new JLabel("Create an account");
		lbl_register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//dadalhin sa register frame
				RegisterFrame regframe = new RegisterFrame();
				regframe.setVisible(true);
				regframe.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		
		lbl_register.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_register.setForeground(new Color(135, 206, 250));
		lbl_register.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_register.setBounds(192, 498, 105, 14);
		RightPanel.add(lbl_register);
		
		lblNotRegistered = new JLabel("Not Registered?");
		lblNotRegistered.setForeground(new Color(255, 245, 238));
		lblNotRegistered.setBackground(new Color(255, 245, 238));
		lblNotRegistered.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNotRegistered.setBounds(94, 492, 105, 26);
		RightPanel.add(lblNotRegistered);
		
		lblNewLabel = new JLabel("Welcome.");
		lblNewLabel.setForeground(new Color(255, 245, 238));
		lblNewLabel.setBackground(new Color(255, 245, 238));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel.setBounds(76, 248, 185, 31);
		RightPanel.add(lblNewLabel);
		
		ImageIcon logInBG = new ImageIcon(this.getClass().getResource("/assets/LOG_IN_BG.jpg")); // load the image to a imageIcon
		Image logIB = logInBG.getImage(); // transform it 
		Image newlogIB = logIB.getScaledInstance(700, 650,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		logInBG = new ImageIcon(newlogIB);
		
		JLabel LOG_IN_PAGE = new JLabel("");
		LOG_IN_PAGE.setBounds(0, 0, 1110, 631);
		LOG_IN_PAGE.setIconTextGap(0);
		LOG_IN_PAGE.setIcon(logInBG);
		LeftPanel.add(LOG_IN_PAGE);
		
		ImageIcon logInBGR = new ImageIcon(this.getClass().getResource("/assets/LOG_IN_BGR.jpg")); // load the image to a imageIcon
		Image logIBR = logInBGR.getImage(); // transform it 
		Image newlogIBR = logIBR.getScaledInstance(700, 650,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		logInBGR = new ImageIcon(newlogIBR);
		
		JLabel LOG_IN_PAGER = new JLabel("");
		LOG_IN_PAGER.setBounds(-83, 0, 1193, 631);
		LOG_IN_PAGER.setIconTextGap(0);
		LOG_IN_PAGER.setIcon(logInBGR);
		RightPanel.add(LOG_IN_PAGER);
		
		
		
	}
}
