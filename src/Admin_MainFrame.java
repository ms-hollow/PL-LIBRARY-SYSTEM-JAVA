import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.ButtonGroup;
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
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class Admin_MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField borrowingSearchField;
	private JTextField borrowerSearchField;
	private JTextField titleField;
	private JTextField authorField;
	private JTextField yearField;
	private JTextField ISBNField;
	private JTextField materialField;
	private JTextField genreField;
	private JTextField shelfField;
	private JTextField totalstckField;
	private JTextField currstckField;
	private JTextField nobrrwrField;
	private JTextField searchbookField;
	private JTable table;
	
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
		logoutImg.setBounds(1031, 22, 35, 44);
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
		tabbedPane.setBounds(51, 51, 1015, 544);
		contentPane.add(tabbedPane);
		
		//---------------------MANAGE BOOK PANEL-------------------------------//
		
		JPanel manageBookPanel = new JPanel();
		manageBookPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Manage Book Records", null, manageBookPanel, null);
		manageBookPanel.setLayout(null);
		
		JScrollPane manageBookscrollPane = new JScrollPane();
		manageBookscrollPane.setBounds(114, 74, 833, 207);
		manageBookPanel.add(manageBookscrollPane);
		
		//-----------------------------TABLE------------------------------------//
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();//////////////
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//insert code here
			}
		});
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
					///INSERT CODE NG MGA LIST NG BOOK 
				},
				new String[] {
					"TITLE", "EDTN", "AUTHOR", "YEAR", "ISBN", "MATERIAL", "GENRE", "SHELF NO.", "TOTAL STOCK", "NO. BORROWER", "CURRENT STOCK"
				}
			) {
				boolean[] columnEditables = new boolean[] {
	                false, false, false, false
	            };
	            public boolean isCellEditable(int row, int column) {
	                return columnEditables[column];
	            }
			});
		manageBookscrollPane.setViewportView(table);
		
		//----------------------------------------------------------------------//
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(858, 453, 89, 23);
		deleteBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//INSERT CODE FOR DELETE BOOK
			}
		});
		deleteBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		deleteBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		manageBookPanel.add(deleteBtn);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.setBounds(759, 453, 89, 23);
		updateBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//INSERT CODE FOR UPDATE BOOK
			}
		});
		updateBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		manageBookPanel.add(updateBtn);
		
		JButton addBtn = new JButton("Add");
		addBtn.setBounds(660, 453, 89, 23);
		addBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		manageBookPanel.add(addBtn);
		
		JLabel titlebookReclbl = new JLabel("Title");
		titlebookReclbl.setBounds(114, 292, 46, 14);
		titlebookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(titlebookReclbl);
		
		JLabel authorbookReclbl = new JLabel("Author");
		authorbookReclbl.setBounds(114, 325, 46, 14);
		authorbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(authorbookReclbl);
		
		JLabel yearbookReclbl = new JLabel("Year Published");
		yearbookReclbl.setBounds(114, 353, 104, 14);
		yearbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(yearbookReclbl);
		
		JLabel ISBNbookReclbl = new JLabel("ISBN");
		ISBNbookReclbl.setBounds(114, 384, 70, 14);
		ISBNbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(ISBNbookReclbl);
		
		JLabel materialbookReclbl_1 = new JLabel("Material");
		materialbookReclbl_1.setBounds(114, 415, 70, 14);
		materialbookReclbl_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(materialbookReclbl_1);
		
		JLabel genrebookReclbl = new JLabel("Genre");
		genrebookReclbl.setBounds(535, 292, 70, 14);
		genrebookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(genrebookReclbl);
		
		JLabel shelfnobookReclbl = new JLabel("Shelf No.");
		shelfnobookReclbl.setBounds(535, 325, 70, 14);
		shelfnobookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(shelfnobookReclbl);
		
		JLabel totalstockbookReclbl = new JLabel("Total Stock");
		totalstockbookReclbl.setBounds(535, 353, 70, 14);
		totalstockbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(totalstockbookReclbl);
		
		JLabel borrowerbookReclbl = new JLabel("No. Borrower");
		borrowerbookReclbl.setBounds(535, 415, 89, 14);
		borrowerbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(borrowerbookReclbl);
		
		JLabel currentbookReclbl = new JLabel("Current Stock");
		currentbookReclbl.setBounds(535, 384, 89, 14);
		currentbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(currentbookReclbl);
		
		titleField = new JTextField();
		titleField.setBounds(210, 289, 315, 20);
		titleField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(titleField);
		titleField.setColumns(10);
		
		authorField = new JTextField();
		authorField.setBounds(210, 322, 315, 20);
		authorField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		authorField.setColumns(10);
		manageBookPanel.add(authorField);
		
		yearField = new JTextField();
		yearField.setBounds(210, 350, 315, 20);
		yearField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		yearField.setColumns(10);
		manageBookPanel.add(yearField);
		
		ISBNField = new JTextField();
		ISBNField.setBounds(210, 381, 315, 20);
		ISBNField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		ISBNField.setColumns(10);
		manageBookPanel.add(ISBNField);
		
		materialField = new JTextField();
		materialField.setBounds(210, 412, 315, 20);
		materialField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		materialField.setColumns(10);
		manageBookPanel.add(materialField);
		
		genreField = new JTextField();
		genreField.setBounds(632, 289, 315, 20);
		genreField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		genreField.setColumns(10);
		manageBookPanel.add(genreField);
		
		shelfField = new JTextField();
		shelfField.setBounds(632, 322, 315, 20);
		shelfField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		shelfField.setColumns(10);
		manageBookPanel.add(shelfField);
		
		totalstckField = new JTextField();
		totalstckField.setBounds(632, 350, 315, 20);
		totalstckField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		totalstckField.setColumns(10);
		manageBookPanel.add(totalstckField);
		
		currstckField = new JTextField();
		currstckField.setBounds(632, 381, 315, 20);
		currstckField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		currstckField.setColumns(10);
		manageBookPanel.add(currstckField);
		
		nobrrwrField = new JTextField();
		nobrrwrField.setBounds(632, 412, 315, 20);
		nobrrwrField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		nobrrwrField.setColumns(10);
		manageBookPanel.add(nobrrwrField);
		
		searchbookField = new JTextField();
		searchbookField.setBounds(160, 29, 695, 31);
		searchbookField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		searchbookField.setColumns(10);
		manageBookPanel.add(searchbookField);
		
		JButton searchBtn_2 = new JButton("Search");
		searchBtn_2.setBounds(865, 29, 82, 31);
		searchBtn_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(searchBtn_2);
		
		JLabel bookSrchImg = new JLabel();
		bookSrchImg.setBounds(114, 25, 40, 38);
		bookSrchImg.setIconTextGap(0);
		bookSrchImg.setIcon(searchIcon);
		manageBookPanel.add(bookSrchImg);
		
		//--------------SEACRH BY CATEGORY---------------//
		
		JRadioButton titleBtn = new JRadioButton("Title");
		titleBtn.setBounds(21, 73, 76, 23);
		titleBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		titleBtn.setContentAreaFilled(false);
		manageBookPanel.add(titleBtn);
		
		JRadioButton authorBtn = new JRadioButton("Author");
		authorBtn.setBounds(21, 99, 76, 23);
		authorBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		authorBtn.setContentAreaFilled(false);
		manageBookPanel.add(authorBtn);
		
		JRadioButton yearBtn = new JRadioButton("Year ");
		yearBtn.setBounds(21, 125, 70, 23);
		yearBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		yearBtn.setContentAreaFilled(false);
		manageBookPanel.add(yearBtn);
		
		JRadioButton materialBtn = new JRadioButton("Material");
		materialBtn.setBounds(21, 151, 95, 23);
		materialBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		materialBtn.setContentAreaFilled(false);
		manageBookPanel.add(materialBtn);
		
		JRadioButton genreBtn = new JRadioButton("Genre");
		genreBtn.setBounds(21, 177, 70, 23);
		genreBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		genreBtn.setContentAreaFilled(false);
		manageBookPanel.add(genreBtn);
		
		ButtonGroup choice = new ButtonGroup();
		choice.add(titleBtn);
		choice.add(authorBtn);
		choice.add(yearBtn);
		choice.add(materialBtn);
		choice.add(genreBtn);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.setBounds(561, 453, 89, 23);
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleField.setText("");
				authorField.setText("");
				yearField.setText("");
				ISBNField.setText("");
				materialField.setText("");
				genreField.setText("");
				shelfField.setText("");
				totalstckField.setText("");
				currstckField.setText("");
				nobrrwrField.setText("");
				searchbookField.setText("");
				
				//Insert code para ma clear radio buttons
				
				
			}
		});
		clearBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(clearBtn);
		
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
