import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class manageTransactionRecords extends JPanel {
	
	private static CBook book = new CBook("","","","","","","",0,0,0);    //creates an instance of an object book para matawag mga methods na nasa class Book 
	
	private JTextField searchbookField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField titleField;
	private JTextField authorField;
	private JTextField editionField;
	private JTextField yearField;
	private JTextField ISBNField;
	private JTextField materialField;
	private JTextField genreField;
	private JTextField shelfField;
	private JTextField totalstckField;
	private JTextField currstckField;

	/**
	 * Create the panel.
	 */
	public manageTransactionRecords() {
		setBounds(0, 0, 1005, 480);
		setLayout(null);
		//setVisible(true);
		 ImageIcon searchIcon = new ImageIcon(this.getClass().getResource("/assets/scan.png")); // load the image to a imageIcon
			Image search = searchIcon.getImage(); // transform it 
			Image newSearch = search.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			searchIcon = new ImageIcon(newSearch);
			
			ImageIcon crossIcon = new ImageIcon(this.getClass().getResource("/assets/cross.png")); // load the image to a imageIcon
			Image cross = crossIcon.getImage(); // transform it 
			Image newCross = cross.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			crossIcon = new ImageIcon(newCross);
					   
			JLabel clearSearch = new JLabel("");
			clearSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					searchbookField.setText("");
				}
			});
			clearSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
		    clearSearch.setBounds(854, 18, 15, 31);
		    clearSearch.setIconTextGap(0);
		    clearSearch.setIcon(crossIcon);
		    add(clearSearch);
		    
	        JScrollPane manageBookscrollPane = new JScrollPane();
	        manageBookscrollPane.setBounds(117, 60, 859, 207);
	        add(manageBookscrollPane);
	        
	 //--------------SEACRH BY CATEGORY---------------//
			
	      	JRadioButton titleBtn = new JRadioButton("Title");
	      	titleBtn.setForeground(new Color(0, 0, 0));
	      	titleBtn.setBounds(21, 73, 76, 23);
	      	titleBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	      	titleBtn.setContentAreaFilled(false);
	      	add(titleBtn);
	      		
	      	JRadioButton authorBtn = new JRadioButton("Author");
	      	authorBtn.setForeground(new Color(0, 0, 0));
	      	authorBtn.setBounds(21, 99, 76, 23);
	      	authorBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	      	authorBtn.setContentAreaFilled(false);
	      	add(authorBtn);
	      		
	      	JRadioButton yearBtn = new JRadioButton("Year ");
	      	yearBtn.setForeground(new Color(0, 0, 0));
	      	yearBtn.setBounds(21, 125, 70, 23);
	      	yearBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	      	yearBtn.setContentAreaFilled(false);
	      	add(yearBtn);
	      		
	      	JRadioButton materialBtn = new JRadioButton("Material");
	      	materialBtn.setForeground(new Color(0, 0, 0));
	      	materialBtn.setBounds(21, 151, 95, 23);
	      	materialBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	      	materialBtn.setContentAreaFilled(false);
	      	add(materialBtn);
	      		
	      	JRadioButton genreBtn = new JRadioButton("Genre");
	      	genreBtn.setForeground(new Color(0, 0, 0));
	      	genreBtn.setBounds(21, 177, 70, 23);
	      	genreBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	      	genreBtn.setContentAreaFilled(false);
	      	add(genreBtn);
	      		
	      	ButtonGroup choice = new ButtonGroup();
	      	choice.add(titleBtn);
	      	choice.add(authorBtn);
	      	choice.add(yearBtn);
	      	choice.add(materialBtn);
	      	choice.add(genreBtn);
	        
			// Create a DefaultTableModel and specify the column names
			DefaultTableModel model = new DefaultTableModel(
					
			    new Object[][] {},
			    new String[] {
			        "Title", "Edition", "Author", "Year", "ISBN", "Material", "Category", "Shelf No.", "Total Stock", "No. Borrower", 
			    }
			) {
			    boolean[] columnEditables = new boolean[] {false, false, false, false, false, false, false, false, false, false, false};

			    public boolean isCellEditable(int row, int column) {
			        return columnEditables[column];
			    }
			};

			// Add data from the bookList to the model
			for (CBook book : book.bookList) {
			    Object[] row = {
			        book.getTitle(), book.getEdition(), book.getAuthor(), book.getYearPublished(), book.getISBN(),
			        book.getMaterial(), book.getCategory(), book.getShelfNo(), book.getTotalStocks(),
			        book.getNoOfBorrower()
			    };
			    model.addRow(row);
			   
			}

			// Create the JTable and set the model
			JTable table = new JTable(model);

			// Specify the desired widths for each column
			int[] columnWidths = {150, 40, 100, 40, 120, 80, 80, 20, 20, 20};

			// Set the preferred column widths
			for (int i = 0; i < columnWidths.length; i++) {
			    table.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
			}
			
			 
			// Add a MouseListener to the table
			table.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			        // Insert your code here
			    	
				}
			});
			
			
			// Set the JTable as the view of the scroll pane
			manageBookscrollPane.setViewportView(table);
			table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        
	        JButton updateBtn = new JButton("Update");
	        updateBtn.setForeground(Color.WHITE);
	        updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        updateBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        updateBtn.setBackground(Color.BLACK);
	        updateBtn.setBounds(872, 439, 89, 23);
	        add(updateBtn);
	        
	        JLabel titlebookReclbl = new JLabel("Title");
	        titlebookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        titlebookReclbl.setBounds(127, 281, 46, 14);
	        add(titlebookReclbl);
	        
	        JLabel authorbookReclbl = new JLabel("Author");
	        authorbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        authorbookReclbl.setBounds(127, 314, 46, 14);
	        add(authorbookReclbl);
	        
	        JLabel yearbookReclbl = new JLabel("Year Published");
	        yearbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        yearbookReclbl.setBounds(322, 342, 104, 14);
	        add(yearbookReclbl);
	        
	        JLabel ISBNbookReclbl = new JLabel("ISBN");
	        ISBNbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        ISBNbookReclbl.setBounds(127, 373, 70, 14);
	        add(ISBNbookReclbl);
	        
	        JLabel materialbookReclbl_1 = new JLabel("Material");
	        materialbookReclbl_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        materialbookReclbl_1.setBounds(127, 404, 70, 14);
	        add(materialbookReclbl_1);
	        
	        JLabel genrebookReclbl = new JLabel("Genre");
	        genrebookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        genrebookReclbl.setBounds(548, 281, 70, 14);
	        add(genrebookReclbl);
	        
	        JLabel shelfnobookReclbl = new JLabel("Shelf No.");
	        shelfnobookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        shelfnobookReclbl.setBounds(548, 314, 70, 14);
	        add(shelfnobookReclbl);
	        
	        JLabel totalstockbookReclbl = new JLabel("Total Stock");
	        totalstockbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        totalstockbookReclbl.setBounds(548, 342, 70, 14);
	        add(totalstockbookReclbl);
	        
	        JLabel borrowerbookReclbl = new JLabel("Status");
	        borrowerbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        borrowerbookReclbl.setBounds(548, 404, 89, 14);
	        add(borrowerbookReclbl);
	        
	        JLabel currentbookReclbl = new JLabel("Current Stock");
	        currentbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        currentbookReclbl.setBounds(548, 373, 89, 14);
	        add(currentbookReclbl);
	        
	        titleField = new JTextField();
	        titleField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        titleField.setColumns(10);
	        titleField.setBounds(223, 278, 315, 20);
	        add(titleField);
	        
	        authorField = new JTextField();
	        authorField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        authorField.setColumns(10);
	        authorField.setBounds(223, 311, 315, 20);
	        add(authorField);
	        
	        yearField = new JTextField();
	        yearField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        yearField.setColumns(10);
	        yearField.setBounds(420, 339, 118, 20);
	        add(yearField);
	        
	        ISBNField = new JTextField();
	        ISBNField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        ISBNField.setColumns(10);
	        ISBNField.setBounds(223, 370, 315, 20);
	        add(ISBNField);
	        
	        materialField = new JTextField();
	        materialField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        materialField.setColumns(10);
	        materialField.setBounds(223, 401, 315, 20);
	        add(materialField);
	        
	        genreField = new JTextField();
	        genreField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        genreField.setColumns(10);
	        genreField.setBounds(645, 278, 315, 20);
	        add(genreField);
	        
	        shelfField = new JTextField();
	        shelfField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        shelfField.setColumns(10);
	        shelfField.setBounds(645, 311, 315, 20);
	        add(shelfField);
	        
	        totalstckField = new JTextField();
	        totalstckField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        totalstckField.setColumns(10);
	        totalstckField.setBounds(645, 339, 315, 20);
	        add(totalstckField);
	        
	        currstckField = new JTextField();
	        currstckField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        currstckField.setColumns(10);
	        currstckField.setBounds(645, 370, 315, 20);
	        add(currstckField);
	        
	        searchbookField = new JTextField();
	        searchbookField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        searchbookField.setColumns(10);
	        searchbookField.setBounds(167, 18, 677, 31);
	        add(searchbookField);
	        
	        ///change to image
	        JButton searchBtn_2 = new JButton("Search");
	        searchBtn_2.setForeground(Color.WHITE);
	        searchBtn_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        searchBtn_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        searchBtn_2.setBackground(Color.BLACK);
	        searchBtn_2.setBounds(879, 18, 82, 31);
	        add(searchBtn_2);
	        
	        JLabel bookSrchImg = new JLabel();
	        bookSrchImg.setIconTextGap(0);
	        bookSrchImg.setBounds(128, 14, 40, 38);
			bookSrchImg.setIcon(searchIcon);
	        add(bookSrchImg);
	        
	        JLabel editionlbl = new JLabel("Edition");
	        editionlbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        editionlbl.setBounds(127, 342, 56, 14);
	        add(editionlbl);
	        
	        editionField = new JTextField();
	        editionField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        editionField.setColumns(10);
	        editionField.setBounds(223, 339, 89, 20);
	        add(editionField);
	        
	        titleField = new JTextField();
	        titleField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        titleField.setColumns(10);
	        titleField.setBounds(224, 278, 315, 20);
	        add(titleField);
	        
	        authorField = new JTextField();
	        authorField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        authorField.setColumns(10);
	        authorField.setBounds(224, 311, 315, 20);
	        add(authorField);
	        
	        editionField = new JTextField();
	        editionField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        editionField.setColumns(10);
	        editionField.setBounds(224, 339, 89, 20);
	        add(editionField);
	        
	        yearField = new JTextField();
	        yearField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        yearField.setColumns(10);
	        yearField.setBounds(421, 339, 118, 20);
	        add(yearField);
	        
	        ISBNField = new JTextField();
	        ISBNField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        ISBNField.setColumns(10);
	        ISBNField.setBounds(224, 370, 315, 20);
	        add(ISBNField);
	        
	        materialField = new JTextField();
	        materialField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        materialField.setColumns(10);
	        materialField.setBounds(224, 401, 315, 20);
	        add(materialField);
	        
	        genreField = new JTextField();
	        genreField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        genreField.setColumns(10);
	        genreField.setBounds(646, 278, 315, 20);
	        add(genreField);
	        
	        shelfField = new JTextField();
	        shelfField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        shelfField.setColumns(10);
	        shelfField.setBounds(646, 311, 315, 20);
	        add(shelfField);
	        
	        totalstckField = new JTextField();
	        totalstckField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        totalstckField.setColumns(10);
	        totalstckField.setBounds(646, 339, 315, 20);
	        add(totalstckField);
	        
	        currstckField = new JTextField();
	        currstckField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        currstckField.setColumns(10);
	        currstckField.setBounds(646, 370, 315, 20);
	        add(currstckField);
	        
	    	String status [] = {"TO RETURN", "RETURNED"};
			JComboBox statusCombo = new JComboBox(status);
			statusCombo.setBounds(647, 402, 116, 22);
			add(statusCombo);
	        
		}
		
		private void updateTable(DefaultTableModel model) {
		    // Clear the existing rows in the table
		    model.setRowCount(0);

		    // Add data from the bookList to the model
		    for (CBook book : book.bookList) {
		        Object[] row = {
		            book.getTitle(), book.getEdition(), book.getAuthor(), book.getYearPublished(), book.getISBN(),
		            book.getMaterial(), book.getCategory(), book.getShelfNo(), book.getTotalStocks(),
		            book.getNoOfBorrower()
		        };
		        model.addRow(row);
		    }
		}
		public void clearFields() {
			
			titleField.setText("");
			authorField.setText("");
			yearField.setText("");
			ISBNField.setText("");
			materialField.setText("");
			genreField.setText("");
			shelfField.setText("");
			totalstckField.setText("");
			currstckField.setText("");
			searchbookField.setText("");
			editionField.setText("");
		
	}
}
