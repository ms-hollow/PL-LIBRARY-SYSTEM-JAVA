import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.Cursor;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

public class Student_MainFrame extends JFrame {
	private JTable table;
	private JTable DisplayTable;
	private JTable table_1;
	private JTextField SearchField;
	private JPasswordField currPassField;
	private JPasswordField newPassField;
	private JPasswordField rePassField;
	private JTextField tupIDField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_MainFrame frame = new Student_MainFrame();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Student_MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1125, 670);
		
		ImageIcon logOutIcon = new ImageIcon(this.getClass().getResource("/assets/logout.png")); // load the image to a imageIcon
		Image logOut = logOutIcon.getImage(); // transform it 
		Image newlogOut = logOut.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		logOutIcon = new ImageIcon(newlogOut);
		getContentPane().setLayout(null);
		
		ImageIcon searchIcon = new ImageIcon(this.getClass().getResource("/assets/scan.png")); // load the image to a imageIcon
		Image search = searchIcon.getImage(); // transform it 
		Image newSearch = search.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		searchIcon = new ImageIcon(newSearch);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(79, 84, 940, 459);
		getContentPane().add(tabbedPane);
		
		//----------------Display Table----------------------//
		
		JPanel DisplayPanel = new JPanel();
		tabbedPane.addTab("Display", null, DisplayPanel, null);
		DisplayPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 32, 883, 372);
		DisplayPanel.add(scrollPane);
		
		DisplayTable = new JTable();
		//---------TEMPORARY------------------//
		//DisplayTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		/*
		DisplayTable.getColumnModel().getColumn(0).setPreferredWidth(120);
		DisplayTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		DisplayTable.getColumnModel().getColumn(2).setPreferredWidth(50);
		DisplayTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		DisplayTable.getColumnModel().getColumn(4).setPreferredWidth(60);
		DisplayTable.getColumnModel().getColumn(5).setPreferredWidth(120);
		DisplayTable.getColumnModel().getColumn(6).setPreferredWidth(50);
		DisplayTable.getColumnModel().getColumn(7).setPreferredWidth(50);
		DisplayTable.getColumnModel().getColumn(8).setPreferredWidth(50);
		DisplayTable.getColumnModel().getColumn(9).setPreferredWidth(50);
		DisplayTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);*/
		
		DisplayTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//insert code here
			}
		});
		DisplayTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		DisplayTable.setModel(new DefaultTableModel(
				new Object[][] {
					{"Brave New World", "Aldous Huxley", "1931", "1234567891012", "Paperback","Dystopian Fiction", "6", "50", "8", "42",},
					{"Hello", "none", "none", "none", "none","none", "none", "none", "E-Book", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "Newspaper", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "Hardcover", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"eme", "eme", "eme", "eme", "eme","eme", "eme", "eme", "eme", "eme",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
					{"none", "none", "none", "none", "none","none", "none", "none", "none", "none",},
				},
				new String[] {
					"Title", "Author", "Year", "ISBN", "Material", "Category", "Shelf No,", "Stock", "Borrower", "Available",
				}
			) {
				boolean[] columnEditables = new boolean[] {
	                false, false, false, false
	            };
	            public boolean isCellEditable(int row, int column) {
	                return columnEditables[column];
	            }
			});
		
		scrollPane.setViewportView(DisplayTable);
		
		
		//--------------Search and Borrow Panel------------------------------//
		
		JPanel SrchnBrrwpanel = new JPanel();
		tabbedPane.addTab(" Search and Borrow", null, SrchnBrrwpanel, null);
		SrchnBrrwpanel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(124, 73, 771, 307);
		SrchnBrrwpanel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setColumnHeaderView(table_1);
		
		SearchField = new JTextField();
		SearchField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		SearchField.setBounds(174, 28, 629, 31);
		SrchnBrrwpanel.add(SearchField);
		SearchField.setColumns(10);
		
		JButton Searchbtn = new JButton("Search");
		Searchbtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		Searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insert code 
				//lalagay dito code after mag input ni user 
			}
		});
		
		Searchbtn.setBounds(813, 28, 82, 31);
		Searchbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SrchnBrrwpanel.add(Searchbtn);
		
		//Button for borrowing book
		JButton Borrowbtn = new JButton("Borrow Book");

		Borrowbtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		Borrowbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Borrowbtn.setBounds(750, 391, 145, 28);
		SrchnBrrwpanel.add(Borrowbtn);
		
		JLabel searchImg = new JLabel();
		searchImg.setBounds(124, 24, 40, 38);
		SrchnBrrwpanel.add(searchImg);
		searchImg.setIconTextGap(0);
		searchImg.setIcon(searchIcon);
		
		
		//------------Search By Category Buttons---------//////
		JRadioButton titleBtn = new JRadioButton("Title");
		titleBtn.setBounds(21, 73, 76, 23);
		titleBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		titleBtn.setContentAreaFilled(false);
		SrchnBrrwpanel.add(titleBtn);
		
		JRadioButton authorBtn = new JRadioButton("Author");
		authorBtn.setBounds(21, 99, 76, 23);
		authorBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		authorBtn.setContentAreaFilled(false);
		SrchnBrrwpanel.add(authorBtn);
		
		JRadioButton yearBtn = new JRadioButton("Year ");
		yearBtn.setBounds(21, 125, 70, 23);
		yearBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		yearBtn.setContentAreaFilled(false);
		SrchnBrrwpanel.add(yearBtn);
		
		JRadioButton materialBtn = new JRadioButton("Material");
		materialBtn.setBounds(21, 151, 95, 23);
		materialBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		materialBtn.setContentAreaFilled(false);
		SrchnBrrwpanel.add(materialBtn);
		
		JRadioButton genreBtn = new JRadioButton("Genre");
		genreBtn.setBounds(21, 177, 70, 23);
		genreBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		genreBtn.setContentAreaFilled(false);
		SrchnBrrwpanel.add(genreBtn);
		
		ButtonGroup choice = new ButtonGroup();
		choice.add(titleBtn);
		choice.add(authorBtn);
		choice.add(yearBtn);
		choice.add(materialBtn);
		choice.add(genreBtn);
		
		//-------------------PANEL FOR CHANGE PASS--------------------//
		JPanel Chngpsspanel = new JPanel();
		tabbedPane.addTab("Change Password", null, Chngpsspanel, null);
		Chngpsspanel.setLayout(null);
		
		JLabel entIDlbl = new JLabel("TUP ID");
		entIDlbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
		entIDlbl.setBounds(333, 116, 49, 21);
		Chngpsspanel.add(entIDlbl);
		
		JLabel CurrentPasswordlbl = new JLabel("Current Password");
		CurrentPasswordlbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
		CurrentPasswordlbl.setBounds(264, 166, 118, 21);
		Chngpsspanel.add(CurrentPasswordlbl);
		
		JLabel NewPasswordlbl = new JLabel("New Password");
		NewPasswordlbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
		NewPasswordlbl.setBounds(284, 216, 98, 21);
		Chngpsspanel.add(NewPasswordlbl);
		
		JLabel ReenterPasswordlbl = new JLabel("Re-enter Password");
		ReenterPasswordlbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
		ReenterPasswordlbl.setBounds(250, 266, 132, 21);
		Chngpsspanel.add(ReenterPasswordlbl);
		
		tupIDField = new JTextField();
		tupIDField.setBounds(402, 113, 191, 26);
		Chngpsspanel.add(tupIDField);
		tupIDField.setColumns(10);
		
		currPassField = new JPasswordField();
		currPassField.setBounds(402, 163, 191, 26);
		Chngpsspanel.add(currPassField);
		
		newPassField = new JPasswordField();
		newPassField.setBounds(402, 213, 191, 26);
		Chngpsspanel.add(newPassField);
		
		rePassField = new JPasswordField();
		rePassField.setBounds(402, 263, 191, 26);
		Chngpsspanel.add(rePassField);
		
		JButton updatebtn = new JButton("Update");
		updatebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//JOPTIONPANE NA NABAGO SIYA
			}
		});
		
		updatebtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		updatebtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updatebtn.setBounds(360, 338, 132, 34);
		Chngpsspanel.add(updatebtn);
		
		JLabel logoutImg = new JLabel();
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
		
		logoutImg.setBounds(984, 554, 35, 44);
		logoutImg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getContentPane().add(logoutImg);
		logoutImg.setIconTextGap(0);
		logoutImg.setIcon(logOutIcon);
		
		
	}
}
