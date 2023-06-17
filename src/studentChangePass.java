import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class studentChangePass extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Create the panel.
	 */
	public studentChangePass() {
		setBounds(0, 0, 1005, 480);
        setLayout(null);		
        
        JLabel entIDlbl = new JLabel("TUP ID");
        entIDlbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        entIDlbl.setBounds(407, 141, 49, 21);
        add(entIDlbl);
        
        JLabel CurrentPasswordlbl = new JLabel("Current Password");
        CurrentPasswordlbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        CurrentPasswordlbl.setBounds(336, 188, 132, 21);
        add(CurrentPasswordlbl);
        
        JLabel NewPasswordlbl = new JLabel("New Password");
        NewPasswordlbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        NewPasswordlbl.setBounds(356, 232, 98, 21);
        add(NewPasswordlbl);
        
        JLabel ReenterPasswordlbl = new JLabel("Re-enter Password");
        ReenterPasswordlbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        ReenterPasswordlbl.setBounds(325, 268, 132, 21);
        add(ReenterPasswordlbl);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(476, 138, 191, 26);
        add(textField);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(476, 188, 191, 26);
        add(passwordField);
        
        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(476, 232, 191, 26);
        add(passwordField_1);
        
        passwordField_2 = new JPasswordField();
        passwordField_2.setBounds(476, 268, 191, 26);
        add(passwordField_2);
        
        JButton updatebtn = new JButton("Change Password");
        updatebtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        updatebtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        updatebtn.setBounds(418, 364, 181, 34);
        add(updatebtn);

        
	}
}
