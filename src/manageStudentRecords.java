import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class manageStudentRecords extends JPanel {
	
	private static CBook book = new CBook("","","","","","","",0,0,0);    //creates an instance of an object book para matawag mga methods na nasa class Book 
	
	private JTextField searchbookField;
	private JTextField tupIDField;
	private JTextField nameField;
	private JTextField courseSecField;
	private JTextField contactNoField;
	private JTextField emailField;
	private JTextField book1Field;
	private JTextField book2Field;
	private JTextField book3Field;
	/**
	 * Create the panel.
	 */
	public manageStudentRecords() {
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
			int[] columnWidths = {150, 30, 100, 30, 120, 80, 80, 20, 20, 20};

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
	        
	       
	        JButton deleteBtn = new JButton("Delete");
	        deleteBtn.setForeground(Color.WHITE);
	        deleteBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        deleteBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        deleteBtn.setBackground(Color.BLACK);
	        deleteBtn.setBounds(872, 439, 89, 23);
	        add(deleteBtn);
	        
	        JButton updateBtn = new JButton("Update");
	        updateBtn.setForeground(Color.WHITE);
	        updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        updateBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        updateBtn.setBackground(Color.BLACK);
	        updateBtn.setBounds(773, 439, 89, 23);
	        add(updateBtn);
	        
	        JLabel tupIdStudentlbl = new JLabel("TUP ID");
	        tupIdStudentlbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        tupIdStudentlbl.setBounds(127, 281, 46, 14);
	        add(tupIdStudentlbl);
	        
	        JLabel nameStudentlbl = new JLabel("Name");
	        nameStudentlbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        nameStudentlbl.setBounds(127, 314, 46, 14);
	        add(nameStudentlbl);
	        
	        JLabel contactNoStudentlbl = new JLabel("Contact No.");
	        contactNoStudentlbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        contactNoStudentlbl.setBounds(127, 373, 86, 14);
	        add(contactNoStudentlbl);
	        
	        JLabel emailStudentlbl = new JLabel("Email");
	        emailStudentlbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        emailStudentlbl.setBounds(127, 404, 70, 14);
	        add(emailStudentlbl);
	        
	        JLabel book1Studentlbl = new JLabel("Book No. 1");
	        book1Studentlbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        book1Studentlbl.setBounds(548, 281, 89, 14);
	        add(book1Studentlbl);
	        
	        JLabel book2Studentlbl = new JLabel("Book No. 2");
	        book2Studentlbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        book2Studentlbl.setBounds(548, 314, 70, 14);
	        add(book2Studentlbl);
	        
	        JLabel book3Studentlbl = new JLabel("Book No. 3");
	        book3Studentlbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        book3Studentlbl.setBounds(548, 342, 70, 14);
	        add(book3Studentlbl);
	        
	        tupIDField = new JTextField();
	        tupIDField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        tupIDField.setColumns(10);
	        tupIDField.setBounds(223, 278, 315, 20);
	        add(tupIDField);
	        
	        nameField = new JTextField();
	        nameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        nameField.setColumns(10);
	        nameField.setBounds(223, 311, 315, 20);
	        add(nameField);
	        
	        contactNoField = new JTextField();
	        contactNoField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        contactNoField.setColumns(10);
	        contactNoField.setBounds(223, 370, 315, 20);
	        add(contactNoField);
	        
	        emailField = new JTextField();
	        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        emailField.setColumns(10);
	        emailField.setBounds(223, 401, 315, 20);
	        add(emailField);
	        
	        book1Field = new JTextField();
	        book1Field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        book1Field.setColumns(10);
	        book1Field.setBounds(645, 278, 315, 20);
	        add(book1Field);
	        
	        book2Field = new JTextField();
	        book2Field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        book2Field.setColumns(10);
	        book2Field.setBounds(645, 311, 315, 20);
	        add(book2Field);
	        
	        book3Field = new JTextField();
	        book3Field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        book3Field.setColumns(10);
	        book3Field.setBounds(645, 339, 315, 20);
	        add(book3Field);
	        
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
	      	
	        /*
	        nobrrwrField = new JTextField();
	        nobrrwrField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        nobrrwrField.setColumns(10);
	        nobrrwrField.setBounds(646, 401, 315, 20);
	        add(nobrrwrField);*/
	        
	        JLabel courseSectionStudent = new JLabel("Course & Section");
	        courseSectionStudent.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        courseSectionStudent.setBounds(127, 342, 116, 14);
	        add(courseSectionStudent);
	        
	        courseSecField = new JTextField();
	        courseSecField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        courseSecField.setColumns(10);
	        courseSecField.setBounds(243, 339, 295, 20);
	        add(courseSecField);
	        
	        
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
			
			tupIDField.setText("");
			nameField.setText("");
			contactNoField.setText("");
			emailField.setText("");
			book1Field.setText("");
			book2Field.setText("");
			//nobrrwrField.setText("");
			searchbookField.setText("");
		}
}
