import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;

public class manageTransactionRecords extends JPanel {
	
	private static CBook book = new CBook("","","","","","","",0,0,0);    //creates an instance of an object book para matawag mga methods na nasa class Book 
	private static CTransaction transaction = new CTransaction("","","","","","","","","","");
	
	private JPanel contentPanel;
	private JTextField titleField;
	private JTextField ISBNField;
	private JTextField TUP_IDField;
	private JTextField dateToReturnField;
	private JTextField dateBorrowedField;
	private JTextField statusField;
	private JTextField borrowerField;
	private JTextField authorField;
	private JTextField librarianField;
	private JTextField referenceField;
	private JTextField remainingField;
	private JTextField searchbookField;
	private JScrollPane manageBookscrollPane;
	private DefaultTableModel model;
	private JTable table;
	private ButtonGroup choice;
	private int selectedRow;
	private JPanel manageBookscrollPaneSearch;
    private JRadioButton titleBtn;
    private JRadioButton ISBNBtn;
    private JRadioButton TUP_IDBtn;
    private JRadioButton dateBorrowedBtn;
    private JRadioButton dateToReturnBtn;
    private JRadioButton statusBtn;
    private String attributeValue;
    private String keyword = "";
	private int searchChoice;
	

	
   
	public manageTransactionRecords() {
		
		setBounds(0, 0, 1005, 480);
        setLayout(null);
        /*
        // Create the content panel
        contentPanel = new JPanel();
        contentPanel.setBounds(0, 0, 1005, 480);
        add(contentPanel);
        contentPanel.setLayout(null);*/
        
        ImageIcon searchIcon = new ImageIcon(this.getClass().getResource("/assets/scan.png")); // load the image to a imageIcon
		Image search = searchIcon.getImage(); // transform it 
		Image newSearch = search.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		searchIcon = new ImageIcon(newSearch);
	    
	    displayTable(); //display overall table
	    
   
	    //--------------SEACRH BY CATEGORY---------------//
		
      	JRadioButton titleBtn = new JRadioButton("Title");
      	titleBtn.setBounds(21, 73, 76, 23);
      	titleBtn.setForeground(new Color(0, 0, 0));
      	titleBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      	titleBtn.setContentAreaFilled(false);
      	add(titleBtn);
      		
      	JRadioButton ISBNBtn = new JRadioButton("ISBN");
      	ISBNBtn.setBounds(21, 99, 76, 23);
      	ISBNBtn.setForeground(new Color(0, 0, 0));
      	ISBNBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      	ISBNBtn.setContentAreaFilled(false);
      	add(ISBNBtn);
      		
      	JRadioButton TUP_IDBtn = new JRadioButton("TUP ID");
      	TUP_IDBtn.setBounds(21, 125, 70, 23);
      	TUP_IDBtn.setForeground(new Color(0, 0, 0));
      	TUP_IDBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      	TUP_IDBtn.setContentAreaFilled(false);
      	add(TUP_IDBtn);
      		
      	JRadioButton dateBorrowedBtn = new JRadioButton("Date Borrowed");
      	dateBorrowedBtn.setBounds(21, 151, 95, 23);
      	dateBorrowedBtn.setForeground(new Color(0, 0, 0));
      	dateBorrowedBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      	dateBorrowedBtn.setContentAreaFilled(false);
      	add(dateBorrowedBtn);
      		
      	JRadioButton dateToReturnBtn = new JRadioButton("Date to return");
      	dateToReturnBtn.setBounds(21, 177, 90, 23);
      	dateToReturnBtn.setForeground(new Color(0, 0, 0));
      	dateToReturnBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      	dateToReturnBtn.setContentAreaFilled(false);
      	add(dateToReturnBtn);
      	
	    JRadioButton statusBtn = new JRadioButton("Status");
	    statusBtn.setForeground(Color.BLACK);
	    statusBtn.setContentAreaFilled(false);
	    statusBtn.setBounds(21, 202, 90, 23);
	    add(statusBtn);
      		
      	ButtonGroup choice = new ButtonGroup();
      	choice.add(titleBtn);
      	choice.add(ISBNBtn);
      	choice.add(TUP_IDBtn);
      	choice.add(dateBorrowedBtn);
      	choice.add(dateToReturnBtn);
      	choice.add(statusBtn);
      	
      	//String category = choice.getSelection().getActionCommand(); // here kung paano kinuha
      	//insert here table
      	// Add ActionListener to handle radio button selection
        ActionListener radioBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton selectedButton = (JRadioButton) e.getSource();
                
                if (selectedButton == titleBtn) {
                    searchChoice = 1;
                } else if (selectedButton == ISBNBtn) {
                    searchChoice = 2;
                } else if (selectedButton == TUP_IDBtn) {
                	searchChoice = 3;
                } else if (selectedButton == dateBorrowedBtn) {
                	searchChoice = 4;
                } else if (selectedButton == dateToReturnBtn) {
                	searchChoice = 5;
                } else if (selectedButton == statusBtn) {
                	searchChoice = 6;
                
                }else {
                	searchChoice=7;
                }
            }
        };      
           
        
        

        // Add the ActionListener to each radio button
        titleBtn.addActionListener(radioBtnListener);
        ISBNBtn.addActionListener(radioBtnListener);
        TUP_IDBtn.addActionListener(radioBtnListener);
        dateBorrowedBtn.addActionListener(radioBtnListener);
        dateToReturnBtn.addActionListener(radioBtnListener);
        statusBtn.addActionListener(radioBtnListener);
   
       
        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(872, 439, 89, 23);
        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "PLEASE SELECT A ROW", "Delete Transaction", JOptionPane.ERROR_MESSAGE);
                } else {
                    int choice = JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO DELETE THE INFORMATION?", "Delete Transaction", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (choice == JOptionPane.YES_OPTION) {
                    	
                    	int index= transaction.locateTransaction(referenceField.getText());	//returns index of the seletec book
                        CTransaction selectedTransaction = transaction.transactionList.get(index); // Get the selected book from the bookList
                        transaction.transactionList.remove(selectedTransaction); // Remove the selected book from the bookList
                        JOptionPane.showMessageDialog(null, "SELECTED TRANSACTION IS DELETED SUCCESSFULLY!", "Delete Transaction", JOptionPane.INFORMATION_MESSAGE);
                    }
                    transaction.saveTransaction();
                    displayTable();
                    clearFields();
                }
            }
        });



        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        deleteBtn.setBackground(Color.BLACK);
        add(deleteBtn);
        
        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(773, 439, 89, 23);
        updateBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        				
        		if(!transaction.checkTransactionFields(titleField.getText(),
						 				ISBNField.getText(),
						 				TUP_IDField.getText(),
						 				dateBorrowedField.getText(),
						 				dateToReturnField.getText(),
						 				statusField.getText(),
						 				borrowerField.getText(),
						 				authorField.getText(), 
						 				librarianField.getText(),
						 				referenceField.getText())) {	//if may empty fields
                	JOptionPane.showMessageDialog(null, "PLEASE FILL IN ALL FIELDS", "Add transaction", JOptionPane.ERROR_MESSAGE);
                }
        		else {
            		int choice = JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO UPDATE THE INFORMATION?", "Update transaction", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		        	if (choice == JOptionPane.YES_OPTION) {		//if pinindot yes
		    	        
		        		int index= transaction.locateTransaction(referenceField.getText());	//returns index of the seletec transaction
		    	        
		        		transaction.transactionList.get(index).setTitle(titleField.getText()); 
		        		transaction.transactionList.get(index).setISBN(ISBNField.getText());
		        		transaction.transactionList.get(index).setTUP_ID(TUP_IDField.getText());
		        		transaction.transactionList.get(index).setDateBorrowed(dateBorrowedField.getText());
		        		transaction.transactionList.get(index).setDateToReturn(dateToReturnField.getText());
		        		transaction.transactionList.get(index).setStatus(statusField.getText());
		        		transaction.transactionList.get(index).setBorrower(borrowerField.getText());
		        		transaction.transactionList.get(index).setAuthor(authorField.getText());
		        		transaction.transactionList.get(index).setLibrarian(librarianField.getText());
		        		transaction.transactionList.get(index).setRefNum(referenceField.getText());
		        		//PARA SA REMAINING DAYS
        			}
        		}
    	        transaction.saveTransaction();
    	        displayTable();
        	}
        });
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        updateBtn.setBackground(Color.BLACK);
        add(updateBtn);
        
        JLabel titlebookReclbl = new JLabel("Title");
        titlebookReclbl.setBounds(127, 281, 46, 14);
        titlebookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(titlebookReclbl);
        
        JLabel ISBNReclbl = new JLabel("ISBN");
        ISBNReclbl.setBounds(127, 314, 46, 14);
        ISBNReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(ISBNReclbl);
        
        JLabel materialbookReclbl_1 = new JLabel("Borrower");
        materialbookReclbl_1.setBounds(127, 404, 70, 14);
        materialbookReclbl_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(materialbookReclbl_1);
        
        JLabel genrebookReclbl = new JLabel("Date to return");
        genrebookReclbl.setBounds(548, 281, 105, 14);
        genrebookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(genrebookReclbl);
        
        JLabel shelfnobookReclbl = new JLabel("Date Borrowed");
        shelfnobookReclbl.setBounds(548, 314, 105, 14);
        shelfnobookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(shelfnobookReclbl);
        
        JLabel totalstockbookReclbl = new JLabel("Remaining days");
        totalstockbookReclbl.setBounds(548, 342, 105, 14);
        totalstockbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(totalstockbookReclbl);
        
        JLabel borrowerbookReclbl = new JLabel("Status");
        borrowerbookReclbl.setBounds(548, 404, 89, 14);
        borrowerbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(borrowerbookReclbl);
        
        JLabel currentbookReclbl = new JLabel("Librarian");
        currentbookReclbl.setBounds(548, 373, 89, 14);
        currentbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(currentbookReclbl);
        
        titleField = new JTextField();
        titleField.setBounds(223, 278, 315, 20);
        titleField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        titleField.setColumns(10);
        add(titleField);
        
        ISBNField = new JTextField();
        ISBNField.setBounds(223, 311, 315, 20);
        ISBNField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        ISBNField.setColumns(10);
        add(ISBNField);
        
        TUP_IDField = new JTextField();
        TUP_IDField.setBounds(223, 370, 315, 20);
        TUP_IDField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        TUP_IDField.setColumns(10);
        add(TUP_IDField);
        
        borrowerField = new JTextField();
        borrowerField.setBounds(223, 401, 315, 20);
        borrowerField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        borrowerField.setColumns(10);
        add(borrowerField);
        
        dateToReturnField = new JTextField();
        dateToReturnField.setBounds(663, 278, 297, 20);
        dateToReturnField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        dateToReturnField.setColumns(10);
        add(dateToReturnField);
        
        dateBorrowedField = new JTextField();
        dateBorrowedField.setBounds(663, 311, 297, 20);
        dateBorrowedField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        dateBorrowedField.setColumns(10);
        add(dateBorrowedField);
        
        remainingField = new JTextField();
        remainingField.setBounds(663, 339, 64, 20);
        remainingField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        remainingField.setColumns(10);
        add(remainingField);
        
        searchbookField = new JTextField();
        searchbookField.setBounds(167, 18, 677, 31);
        searchbookField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        searchbookField.setColumns(10);
        add(searchbookField);
        
        JButton searchBtn_2 = new JButton("Search");
        searchBtn_2.setBounds(879, 18, 82, 31);
        searchBtn_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		keyword = searchbookField.getText();
        		if (searchbookField.getText().isEmpty()) {
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
        add(searchBtn_2);
        
        JLabel bookSrchImg = new JLabel();
        bookSrchImg.setBounds(128, 14, 40, 38);
        bookSrchImg.setIconTextGap(0);
		bookSrchImg.setIcon(searchIcon);
        add(bookSrchImg);
      			      
        statusField = new JTextField();
        statusField.setBounds(663, 401, 298, 20);
        statusField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        statusField.setColumns(10);
        add(statusField);
        
        ImageIcon crossIcon = new ImageIcon(this.getClass().getResource("/assets/cross.png")); // load the image to a imageIcon
		Image cross = crossIcon.getImage(); // transform it 
		Image newCross = cross.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		crossIcon = new ImageIcon(newCross);
				   
		JLabel clearSearch = new JLabel("");
		clearSearch.setBounds(854, 18, 15, 31);
		clearSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchbookField.setText("");
				choice.clearSelection();		//tinatanggal selected radio button
				keyword = "";					//tinatanggal yung search keyword
				clearFields();					//tinatanggal yung laman ng fields
				displayTable();
				
			}
		});
		clearSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    clearSearch.setIconTextGap(0);
	    clearSearch.setIcon(crossIcon);
	    add(clearSearch);
	    
	    authorField = new JTextField();
	    authorField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	    authorField.setColumns(10);
	    authorField.setBounds(223, 342, 315, 20);
	    add(authorField);
	    
	    JLabel ISBNbookReclbl_1 = new JLabel("Author");
	    ISBNbookReclbl_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	    ISBNbookReclbl_1.setBounds(127, 345, 70, 14);
	    add(ISBNbookReclbl_1);
	    
	    JLabel materialbookReclbl_1_1 = new JLabel("TUP ID");
	    materialbookReclbl_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	    materialbookReclbl_1_1.setBounds(127, 373, 70, 14);
	    add(materialbookReclbl_1_1);
	    
	    referenceField = new JTextField();
	    referenceField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	    referenceField.setColumns(10);
	    referenceField.setBounds(829, 339, 132, 20);
	    add(referenceField);
	    
	    JLabel lblReferenceNo = new JLabel("Reference no.");
	    lblReferenceNo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	    lblReferenceNo.setBounds(737, 342, 105, 14);
	    add(lblReferenceNo);
	    
	    librarianField = new JTextField();
	    librarianField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	    librarianField.setColumns(10);
	    librarianField.setBounds(663, 373, 298, 20);
	    add(librarianField);
	    
        
        
	}
	
	public void displayTable() {
		    // Remove previous scroll pane if it exists
		    if (manageBookscrollPane != null) {
		        remove(manageBookscrollPane);
		    }

		    manageBookscrollPane = new JScrollPane();
		    manageBookscrollPane.setBounds(117, 60, 859, 207);
		    add(manageBookscrollPane);

		    // Create a DefaultTableModel and specify the column names
		    DefaultTableModel model = new DefaultTableModel(
		            new Object[][]{},
		            new String[]{"Title", "ISBN", "TUP_ID", "Date Borrowed", "Date to Return", "Status"}
		    ) {
		        boolean[] columnEditables = new boolean[]{false, false, false, false, false, false};

		        public boolean isCellEditable(int row, int column) {
		            return columnEditables[column];
		        }
		    };

		    // Add data from the bookList to the model based on search criteria
		    boolean ifNoMatch=true;
		    for (CTransaction transaction : transaction.transactionList) {
		        String attributeValue = "";
		        switch (searchChoice) {
		            case 1:
		                attributeValue = transaction.getTitle();
		                break;
		            case 2:
		                attributeValue = transaction.getISBN();
		                break;
		            case 3:
		                attributeValue = transaction.getTUP_ID();
		                break;
		            case 4:
		                attributeValue = transaction.getDateBorrowed();
		                break;
		            case 5:
		                attributeValue = transaction.getDateToReturn();
		                break;
		            default:
		            	attributeValue = transaction.getTitle();
		                break;
		        }
		  
		        if (attributeValue.toLowerCase().contains(keyword.toLowerCase())) {
		        	ifNoMatch= false;
		            Object[] row = {
		            		transaction.getTitle(), transaction.getISBN(), transaction.getTUP_ID(), transaction.getDateBorrowed(), 
		            		transaction.getDateToReturn(), transaction.getStatus()
		            };
		            model.addRow(row);
		        }
		    }
		    
	        if(ifNoMatch) {
	        	JOptionPane.showMessageDialog(null, "NO MATCHING TRANSACTIONS FOUND.", "Search Transaction", JOptionPane.INFORMATION_MESSAGE);
	        	selectedRow=-1;			//para if nag-pindot button nang walnag matching book.
	        }

		    // Create the JTable and set the model
		    JTable table = new JTable(model);

		    // Specify the desired widths for each column
		    int[] columnWidths = {150, 30, 100, 30, 120, 80};

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
		                titleField.setText((String) table.getValueAt(selectedRow, 0));
		                ISBNField.setText((String) table.getValueAt(selectedRow, 1));
		                TUP_IDField.setText((String) table.getValueAt(selectedRow, 2));
		                dateBorrowedField.setText((String) table.getValueAt(selectedRow, 3));
		                dateToReturnField.setText((String) table.getValueAt(selectedRow, 4));
		                statusField.setText((String) table.getValueAt(selectedRow, 5));
		                
		                
		                //totalstckField.setText(Integer.toString((int) table.getValueAt(selectedRow, 8)));
		                //nobrrwrField.setText(Integer.toString((int) table.getValueAt(selectedRow, 9)));
		                
		                int index= transaction.locateTransaction(referenceField.getText());				//returns index of the seletec book
		                String borrower = transaction.transactionList.get(index).getBorrower();
		                String author = transaction.transactionList.get(index).getAuthor();
		                String librarian = transaction.transactionList.get(index).getLibrarian();
		                String refNum = transaction.transactionList.get(index).getRefNum();
		                //SET FIELD NG REMAINING DAYS
	
		                }
		                }
		                });
		    
		 // Set the JTable as the view of the scroll pane
		    manageBookscrollPane.setViewportView(table);
		    table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		    // Make table visible
		    table.setVisible(true);

		    /*// Hide table1 if it was previously visible
		    if (table1 != null) {
		        table1.setVisible(false);
		    }

		    // Hide table2 if it was previously visible
		    if (table2 != null) {
		        table2.setVisible(false);
		    }
*/

	}
	
	public void clearFields() {
		
		titleField.setText("");
		ISBNField.setText("");
		TUP_IDField.setText("");
		dateBorrowedField.setText("");
		dateToReturnField.setText("");
		statusField.setText("");
		borrowerField.setText("");
		authorField.setText("");
		librarianField.setText("");
		referenceField.setText("");
		searchbookField.setText("");
	
	}
}
	
