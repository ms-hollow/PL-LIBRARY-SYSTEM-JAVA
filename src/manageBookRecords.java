import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;

public class manageBookRecords extends JPanel {
	
	private static CBook book = new CBook("","","","","","","",0,0,0);    //creates an instance of an object book para matawag mga methods na nasa class Book 
	
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
	private JTextField nobrrwrField;
	private JTextField editionField;
	private DefaultTableModel model;
	private JTable table;
	
	/**
	 * Create the panel.
	 */
	public manageBookRecords() {
		
		setBounds(0, 0, 1005, 480);
        setLayout(null);
        
        JScrollPane manageBookscrollPane = new JScrollPane();
        manageBookscrollPane.setBounds(117, 60, 859, 207);
        add(manageBookscrollPane);
        
        
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
        
       
    
        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        deleteBtn.setBackground(Color.BLACK);
        deleteBtn.setBounds(872, 439, 89, 23);
        add(deleteBtn);
        
        JButton updateBtn = new JButton("Update");
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setBounds(773, 439, 89, 23);
        add(updateBtn);
       
        JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//---- ADD NG BOOK ------//
				book.getInfoBook(titleField.getText(),
								 authorField.getText(),
								 ISBNField.getText(),
								 editionField.getText(),
								 yearField.getText(),
								 materialField.getText(),
								 genreField.getText(),
								 //----HINDI PA MAAYOS KAPAG WALA 
								 Integer.parseInt(shelfField.getText()), 
								 Integer.parseInt(totalstckField.getText()),
								 Integer.parseInt(nobrrwrField.getText())
							   );
				book.saveBook();
				updateTable(model);
			}
		});
		
        addBtn.setForeground(Color.WHITE);
        addBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        addBtn.setBackground(Color.BLACK);
        addBtn.setBounds(674, 439, 89, 23);
        add(addBtn);
        
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
        
        JLabel borrowerbookReclbl = new JLabel("No. Borrower");
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
        searchbookField.setBounds(167, 18, 695, 31);
        add(searchbookField);
        
        ///change to image
        JButton searchBtn_2 = new JButton("Search");
        searchBtn_2.setForeground(Color.WHITE);
        searchBtn_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        searchBtn_2.setBackground(Color.BLACK);
        searchBtn_2.setBounds(872, 18, 82, 31);
        add(searchBtn_2);
        
        JLabel bookSrchImg = new JLabel();
        bookSrchImg.setIconTextGap(0);
        bookSrchImg.setBounds(128, 11, 40, 38);
        add(bookSrchImg);
        
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
      			
      	JButton clearBtn = new JButton("Clear");
      	clearBtn.setForeground(new Color(255, 255, 255));
      	clearBtn.setBackground(new Color(0, 0, 0));
      	clearBtn.setBounds(575, 439, 89, 23);
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
      			editionField.setText("");
      			choice.clearSelection();	
      			}
      		});
      		clearBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
      		add(clearBtn);
        
       
        nobrrwrField = new JTextField();
        nobrrwrField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        nobrrwrField.setColumns(10);
        nobrrwrField.setBounds(646, 401, 315, 20);
        add(nobrrwrField);
        
        JLabel editionlbl = new JLabel("Edition");
        editionlbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        editionlbl.setBounds(127, 342, 56, 14);
        add(editionlbl);
        
        editionField = new JTextField();
        editionField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        editionField.setColumns(10);
        editionField.setBounds(223, 339, 89, 20);
        add(editionField);
        
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
}
