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
import javax.swing.JOptionPane;

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
	private static CBorrower borrower = new CBorrower("","","","","","");  
	
	private JTextField searchborrowerField;
	private JTextField tupIDField;
	private JTextField nameField;
	private JTextField courseSecField;
	private JTextField contactNoField;
	private JTextField emailField;
	private JTextField book1Field;
	private JTextField book2Field;
	private JTextField book3Field;
	private JScrollPane manageStudentscrollPane;
	private int selectedRow;
	private String TUP_ID;
	private String searchTUP_ID = "";
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
				searchborrowerField.setText("");
				TUP_ID = "";
				clearFields();
				displayTable();
			}
		});
		clearSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    clearSearch.setBounds(817, 15, 15, 31);
	    clearSearch.setIconTextGap(0);
	    clearSearch.setIcon(crossIcon);
	    add(clearSearch);
	    
	    displayTable();
       
	    JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(872, 439, 89, 23);
        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "PLEASE SELECT A ROW", "Delete Book", JOptionPane.ERROR_MESSAGE);
                } else {
                    int choice = JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO DELETE THE INFORMATION?", "Delete Book", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (choice == JOptionPane.YES_OPTION) {
                    	
                    	int index = borrower.locateBorrower(tupIDField.getText());	//returns index of the seletec book
                        CBorrower selectedTUPID = borrower.borrowerList.get(index); // Get the selected book from the bookList
                        borrower.borrowerList.remove(selectedTUPID); // Remove the selected book from the bookList
                        JOptionPane.showMessageDialog(null, "SELECTED BOOK IS DELETED SUCCESSFULLY!", "Delete Book", JOptionPane.INFORMATION_MESSAGE);
                    }
                    borrower.saveBorrower();
                    displayTable();
                    clearFields();
                }
            }
        });
        
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        deleteBtn.setBackground(Color.BLACK);
        deleteBtn.setBounds(835, 436, 89, 23);
        add(deleteBtn);
        
        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(773, 439, 89, 23);
        updateBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        				
        		if(!borrower.checkBorrowerFieldsStudRec(
        								nameField.getText(),
						 				tupIDField.getText(),
						 				courseSecField.getText(),
						 				contactNoField.getText(),
						 				emailField.getText())) {	//if may empty fields
                	JOptionPane.showMessageDialog(null, "PLEASE FILL IN ALL FIELDS", "Add Book", JOptionPane.ERROR_MESSAGE);
                }
        		else {
            		int choice = JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO UPDATE THE INFORMATION?", "Update Borrower", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		        	if (choice == JOptionPane.YES_OPTION) {		//if pinindot yes
		    	        
		        		int index = borrower.locateBorrower(TUP_ID);	//returns index of the selected borrower
		    	        borrower.borrowerList.get(index).setName(nameField.getText()); 
		    	        borrower.borrowerList.get(index).setTUP_ID(tupIDField.getText());
		    	        borrower.borrowerList.get(index).setYearSection(courseSecField.getText());
		    	        borrower.borrowerList.get(index).setContactNum(contactNoField.getText());
		    	        borrower.borrowerList.get(index).setEmail(emailField.getText());
        			}
        		}
        		borrower.saveBorrower(); 
        		displayTable();
        	}
        });
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setBounds(736, 436, 89, 23);
        add(updateBtn);
        
        JLabel tupIdStudentlbl = new JLabel("TUP ID");
        tupIdStudentlbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tupIdStudentlbl.setBounds(90, 278, 46, 14);
        add(tupIdStudentlbl);
        
        JLabel nameStudentlbl = new JLabel("Name");
        nameStudentlbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        nameStudentlbl.setBounds(90, 311, 46, 14);
        add(nameStudentlbl);
        
        JLabel contactNoStudentlbl = new JLabel("Contact No.");
        contactNoStudentlbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        contactNoStudentlbl.setBounds(90, 370, 86, 14);
        add(contactNoStudentlbl);
        
        JLabel emailStudentlbl = new JLabel("Email");
        emailStudentlbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailStudentlbl.setBounds(90, 401, 70, 14);
        add(emailStudentlbl);
        
        JLabel book1Studentlbl = new JLabel("Book No. 1");
        book1Studentlbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        book1Studentlbl.setBounds(511, 278, 89, 14);
        add(book1Studentlbl);
        
        JLabel book2Studentlbl = new JLabel("Book No. 2");
        book2Studentlbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        book2Studentlbl.setBounds(511, 311, 70, 14);
        add(book2Studentlbl);
        
        JLabel book3Studentlbl = new JLabel("Book No. 3");
        book3Studentlbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        book3Studentlbl.setBounds(511, 339, 70, 14);
        add(book3Studentlbl);
        
        tupIDField = new JTextField();
        tupIDField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tupIDField.setColumns(10);
        tupIDField.setBounds(186, 275, 315, 20);
        add(tupIDField);
        
        nameField = new JTextField();
        nameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        nameField.setColumns(10);
        nameField.setBounds(186, 308, 315, 20);
        add(nameField);
        
        contactNoField = new JTextField();
        contactNoField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        contactNoField.setColumns(10);
        contactNoField.setBounds(186, 367, 315, 20);
        add(contactNoField);
        
        emailField = new JTextField();
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailField.setColumns(10);
        emailField.setBounds(186, 398, 315, 20);
        add(emailField);
        
        book1Field = new JTextField();
        book1Field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        book1Field.setColumns(10);
        book1Field.setBounds(608, 275, 315, 20);
        add(book1Field);
        
        book2Field = new JTextField();
        book2Field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        book2Field.setColumns(10);
        book2Field.setBounds(608, 308, 315, 20);
        add(book2Field);
        
        book3Field = new JTextField();
        book3Field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        book3Field.setColumns(10);
        book3Field.setBounds(608, 336, 315, 20);
        add(book3Field);
        
        searchborrowerField = new JTextField();
        searchborrowerField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        searchborrowerField.setColumns(10);
        searchborrowerField.setBounds(130, 15, 677, 31);
        add(searchborrowerField);
        
        ///change to image
        JButton searchBtn_2 = new JButton("Search");
        searchBtn_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		searchTUP_ID = searchborrowerField.getText();
        		if (searchborrowerField.getText().isEmpty()) {
        			displayTable();
        		}
        		else {
        			displayTable();
       
        		}
        	}
        });
        searchBtn_2.setForeground(Color.WHITE);
        searchBtn_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        searchBtn_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchBtn_2.setBackground(Color.BLACK);
        searchBtn_2.setBounds(842, 15, 82, 31);
        add(searchBtn_2);
        
        JLabel bookSrchImg = new JLabel();
        bookSrchImg.setIconTextGap(0);
        bookSrchImg.setBounds(91, 11, 40, 38);
		bookSrchImg.setIcon(searchIcon);
        add(bookSrchImg);
        
        JLabel courseSectionStudent = new JLabel("Course & Section");
        courseSectionStudent.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        courseSectionStudent.setBounds(90, 339, 116, 14);
        add(courseSectionStudent);
        
        courseSecField = new JTextField();
        courseSecField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        courseSecField.setColumns(10);
        courseSecField.setBounds(206, 336, 295, 20);
        add(courseSecField);
        
	        
		}
		
	public void displayTable() {
	    // Remove previous scroll pane if it exists
	    if (manageStudentscrollPane != null) {
	        remove(manageStudentscrollPane);
	    }

	    manageStudentscrollPane = new JScrollPane();
	    manageStudentscrollPane.setBounds(80, 57, 859, 207);
	    add(manageStudentscrollPane);

	    // Create a DefaultTableModel and specify the column names
	    DefaultTableModel model = new DefaultTableModel(
	            new Object[][]{},
	            new String[]{"Name", "TUP ID", "Year and Section", "Contact No.", "Email"}
	    ) {
	        boolean[] columnEditables = new boolean[]{false, false, false, false, false};

	        public boolean isCellEditable(int row, int column) {
	            return columnEditables[column];
	        }
	    };
	    // Add data from the bookList to the model based on search criteria
	    for (CBorrower borrower : borrower.borrowerList) { 
	    	String TUP_IDVal = "";
		    TUP_IDVal = borrower.getTUP_ID();
	    	if (TUP_IDVal.contains(searchTUP_ID)) {
            Object[] row = {
            borrower.getName(), borrower.getTUP_ID(), borrower.getYearSection(), borrower.getContactNum(), borrower.getEmail()
            };
            model.addRow(row);
	    	}
	    }
	    // Create the JTable and set the model
	    JTable table = new JTable(model);

	    // Specify the desired widths for each column
	    int[] columnWidths = {150, 30, 100, 30, 120};

	    // Set the preferred column widths
	    for (int i = 0; i < columnWidths.length; i++) {
	        table.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
	    }

	    // Kapag pinindot ang table lalabas sa fields lahat ng data
	    // Add a MouseListener to the table
	    table.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            selectedRow = table.getSelectedRow();
	            if (selectedRow >= 0) {
	                nameField.setText((String) table.getValueAt(selectedRow, 0));
	                tupIDField.setText((String) table.getValueAt(selectedRow, 1));
	                courseSecField.setText((String) table.getValueAt(selectedRow, 2));
	                contactNoField.setText((String) table.getValueAt(selectedRow, 3));
	                emailField.setText((String) table.getValueAt(selectedRow, 4));
	                TUP_ID = tupIDField.getText(); //salin yung laman ng tupIDField sa string na TUP_ID for locate sa update btn
            		}
            	}
            });
	    
	    // Set the JTable as the view of the scroll pane
	    manageStudentscrollPane.setViewportView(table);
	    table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	    // Make table visible
	    table.setVisible(true);


}
		public void clearFields() {
			
			tupIDField.setText("");
			nameField.setText("");
			courseSecField.setText("");
			contactNoField.setText("");
			emailField.setText("");
			book1Field.setText("");
			book2Field.setText("");
			searchborrowerField.setText("");
		}
}
