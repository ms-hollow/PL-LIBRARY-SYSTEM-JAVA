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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
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
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//--------MAIN MAGRE-RETRIEVE NG LIST---------------//
		borrower.retrieveBorrower();
				
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

	/**
	 * Create the frame.
	 */
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
		LeftPanel.setBounds(0, 0, 571, 631);
		contentPane.add(LeftPanel);
		LeftPanel.setLayout(null);
		
		JLabel Title_1 = new JLabel("TUP Reads");
		Title_1.setFont(new Font("Segoe UI", Font.BOLD, 34));
		Title_1.setBounds(190, 178, 185, 46);
		LeftPanel.add(Title_1);
		
		JLabel lblWlcm = new JLabel("Fly the world on our shelves");
		lblWlcm.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		lblWlcm.setBounds(159, 232, 226, 26);
		LeftPanel.add(lblWlcm);
		
		JPanel RightPanel = new JPanel();
		RightPanel.setBounds(570, 0, 539, 631);
		contentPane.add(RightPanel);
		RightPanel.setLayout(null);
		
		TUPID_Field = new JTextField();
		TUPID_Field.setColumns(10);
		TUPID_Field.setBounds(153, 221, 240, 26);
		RightPanel.add(TUPID_Field);
		
		tupIDLabel = new JLabel("TUP ID");
		tupIDLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		tupIDLabel.setBounds(153, 196, 46, 14);
		RightPanel.add(tupIDLabel);
		
		Passwordlbl = new JLabel("PASSWORD");
		Passwordlbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		Passwordlbl.setBounds(153, 269, 83, 14);
		RightPanel.add(Passwordlbl);
		
		password_Field = new JPasswordField();
		password_Field.setBounds(153, 294, 240, 26);
		RightPanel.add(password_Field);
		
		//////LOGIN//////
		btn_LogIn = new JButton("Log In");
		btn_LogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if (TUPID_Field.getText().equals("ADMIN")){
					
					if (borrower.logInAdmin(TUPID_Field.getText(), String.valueOf(password_Field.getPassword()))) {
						Admin_MainFrame admin = new Admin_MainFrame(); //punta sa student main frame
						admin.setVisible(true);
						admin.setLocationRelativeTo(null);
						setVisible(false);
					}					
				} 
				else {
					if (borrower.loginBorrower(TUPID_Field.getText(), String.valueOf(password_Field.getPassword()))) {
					//JOptionPane.showMessageDialog(null, "Incorrect Username / Password!", "Invalid Credentials", JOptionPane.YES_NO_OPTION);
					//After ng action dadalhin sa student main portal
							
					//int position = borrower.locateBorrower(Log_IDField.getText()); - papasa na value na current account
					Student_MainFrame student = new Student_MainFrame(); //punta sa student main frame
					student.setVisible(true);
					student.setLocationRelativeTo(null);
					setVisible(false);
					}
				}	
			}
		});
		
		btn_LogIn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btn_LogIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_LogIn.setBounds(218, 352, 111, 35);
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
		lbl_register.setForeground(Color.BLUE);
		lbl_register.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_register.setBounds(274, 404, 105, 14);
		RightPanel.add(lbl_register);
		
		lblNotRegistered = new JLabel("Not Registered?");
		lblNotRegistered.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNotRegistered.setBounds(176, 398, 105, 26);
		RightPanel.add(lblNotRegistered);
		
		lblNewLabel = new JLabel("Welcome.");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel.setBounds(153, 133, 185, 31);
		RightPanel.add(lblNewLabel);
		
	}
}
