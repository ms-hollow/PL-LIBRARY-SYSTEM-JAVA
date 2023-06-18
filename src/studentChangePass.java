import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class studentChangePass extends JPanel {
    private JTextField tupIDField;
    private JPasswordField currPassField;
    private JPasswordField newPassField;
    private JPasswordField rePassField;

    private static CBorrower borrower = new CBorrower("", "", "", "", "", "");
    private String newpass, reenterpass;

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

        tupIDField = new JTextField();
        tupIDField.setColumns(10);
        tupIDField.setBounds(476, 138, 191, 26);
        add(tupIDField);

        currPassField = new JPasswordField();
        currPassField.setBounds(476, 188, 191, 26);
        add(currPassField);

        newPassField = new JPasswordField();
        newPassField.setBounds(476, 232, 191, 26);
        add(newPassField);

        rePassField = new JPasswordField();
        rePassField.setBounds(476, 268, 191, 26);
        add(rePassField);

        JButton updatebtn = new JButton("Change Password");
        updatebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String TUP_ID = tupIDField.getText();
                String password = String.valueOf(currPassField.getPassword());
                String newpass = String.valueOf(newPassField.getPassword());
                String reenterpass = String.valueOf(rePassField.getPassword());
                
                if (borrower.locateBorrower(TUP_ID)<0) { // Modify the condition
                    JOptionPane.showMessageDialog(null, "INCORRECT TUP ID!", "Change Password", JOptionPane.ERROR_MESSAGE);
                } else if (TUP_ID.length() != 6) {
                    JOptionPane.showMessageDialog(null, "TUP ID MUST BE 6 DIGITS LONG", "Registration", JOptionPane.ERROR_MESSAGE);
                } else if (!password.equals(String.valueOf(currPassField.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "PASSWORD DIDN'T MATCH!", "Change Password", JOptionPane.ERROR_MESSAGE);
                } else if (!newpass.equals(String.valueOf(reenterpass))) {
                    JOptionPane.showMessageDialog(null, "NEW PASSWORD ENTERED DOESN'T MATCH THE RE-ENTERED PASSWORD!", "Change Password", JOptionPane.ERROR_MESSAGE);
                } else {
                    int choice = JOptionPane.showConfirmDialog(null, "CONFIRM CHANGES?", "Change Password", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (choice == JOptionPane.YES_OPTION) {
                    	
                    	int index = borrower.locateBorrower(TUP_ID);	//returns index of the seleted book
                    	borrower.borrowerList.get(index).setPassword(newpass);
                        borrower.saveBorrower();
                    	JOptionPane.showMessageDialog(null, "YOUR PASSWORD HAS BEEN SUCCESSFULLY CHANGED!", "Change Password", JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                }
            }
        });
        updatebtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        updatebtn.setBounds(418, 364, 181, 34);
        add(updatebtn);
    }
}
