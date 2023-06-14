import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class manageTransactionRecords extends JPanel {

	/**
	 * Create the panel.
	 */
	public manageTransactionRecords() {
		setBounds(0, 0, 1005, 480);
		setLayout(null);
		//setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Manage Transac");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setBounds(174, 205, 480, 108);
		add(lblNewLabel);
	}

}
