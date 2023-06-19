import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
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
		
		JPanel RightPanel = new JPanel();
		RightPanel.setLayout(null);
		RightPanel.setBounds(570, 0, 539, 631);
		contentPane.add(RightPanel);
		
		RegID_Field = new JTextField();
		RegID_Field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		RegID_Field.setColumns(10);
		RegID_Field.setBounds(128, 105, 292, 26);
		RightPanel.add(RegID_Field);
		
		JLabel tupIDLabel = new JLabel("TUP ID");
		tupIDLabel.setForeground(new Color(255, 245, 238));
		tupIDLabel.setBackground(new Color(255, 245, 238));
		tupIDLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		tupIDLabel.setBounds(128, 80, 46, 14);
		RightPanel.add(tupIDLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(new Color(255, 245, 238));
		lblPassword.setBackground(new Color(255, 245, 238));
		lblPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblPassword.setBounds(128, 261, 83, 14);
		RightPanel.add(lblPassword);
		
		RegpassField = new JPasswordField();
		RegpassField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		RegpassField.setBounds(128, 286, 292, 26);
		RightPanel.add(RegpassField);
		
		RegcrsNscField = new JTextField();
		RegcrsNscField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		RegcrsNscField.setBounds(128, 225, 292, 26);
		RightPanel.add(RegcrsNscField);
		RegcrsNscField.setColumns(10);
		
		JLabel lblcrsNsc = new JLabel("COURSE & SECTION");
		lblcrsNsc.setForeground(new Color(255, 245, 238));
		lblcrsNsc.setBackground(new Color(255, 245, 238));
		lblcrsNsc.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblcrsNsc.setBounds(128, 202, 130, 14);
		RightPanel.add(lblcrsNsc);
		
		RegnameField = new JTextField();
		RegnameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		RegnameField.setColumns(10);
		RegnameField.setBounds(128, 165, 292, 26);
		RightPanel.add(RegnameField);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(new Color(255, 245, 238));
		lblName.setBackground(new Color(255, 245, 238));
		lblName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblName.setBounds(128, 142, 51, 14);
		RightPanel.add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("(Ex. Juan Dela Cruz)");
		lblNewLabel_1.setBackground(new Color(255, 245, 238));
		lblNewLabel_1.setForeground(new Color(224, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(176, 142, 130, 14);
		RightPanel.add(lblNewLabel_1);
		
		JLabel lblReenterPassword = new JLabel("RE-ENTER PASSWORD");
		lblReenterPassword.setForeground(new Color(255, 245, 238));
		lblReenterPassword.setBackground(new Color(255, 245, 238));
		lblReenterPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblReenterPassword.setBounds(128, 323, 167, 14);
		RightPanel.add(lblReenterPassword);
		
		RegrepassField = new JPasswordField();
		RegrepassField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		RegrepassField.setBounds(128, 348, 292, 26);
		RightPanel.add(RegrepassField);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(new Color(255, 245, 238));
		lblEmail.setBackground(new Color(255, 245, 238));
		lblEmail.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblEmail.setBounds(128, 447, 51, 14);
		RightPanel.add(lblEmail);
		
		RegemailField = new JTextField();
		RegemailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		RegemailField.setColumns(10);
		RegemailField.setBounds(128, 472, 292, 26);
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
		btn_Register.setBounds(215, 525, 111, 35);
		RightPanel.add(btn_Register);
		
		JLabel contactNumlbl = new JLabel("CONTACT NUMBER");
		contactNumlbl.setForeground(new Color(255, 245, 238));
		contactNumlbl.setBackground(new Color(255, 245, 238));
		contactNumlbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		contactNumlbl.setBounds(128, 385, 167, 14);
		RightPanel.add(contactNumlbl);
		
		RegcontactNumField = new JTextField();
		RegcontactNumField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		RegcontactNumField.setColumns(10);
		RegcontactNumField.setBounds(128, 410, 292, 26);
		RightPanel.add(RegcontactNumField);
		
		JLabel exampleID = new JLabel("(Ex. 201890)");
		exampleID.setForeground(new Color(224, 255, 255));
		exampleID.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		exampleID.setBackground(new Color(255, 245, 238));
		exampleID.setBounds(176, 80, 130, 14);
		RightPanel.add(exampleID);
		
		JLabel exampleCourse = new JLabel("(Ex. BSCSNS2AB)");
		exampleCourse.setForeground(new Color(224, 255, 255));
		exampleCourse.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		exampleCourse.setBackground(new Color(255, 245, 238));
		exampleCourse.setBounds(263, 202, 130, 14);
		RightPanel.add(exampleCourse);
		
		JLabel exampleContact = new JLabel("(Ex. 0912345678)");
		exampleContact.setForeground(new Color(224, 255, 255));
		exampleContact.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		exampleContact.setBackground(new Color(255, 245, 238));
		exampleContact.setBounds(263, 385, 130, 14);
		RightPanel.add(exampleContact);
		
		JLabel exampleEmail = new JLabel("(Ex. sample@tup.edu.ph)");
		exampleEmail.setForeground(new Color(224, 255, 255));
		exampleEmail.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		exampleEmail.setBackground(new Color(255, 245, 238));
		exampleEmail.setBounds(176, 447, 172, 14);
		RightPanel.add(exampleEmail);
		
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
		LOG_IN_PAGER.setBounds(0, 0, 1110, 631);
		LOG_IN_PAGER.setIconTextGap(0);
		LOG_IN_PAGER.setIcon(logInBGR);
		RightPanel.add(LOG_IN_PAGER);	
		
		}
}
