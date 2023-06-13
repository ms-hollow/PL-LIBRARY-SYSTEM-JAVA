import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField RegID_Field;
	private JPasswordField RegpassField;
	private JTextField RegcrsNscField;
	private JTextField RegnameField;
	private JPasswordField RegrepassField;
	private JTextField RegemailField;
	private JTextField RegcontactNumField;
	
	private static CBorrower borrower = new CBorrower("","","","","","");  
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//--------MAIN MAGRE-RETRIEVE NG LIST---------------//
		//borrower.retrieveBorrower();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
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
	public RegisterFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1125, 670); //size ng window; X=1125, Y=670 orig size
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel LeftPanel = new JPanel();
		LeftPanel.setLayout(null);
		LeftPanel.setBounds(0, 0, 571, 631);
		contentPane.add(LeftPanel);
		
		JLabel Title_1 = new JLabel("TUP Reads");
		Title_1.setFont(new Font("Segoe UI", Font.BOLD, 34));
		Title_1.setBounds(190, 178, 185, 46);
		LeftPanel.add(Title_1);
		
		JLabel lblWlcm = new JLabel("Fly the world on our shelves");
		lblWlcm.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		lblWlcm.setBounds(159, 232, 226, 26);
		LeftPanel.add(lblWlcm);
		
		JPanel RightPanel = new JPanel();
		RightPanel.setLayout(null);
		RightPanel.setBounds(570, 0, 539, 631);
		contentPane.add(RightPanel);
		
		RegID_Field = new JTextField();
		RegID_Field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		RegID_Field.setColumns(10);
		RegID_Field.setBounds(128, 133, 292, 26);
		RightPanel.add(RegID_Field);
		
		JLabel tupIDLabel = new JLabel("TUP ID");
		tupIDLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		tupIDLabel.setBounds(128, 108, 46, 14);
		RightPanel.add(tupIDLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblPassword.setBounds(128, 289, 83, 14);
		RightPanel.add(lblPassword);
		
		RegpassField = new JPasswordField();
		RegpassField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		RegpassField.setBounds(128, 314, 292, 26);
		RightPanel.add(RegpassField);
		
		RegcrsNscField = new JTextField();
		RegcrsNscField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		RegcrsNscField.setBounds(128, 253, 292, 26);
		RightPanel.add(RegcrsNscField);
		RegcrsNscField.setColumns(10);
		
		JLabel lblcrsNsc = new JLabel("COURSE & SECTION");
		lblcrsNsc.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblcrsNsc.setBounds(128, 230, 130, 14);
		RightPanel.add(lblcrsNsc);
		
		RegnameField = new JTextField();
		RegnameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		RegnameField.setColumns(10);
		RegnameField.setBounds(128, 193, 292, 26);
		RightPanel.add(RegnameField);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblName.setBounds(128, 170, 51, 14);
		RightPanel.add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("(Ex. Juan Dela Cruz)");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(171, 170, 130, 14);
		RightPanel.add(lblNewLabel_1);
		
		JLabel lblReenterPassword = new JLabel("RE-ENTER PASSWORD");
		lblReenterPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblReenterPassword.setBounds(128, 351, 167, 14);
		RightPanel.add(lblReenterPassword);
		
		RegrepassField = new JPasswordField();
		RegrepassField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		RegrepassField.setBounds(128, 376, 292, 26);
		RightPanel.add(RegrepassField);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblEmail.setBounds(128, 475, 51, 14);
		RightPanel.add(lblEmail);
		
		RegemailField = new JTextField();
		RegemailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		RegemailField.setColumns(10);
		RegemailField.setBounds(128, 500, 292, 26);
		RightPanel.add(RegemailField);

		
		JButton btn_Register = new JButton("Register");
		btn_Register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		
				
				String name = RegnameField.getText();
				String TUP_ID = RegID_Field.getText();
				String password = String.valueOf(RegpassField.getPassword());
				String yearSection = RegcrsNscField.getText();
				String contactNum = RegcontactNumField.getText();
				String email = RegemailField.getText();
				
				if (borrower.locateBorrower(TUP_ID) >=0) {
					JOptionPane.showMessageDialog(null, "YOUR TUP ID IS ALREADY REGISTERED!", "Registration", JOptionPane.ERROR_MESSAGE);	//ERROR MESSAGE
					LoginFrame lgn = new LoginFrame(); //punta sa student login frame
					lgn.setVisible(true);
					lgn.setLocationRelativeTo(null);
					setVisible(false);	
		        } 
				
				else if(!borrower.checkBorrowerFields(name, TUP_ID, password, yearSection, contactNum, email)) {	//if may empty fields
		            	JOptionPane.showMessageDialog(null, "PLEASE FILL IN ALL FIELDS", "Registration", JOptionPane.ERROR_MESSAGE);
		        }
				
				else if (!password.equals(String.valueOf(RegrepassField.getPassword()))) {
					JOptionPane.showMessageDialog(null, "PASSWORD DIDN'T MATCH!", "Registration", JOptionPane.ERROR_MESSAGE);	//ERROR MESSAGE
				} 
				
				else if(TUP_ID.length()!=6) {	//if di 6 ang TUP_ID
	            	JOptionPane.showMessageDialog(null, "TUP ID MUST BE 6 DIGITS LONG", "Registration", JOptionPane.ERROR_MESSAGE);
	            }     
				
				else {	
					
					int choice = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO SUBMIT YOUR REGISTRATION?", "Registration", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (choice == JOptionPane.YES_OPTION) {
                       // User clicked Yes
                    	borrower.addBorrower(name, TUP_ID, password, yearSection, contactNum, email);
                    	borrower.saveBorrower();	
                    	JOptionPane.showMessageDialog(null, "YOUR ACCOUNT IS SUCCESSFULLY REGISTERED!", "Registration", JOptionPane.INFORMATION_MESSAGE);
                    	//Login Frame
                    	LoginFrame lgn = new LoginFrame(); //punta sa student login frame
         				lgn.setVisible(true);
         				lgn.setLocationRelativeTo(null);
         				setVisible(false);	
                        
                    } else if (choice == JOptionPane.NO_OPTION) {
                    	LoginFrame lgn = new LoginFrame(); //punta sa student login frame
        				lgn.setVisible(true);
        				lgn.setLocationRelativeTo(null);
        				setVisible(false);	
	                }

				//if(checkRequirements(name, TUP_ID, password, yearSection, contactNum, email)) {					
				}
				
			}
		});
		btn_Register.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_Register.setBounds(215, 553, 111, 35);
		RightPanel.add(btn_Register);
		
		JLabel contactNumlbl = new JLabel("CONTACT NUMBER");
		contactNumlbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		contactNumlbl.setBounds(128, 413, 167, 14);
		RightPanel.add(contactNumlbl);
		
		RegcontactNumField = new JTextField();
		RegcontactNumField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		RegcontactNumField.setColumns(10);
		RegcontactNumField.setBounds(128, 438, 292, 26);
		RightPanel.add(RegcontactNumField);
		}
}
