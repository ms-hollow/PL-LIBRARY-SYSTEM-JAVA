import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.JLayeredPane;

public class Admin_MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField borrowingSearchField;
	private JTextField borrowerSearchField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_MainFrame frame = new Admin_MainFrame();
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
	public Admin_MainFrame() {
		//setUndecorated(true); //para maging windowless
		setResizable(false); //prevent frame from being resize
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 800, 550);//temporary size
		setBounds(100, 100, 1125, 670); //size ng window; X=1125, Y=670 orig size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		
		
		ImageIcon logOutIcon = new ImageIcon(this.getClass().getResource("/assets/logout.png")); // load the image to a imageIcon
		Image logOut = logOutIcon.getImage(); // transform it 
		Image newlogOut = logOut.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		logOutIcon = new ImageIcon(newlogOut);
		getContentPane().setLayout(null);
		
		JLabel logoutImg = new JLabel();
		logoutImg.setBounds(984, 554, 35, 44);
		logoutImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//logout or exit
				LoginFrame login = new LoginFrame();
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		logoutImg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getContentPane().add(logoutImg);
		logoutImg.setIconTextGap(0);
		logoutImg.setIcon(logOutIcon);
		
		ImageIcon searchIcon = new ImageIcon(this.getClass().getResource("/assets/scan.png")); // load the image to a imageIcon
		Image search = searchIcon.getImage(); // transform it 
		Image newSearch = search.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		searchIcon = new ImageIcon(newSearch);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(79, 84, 940, 459);
		contentPane.add(tabbedPane);
		
		//---------------------DISPLAY BOOK PANEL-------------------------------//
		
		JPanel DisplayPanel = new JPanel();
		DisplayPanel.setBackground(new Color(255, 255, 255));
		DisplayPanel.setForeground(new Color(0, 0, 0));
		DisplayPanel.setBorder(null);
		tabbedPane.addTab("Display Books", null, DisplayPanel, null);
		tabbedPane.setDisabledIconAt(0, null);
		DisplayPanel.setLayout(null);
		
		JScrollPane DisplayscrollPane = new JScrollPane();
		DisplayscrollPane.setBounds(27, 32, 883, 372);
		DisplayPanel.add(DisplayscrollPane);
		
		//---------------------MANAGE BOOK PANEL-------------------------------//
		
		JPanel manageBookPanel = new JPanel();
		manageBookPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Manage Book Records", null, manageBookPanel, null);
		manageBookPanel.setLayout(null);
		
		JScrollPane manageBookscrollPane = new JScrollPane();
		manageBookscrollPane.setBounds(49, 35, 833, 170);
		manageBookPanel.add(manageBookscrollPane);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//INSERT CODE FOR DELETE BOOK
			}
		});
		deleteBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		deleteBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deleteBtn.setBounds(793, 389, 89, 23);
		manageBookPanel.add(deleteBtn);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//INSERT CODE FOR UPDATE BOOK
			}
		});
		updateBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updateBtn.setBounds(694, 389, 89, 23);
		manageBookPanel.add(updateBtn);
		
		JButton addBtn = new JButton("Add");
		addBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addBtn.setBounds(595, 389, 89, 23);
		manageBookPanel.add(addBtn);
		
		JLabel titlebookReclbl = new JLabel("Title");
		titlebookReclbl.setBounds(210, 235, 46, 14);
		manageBookPanel.add(titlebookReclbl);
		
		JLabel authorbookReclbl = new JLabel("Author");
		authorbookReclbl.setBounds(210, 260, 46, 14);
		manageBookPanel.add(authorbookReclbl);
		
		JLabel yearbookReclbl = new JLabel("Year Published");
		yearbookReclbl.setBounds(210, 285, 70, 14);
		manageBookPanel.add(yearbookReclbl);
		
		JLabel ISBNbookReclbl = new JLabel("ISBN");
		ISBNbookReclbl.setBounds(210, 310, 70, 14);
		manageBookPanel.add(ISBNbookReclbl);
		
		JLabel materialbookReclbl_1 = new JLabel("Material");
		materialbookReclbl_1.setBounds(210, 335, 70, 14);
		manageBookPanel.add(materialbookReclbl_1);
		
		JLabel genrebookReclbl = new JLabel("Genre");
		genrebookReclbl.setBounds(595, 235, 70, 14);
		manageBookPanel.add(genrebookReclbl);
		
		JLabel shelfnobookReclbl = new JLabel("Shelf No.");
		shelfnobookReclbl.setBounds(595, 260, 70, 14);
		manageBookPanel.add(shelfnobookReclbl);
		
		JLabel totalstockbookReclbl = new JLabel("Total Stock");
		totalstockbookReclbl.setBounds(595, 285, 70, 14);
		manageBookPanel.add(totalstockbookReclbl);
		
		JLabel borrowerbookReclbl = new JLabel("No. Borrower");
		borrowerbookReclbl.setBounds(595, 335, 70, 14);
		manageBookPanel.add(borrowerbookReclbl);
		
		JLabel currentbookReclbl = new JLabel("Current Stock");
		currentbookReclbl.setBounds(595, 310, 70, 14);
		manageBookPanel.add(currentbookReclbl);
		
		
		//---------------------MANAGE BORROWING PANEL-------------------------------//
		
		JPanel manageBorrowingPanel = new JPanel();
		manageBorrowingPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Manage Borrowing Records", null, manageBorrowingPanel, null);
		manageBorrowingPanel.setLayout(null);
		
		JScrollPane manageBorrowingscrollPane = new JScrollPane();
		manageBorrowingscrollPane.setBounds(64, 71, 811, 307);
		manageBorrowingPanel.add(manageBorrowingscrollPane);
			
		borrowingSearchField = new JTextField();
		borrowingSearchField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		borrowingSearchField.setColumns(10);
		borrowingSearchField.setBounds(107, 26, 669, 31);
		manageBorrowingPanel.add(borrowingSearchField);
		
		JLabel searchImg = new JLabel();
		searchImg.setBounds(64, 22, 40, 38);
		manageBorrowingPanel.add(searchImg);
		searchImg.setIconTextGap(0);
		searchImg.setIcon(searchIcon);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		searchBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insert code 
				//lalagay dito code after mag input ni user 
			}
		});
		
		searchBtn.setBounds(793, 26, 82, 31);
		searchBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		manageBorrowingPanel.add(searchBtn);
		
		JButton editBtn = new JButton("Edit");
		editBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//INSET CODE FOR EDIT STATUS BORROWING RECORDS
			}
		});
		editBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		editBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editBtn.setBounds(786, 389, 89, 23);
		manageBorrowingPanel.add(editBtn);
		
		//---------------------MANAGE BORROWER PANEL-------------------------------//
		JPanel manageBorrowerPanel = new JPanel();
		manageBorrowerPanel.setBackground(new Color(255, 255, 255));
		manageBorrowerPanel.setLayout(null);
		tabbedPane.addTab("Manage Borrower Records", null,manageBorrowerPanel, null);
		
		JScrollPane manageBorrowerscrollPane = new JScrollPane();
		manageBorrowerscrollPane.setBounds(64, 71, 811, 307);
		manageBorrowerPanel.add(manageBorrowerscrollPane);
		
		JLabel searchImg_Borrowertab = new JLabel();
		searchImg_Borrowertab.setBounds(64, 22, 40, 38);
		searchImg_Borrowertab.setIconTextGap(0);
		searchImg_Borrowertab.setIcon(searchIcon);
		manageBorrowerPanel.add(searchImg_Borrowertab);
		
		borrowerSearchField = new JTextField();
		borrowerSearchField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		borrowerSearchField.setColumns(10);
		borrowerSearchField.setBounds(107, 26, 669, 31);
		manageBorrowerPanel.add(borrowerSearchField);
		
		JButton searchBtn_1 = new JButton("Search");
		searchBtn_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		searchBtn_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchBtn_1.setBounds(793, 26, 82, 31);
		manageBorrowerPanel.add(searchBtn_1);
		
		JButton borrowerUpdateBtn = new JButton("Update");
		borrowerUpdateBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//INSERT CODE UPDATE BORROWER
			}
		});
		borrowerUpdateBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		borrowerUpdateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		borrowerUpdateBtn.setBounds(786, 389, 89, 23);
		manageBorrowerPanel.add(borrowerUpdateBtn);
		
				
	}
	
}
