import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class manageStudentRecords extends JPanel {

	/**
	 * Create the panel.
	 */
	public manageStudentRecords() {
		setBounds(0, 0, 1005, 480);
		setLayout(null);
		//setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Manage Stud");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(95, 220, 363, 84);
		add(lblNewLabel);
	}

}
