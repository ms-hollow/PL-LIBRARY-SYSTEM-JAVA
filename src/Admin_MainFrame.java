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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Admin_MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField titleField;
	private JTextField authorField;
	private JTextField yearField;
	private JTextField ISBNField;
	private JTextField materialField;
	private JTextField genreField;
	private JTextField shelfField;
	private JTextField totalstckField;
	private JTextField currstckField;
	private JTextField searchbookField;
	private JTable table;
	private JTextField titleTransacField;
	private JTextField authorTransacField;
	private JTextField yearTransacField;
	private JTextField ISBNTransacField;
	private JTextField materialTransacField;
	private JTextField genreTransacField;
	private JTextField shelfnTransacField;
	private JTextField totalStckTransacField;
	private JTextField currStckField;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_19;
	private JTextField nobrrwrField;
	
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
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBounds(51, 51, 1015, 544);
		contentPane.add(tabbedPane);
		
		//---------------------MANAGE BOOK PANEL-------------------------------//
		
		JPanel manageBookPanel = new JPanel();
		manageBookPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Manage Book Records", null, manageBookPanel, null);
		manageBookPanel.setLayout(null);
		
		JScrollPane manageBookscrollPane = new JScrollPane();
		manageBookscrollPane.setBounds(103, 74, 859, 207);
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
					"TITLE", "EDTN", "AUTHOR", "YEAR", "ISBN", "MATERIAL", "GENRE", "SHELF NO.", "INVENTORY", "NO. BORROWER", "REMAINING"
				}
			) {
				boolean[] columnEditables = new boolean[] {
	                false, false, false, false
	            };
	            public boolean isCellEditable(int row, int column) {
	                return columnEditables[column];
	            }
			});
		int[] columnWidths = {150, 40, 100, 40, 120, 80, 80, 20, 20, 20, 20}; // Specify the desired widths for each column

		for (int i = 0; i < columnWidths.length; i++) {
		    table.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
		}
		manageBookscrollPane.setViewportView(table);
		
		//----------------------------------------------------------------------//
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setForeground(new Color(255, 255, 255));
		deleteBtn.setBackground(new Color(0, 0, 0));
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
		updateBtn.setForeground(new Color(255, 255, 255));
		updateBtn.setBackground(new Color(0, 0, 0));
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
		addBtn.setForeground(new Color(255, 255, 255));
		addBtn.setBackground(new Color(0, 0, 0));
		addBtn.setBounds(660, 453, 89, 23);
		addBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		manageBookPanel.add(addBtn);
		
		JLabel titlebookReclbl = new JLabel("Title");
		titlebookReclbl.setBounds(113, 295, 46, 14);
		titlebookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(titlebookReclbl);
		
		JLabel authorbookReclbl = new JLabel("Author");
		authorbookReclbl.setBounds(113, 328, 46, 14);
		authorbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(authorbookReclbl);
		
		JLabel yearbookReclbl = new JLabel("Year Published");
		yearbookReclbl.setBounds(113, 356, 104, 14);
		yearbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(yearbookReclbl);
		
		JLabel ISBNbookReclbl = new JLabel("ISBN");
		ISBNbookReclbl.setBounds(113, 387, 70, 14);
		ISBNbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(ISBNbookReclbl);
		
		JLabel materialbookReclbl_1 = new JLabel("Material");
		materialbookReclbl_1.setBounds(113, 418, 70, 14);
		materialbookReclbl_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(materialbookReclbl_1);
		
		JLabel genrebookReclbl = new JLabel("Genre");
		genrebookReclbl.setBounds(534, 295, 70, 14);
		genrebookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(genrebookReclbl);
		
		JLabel shelfnobookReclbl = new JLabel("Shelf No.");
		shelfnobookReclbl.setBounds(534, 328, 70, 14);
		shelfnobookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(shelfnobookReclbl);
		
		JLabel totalstockbookReclbl = new JLabel("Total Stock");
		totalstockbookReclbl.setBounds(534, 356, 70, 14);
		totalstockbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(totalstockbookReclbl);
		
		JLabel borrowerbookReclbl = new JLabel("No. Borrower");
		borrowerbookReclbl.setBounds(534, 418, 89, 14);
		borrowerbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(borrowerbookReclbl);
		
		JLabel currentbookReclbl = new JLabel("Current Stock");
		currentbookReclbl.setBounds(534, 387, 89, 14);
		currentbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(currentbookReclbl);
		
		titleField = new JTextField();
		titleField.setBounds(209, 292, 315, 20);
		titleField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(titleField);
		titleField.setColumns(10);
		
		authorField = new JTextField();
		authorField.setBounds(209, 325, 315, 20);
		authorField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		authorField.setColumns(10);
		manageBookPanel.add(authorField);
		
		yearField = new JTextField();
		yearField.setBounds(209, 353, 315, 20);
		yearField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		yearField.setColumns(10);
		manageBookPanel.add(yearField);
		
		ISBNField = new JTextField();
		ISBNField.setBounds(209, 384, 315, 20);
		ISBNField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		ISBNField.setColumns(10);
		manageBookPanel.add(ISBNField);
		
		materialField = new JTextField();
		materialField.setBounds(209, 415, 315, 20);
		materialField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		materialField.setColumns(10);
		manageBookPanel.add(materialField);
		
		genreField = new JTextField();
		genreField.setBounds(631, 292, 315, 20);
		genreField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		genreField.setColumns(10);
		manageBookPanel.add(genreField);
		
		shelfField = new JTextField();
		shelfField.setBounds(631, 325, 315, 20);
		shelfField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		shelfField.setColumns(10);
		manageBookPanel.add(shelfField);
		
		totalstckField = new JTextField();
		totalstckField.setBounds(631, 353, 315, 20);
		totalstckField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		totalstckField.setColumns(10);
		manageBookPanel.add(totalstckField);
		
		currstckField = new JTextField();
		currstckField.setBounds(631, 384, 315, 20);
		currstckField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		currstckField.setColumns(10);
		manageBookPanel.add(currstckField);
		
		searchbookField = new JTextField();
		searchbookField.setBounds(160, 29, 695, 31);
		searchbookField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		searchbookField.setColumns(10);
		manageBookPanel.add(searchbookField);
		
		JButton searchBtn_2 = new JButton("Search");
		searchBtn_2.setForeground(new Color(255, 255, 255));
		searchBtn_2.setBackground(new Color(0, 0, 0));
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
		titleBtn.setForeground(new Color(0, 0, 0));
		titleBtn.setBounds(21, 73, 76, 23);
		titleBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		titleBtn.setContentAreaFilled(false);
		manageBookPanel.add(titleBtn);
		
		JRadioButton authorBtn = new JRadioButton("Author");
		authorBtn.setForeground(new Color(0, 0, 0));
		authorBtn.setBounds(21, 99, 76, 23);
		authorBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		authorBtn.setContentAreaFilled(false);
		manageBookPanel.add(authorBtn);
		
		JRadioButton yearBtn = new JRadioButton("Year ");
		yearBtn.setForeground(new Color(0, 0, 0));
		yearBtn.setBounds(21, 125, 70, 23);
		yearBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		yearBtn.setContentAreaFilled(false);
		manageBookPanel.add(yearBtn);
		
		JRadioButton materialBtn = new JRadioButton("Material");
		materialBtn.setForeground(new Color(0, 0, 0));
		materialBtn.setBounds(21, 151, 95, 23);
		materialBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		materialBtn.setContentAreaFilled(false);
		manageBookPanel.add(materialBtn);
		
		JRadioButton genreBtn = new JRadioButton("Genre");
		genreBtn.setForeground(new Color(0, 0, 0));
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
		clearBtn.setForeground(new Color(255, 255, 255));
		clearBtn.setBackground(new Color(0, 0, 0));
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
				//nobrrwrField.setText("");
				searchbookField.setText("");
				choice.clearSelection();	
			}
		});
		clearBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		manageBookPanel.add(clearBtn);
		
		nobrrwrField = new JTextField();
		nobrrwrField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		nobrrwrField.setColumns(10);
		nobrrwrField.setBounds(632, 415, 315, 20);
		manageBookPanel.add(nobrrwrField);
		
		JPanel manageTransactionPanel = new JPanel();
		manageTransactionPanel.setLayout(null);
		manageTransactionPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Manage Transaction Records", null, manageTransactionPanel, null);
		
		JScrollPane manageBookscrollPane_1 = new JScrollPane();
		manageBookscrollPane_1.setBounds(103, 74, 859, 207);
		manageTransactionPanel.add(manageBookscrollPane_1);
		
		JButton updateBtn_1 = new JButton("Update");
		updateBtn_1.setForeground(Color.WHITE);
		updateBtn_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		updateBtn_1.setBackground(Color.BLACK);
		updateBtn_1.setBounds(857, 453, 89, 23);
		manageTransactionPanel.add(updateBtn_1);
		
		JLabel titlebookReclbl_1 = new JLabel("Title");
		titlebookReclbl_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		titlebookReclbl_1.setBounds(113, 295, 46, 14);
		manageTransactionPanel.add(titlebookReclbl_1);
		
		JLabel authorbookReclbl_1 = new JLabel("Author");
		authorbookReclbl_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		authorbookReclbl_1.setBounds(113, 328, 46, 14);
		manageTransactionPanel.add(authorbookReclbl_1);
		
		JLabel yearbookReclbl_1 = new JLabel("Year Published");
		yearbookReclbl_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		yearbookReclbl_1.setBounds(113, 356, 104, 14);
		manageTransactionPanel.add(yearbookReclbl_1);
		
		JLabel ISBNbookReclbl_1 = new JLabel("ISBN");
		ISBNbookReclbl_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		ISBNbookReclbl_1.setBounds(113, 387, 70, 14);
		manageTransactionPanel.add(ISBNbookReclbl_1);
		
		JLabel materialbookReclbl_1_1 = new JLabel("Material");
		materialbookReclbl_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		materialbookReclbl_1_1.setBounds(113, 418, 70, 14);
		manageTransactionPanel.add(materialbookReclbl_1_1);
		
		JLabel genrebookReclbl_1 = new JLabel("Genre");
		genrebookReclbl_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		genrebookReclbl_1.setBounds(534, 295, 70, 14);
		manageTransactionPanel.add(genrebookReclbl_1);
		
		JLabel shelfnobookReclbl_1 = new JLabel("Shelf No.");
		shelfnobookReclbl_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		shelfnobookReclbl_1.setBounds(534, 328, 70, 14);
		manageTransactionPanel.add(shelfnobookReclbl_1);
		
		JLabel totalstockbookReclbl_1 = new JLabel("Total Stock");
		totalstockbookReclbl_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		totalstockbookReclbl_1.setBounds(534, 356, 70, 14);
		manageTransactionPanel.add(totalstockbookReclbl_1);
		
		JLabel borrowerbookReclbl_1 = new JLabel("No. Borrower");
		borrowerbookReclbl_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		borrowerbookReclbl_1.setBounds(534, 418, 89, 14);
		manageTransactionPanel.add(borrowerbookReclbl_1);
		
		JLabel currentbookReclbl_1 = new JLabel("Current Stock");
		currentbookReclbl_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		currentbookReclbl_1.setBounds(534, 387, 89, 14);
		manageTransactionPanel.add(currentbookReclbl_1);
		
		titleTransacField = new JTextField();
		titleTransacField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		titleTransacField.setColumns(10);
		titleTransacField.setBounds(209, 292, 315, 20);
		manageTransactionPanel.add(titleTransacField);
		
		authorTransacField = new JTextField();
		authorTransacField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		authorTransacField.setColumns(10);
		authorTransacField.setBounds(209, 325, 315, 20);
		manageTransactionPanel.add(authorTransacField);
		
		yearTransacField = new JTextField();
		yearTransacField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		yearTransacField.setColumns(10);
		yearTransacField.setBounds(209, 353, 315, 20);
		manageTransactionPanel.add(yearTransacField);
		
		ISBNTransacField = new JTextField();
		ISBNTransacField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		ISBNTransacField.setColumns(10);
		ISBNTransacField.setBounds(209, 384, 315, 20);
		manageTransactionPanel.add(ISBNTransacField);
		
		materialTransacField = new JTextField();
		materialTransacField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		materialTransacField.setColumns(10);
		materialTransacField.setBounds(209, 415, 315, 20);
		manageTransactionPanel.add(materialTransacField);
		
		genreTransacField = new JTextField();
		genreTransacField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		genreTransacField.setColumns(10);
		genreTransacField.setBounds(631, 292, 315, 20);
		manageTransactionPanel.add(genreTransacField);
		
		shelfnTransacField = new JTextField();
		shelfnTransacField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		shelfnTransacField.setColumns(10);
		shelfnTransacField.setBounds(631, 325, 315, 20);
		manageTransactionPanel.add(shelfnTransacField);
		
		totalStckTransacField = new JTextField();
		totalStckTransacField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		totalStckTransacField.setColumns(10);
		totalStckTransacField.setBounds(631, 353, 315, 20);
		manageTransactionPanel.add(totalStckTransacField);
		
		currStckField = new JTextField();
		currStckField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		currStckField.setColumns(10);
		currStckField.setBounds(631, 384, 315, 20);
		manageTransactionPanel.add(currStckField);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField_9.setColumns(10);
		textField_9.setBounds(160, 29, 695, 31);
		manageTransactionPanel.add(textField_9);
		
		JButton searchBtn_2_1 = new JButton("Search");
		searchBtn_2_1.setForeground(Color.WHITE);
		searchBtn_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		searchBtn_2_1.setBackground(Color.BLACK);
		searchBtn_2_1.setBounds(865, 29, 82, 31);
		manageTransactionPanel.add(searchBtn_2_1);
		
		JLabel bookSrchImg_1 = new JLabel();
		bookSrchImg_1.setIconTextGap(0);
		bookSrchImg_1.setIcon(searchIcon);
		bookSrchImg_1.setBounds(114, 25, 40, 38);
		manageTransactionPanel.add(bookSrchImg_1);
		
		JRadioButton titleBtn_1 = new JRadioButton("Title");
		titleBtn_1.setForeground(Color.BLACK);
		titleBtn_1.setContentAreaFilled(false);
		titleBtn_1.setBounds(21, 73, 76, 23);
		manageTransactionPanel.add(titleBtn_1);
		
		JRadioButton authorBtn_1 = new JRadioButton("Author");
		authorBtn_1.setForeground(Color.BLACK);
		authorBtn_1.setContentAreaFilled(false);
		authorBtn_1.setBounds(21, 99, 76, 23);
		manageTransactionPanel.add(authorBtn_1);
		
		JRadioButton yearBtn_1 = new JRadioButton("Year ");
		yearBtn_1.setForeground(Color.BLACK);
		yearBtn_1.setContentAreaFilled(false);
		yearBtn_1.setBounds(21, 125, 70, 23);
		manageTransactionPanel.add(yearBtn_1);
		
		JRadioButton materialBtn_1 = new JRadioButton("Material");
		materialBtn_1.setForeground(Color.BLACK);
		materialBtn_1.setContentAreaFilled(false);
		materialBtn_1.setBounds(21, 151, 95, 23);
		manageTransactionPanel.add(materialBtn_1);
		
		JRadioButton genreBtn_1 = new JRadioButton("Genre");
		genreBtn_1.setForeground(Color.BLACK);
		genreBtn_1.setContentAreaFilled(false);
		genreBtn_1.setBounds(21, 177, 70, 23);
		manageTransactionPanel.add(genreBtn_1);
		
		JButton clearBtn_1 = new JButton("Clear");
		clearBtn_1.setForeground(Color.WHITE);
		clearBtn_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		clearBtn_1.setBackground(Color.BLACK);
		clearBtn_1.setBounds(758, 453, 89, 23);
		manageTransactionPanel.add(clearBtn_1);
		
		String status [] = {"TO RETURN", "RETURNED"};
		JComboBox statusCombo = new JComboBox(status);
		statusCombo.setBounds(633, 414, 116, 22);
		manageTransactionPanel.add(statusCombo);
		
		JPanel manageBorrowerPanel = new JPanel();
		manageBorrowerPanel.setLayout(null);
		manageBorrowerPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Manage Student Records", null,  manageBorrowerPanel, null);
		
		JScrollPane manageBookscrollPane_1_1 = new JScrollPane();
		manageBookscrollPane_1_1.setBounds(47, 74, 915, 268);
		manageBorrowerPanel.add(manageBookscrollPane_1_1);
		
		JButton deleteBtn_1_1 = new JButton("Delete");
		deleteBtn_1_1.setForeground(Color.WHITE);
		deleteBtn_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		deleteBtn_1_1.setBackground(Color.BLACK);
		deleteBtn_1_1.setBounds(858, 453, 89, 23);
		manageBorrowerPanel.add(deleteBtn_1_1);
		
		JButton updateBtn_1_1 = new JButton("Update");
		updateBtn_1_1.setForeground(Color.WHITE);
		updateBtn_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		updateBtn_1_1.setBackground(Color.BLACK);
		updateBtn_1_1.setBounds(759, 453, 89, 23);
		manageBorrowerPanel.add(updateBtn_1_1);
		
		JLabel tupIDStudReclbl = new JLabel("TUP ID");
		tupIDStudReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tupIDStudReclbl.setBounds(90, 356, 46, 14);
		manageBorrowerPanel.add(tupIDStudReclbl);
		
		JLabel nameStudReclbl = new JLabel("Name");
		nameStudReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		nameStudReclbl.setBounds(90, 389, 46, 14);
		manageBorrowerPanel.add(nameStudReclbl);
		
		JLabel yrscStudReclbl = new JLabel("Course & Section");
		yrscStudReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		yrscStudReclbl.setBounds(90, 417, 104, 14);
		manageBorrowerPanel.add(yrscStudReclbl);
		
		JLabel contactStudReclbl = new JLabel("Contact No.");
		contactStudReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		contactStudReclbl.setBounds(511, 356, 87, 14);
		manageBorrowerPanel.add(contactStudReclbl);
		
		JLabel emailStudReclbl = new JLabel("Email");
		emailStudReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		emailStudReclbl.setBounds(511, 389, 70, 14);
		manageBorrowerPanel.add(emailStudReclbl);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField_10.setColumns(10);
		textField_10.setBounds(186, 353, 315, 20);
		manageBorrowerPanel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField_11.setColumns(10);
		textField_11.setBounds(186, 386, 315, 20);
		manageBorrowerPanel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField_12.setColumns(10);
		textField_12.setBounds(186, 414, 315, 20);
		manageBorrowerPanel.add(textField_12);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField_15.setColumns(10);
		textField_15.setBounds(608, 353, 315, 20);
		manageBorrowerPanel.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField_16.setColumns(10);
		textField_16.setBounds(608, 386, 315, 20);
		manageBorrowerPanel.add(textField_16);
		
		textField_19 = new JTextField();
		textField_19.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField_19.setColumns(10);
		textField_19.setBounds(136, 29, 695, 31);
		manageBorrowerPanel.add(textField_19);
		
		JButton searchBtn_2_1_1 = new JButton("Search");
		searchBtn_2_1_1.setForeground(Color.WHITE);
		searchBtn_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		searchBtn_2_1_1.setBackground(Color.BLACK);
		searchBtn_2_1_1.setBounds(841, 29, 82, 31);
		manageBorrowerPanel.add(searchBtn_2_1_1);
		
		JLabel bookSrchImg_1_1 = new JLabel();
		bookSrchImg_1_1.setIconTextGap(0);
		bookSrchImg_1_1.setIcon(searchIcon);
		bookSrchImg_1_1.setBounds(90, 25, 40, 38);
		manageBorrowerPanel.add(bookSrchImg_1_1);
		
		JButton clearBtn_1_1 = new JButton("Clear");
		clearBtn_1_1.setForeground(Color.WHITE);
		clearBtn_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		clearBtn_1_1.setBackground(Color.BLACK);
		clearBtn_1_1.setBounds(660, 453, 89, 23);
		manageBorrowerPanel.add(clearBtn_1_1);
		
				
	}
}
