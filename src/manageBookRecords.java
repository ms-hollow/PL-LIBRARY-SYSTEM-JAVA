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

public class manageBookRecords extends JPanel {
	
	private static CBook book = new CBook("","","","","","","",0,0,0);    //creates an instance of an object book para matawag mga methods na nasa class Book 
	
	private JPanel contentPanel;
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
	private JScrollPane manageBookscrollPane;
	private DefaultTableModel model;
	private JTable table;
	private DefaultTableModel model1;
	private JTable table1;
	private DefaultTableModel model2;
	private JTable table2;
	private ButtonGroup choice;
	private int selectedRow;
	private JPanel manageBookscrollPaneSearch;
    private JRadioButton titleBtn;
    private JRadioButton authorBtn;
    private JRadioButton yearBtn;
    private JRadioButton materialBtn;
    private JRadioButton genreBtn;
    private String attributeValue;
    private String keyword = "";
    private String searchedISBN;
	private int searchChoice;
	
    
	/**
	 * Create the panel.
	 */
	public manageBookRecords() {
		
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
      		
      	JRadioButton authorBtn = new JRadioButton("Author");
      	authorBtn.setBounds(21, 99, 76, 23);
      	authorBtn.setForeground(new Color(0, 0, 0));
      	authorBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      	authorBtn.setContentAreaFilled(false);
      	add(authorBtn);
      		
      	JRadioButton yearBtn = new JRadioButton("Year ");
      	yearBtn.setBounds(21, 125, 70, 23);
      	yearBtn.setForeground(new Color(0, 0, 0));
      	yearBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      	yearBtn.setContentAreaFilled(false);
      	add(yearBtn);
      		
      	JRadioButton materialBtn = new JRadioButton("Material");
      	materialBtn.setBounds(21, 151, 95, 23);
      	materialBtn.setForeground(new Color(0, 0, 0));
      	materialBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      	materialBtn.setContentAreaFilled(false);
      	add(materialBtn);
      		
      	JRadioButton genreBtn = new JRadioButton("Genre");
      	genreBtn.setBounds(21, 177, 70, 23);
      	genreBtn.setForeground(new Color(0, 0, 0));
      	genreBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      	genreBtn.setContentAreaFilled(false);
      	add(genreBtn);
      		
      	ButtonGroup choice = new ButtonGroup();
      	choice.add(titleBtn);
      	choice.add(authorBtn);
      	choice.add(yearBtn);
      	choice.add(materialBtn);
      	choice.add(genreBtn);
      	
      	//String category = choice.getSelection().getActionCommand(); // here kung paano kinuha
      	//insert here table
      	// Add ActionListener to handle radio button selection
        ActionListener radioBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton selectedButton = (JRadioButton) e.getSource();
                
                if (selectedButton == titleBtn) {
                    searchChoice = 1;
                } else if (selectedButton == authorBtn) {
                    searchChoice = 2;
                } else if (selectedButton == yearBtn) {
                	searchChoice = 3;
                } else if (selectedButton == materialBtn) {
                	searchChoice = 4;
                } else if (selectedButton == genreBtn) {
                	searchChoice = 5;
                }
                else {
                	searchChoice=6;
                }
            }
        };

        // Add the ActionListener to each radio button
        titleBtn.addActionListener(radioBtnListener);
        authorBtn.addActionListener(radioBtnListener);
        yearBtn.addActionListener(radioBtnListener);
        materialBtn.addActionListener(radioBtnListener);
        genreBtn.addActionListener(radioBtnListener);
   
       
        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(872, 439, 89, 23);
        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "PLEASE SELECT A ROW", "Delete Book", JOptionPane.ERROR_MESSAGE);
                } else {
                    int choice = JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO DELETE THE INFORMATION?", "Delete Book", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (choice == JOptionPane.YES_OPTION) {
                    	
                    	int index= book.locateBook(ISBNField.getText());	//returns index of the seletec book
                        CBook selectedBook = book.bookList.get(index); // Get the selected book from the bookList
                        book.bookList.remove(selectedBook); // Remove the selected book from the bookList
                        JOptionPane.showMessageDialog(null, "SELECTED BOOK IS DELETED SUCCESSFULLY!", "Delete Book", JOptionPane.INFORMATION_MESSAGE);
                    }
                    book.saveBook();
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
        				
        		if(!book.checkBookFields(titleField.getText(),
						 				authorField.getText(),
						 				ISBNField.getText(),
						 				editionField.getText(),
						 				yearField.getText(),
						 				materialField.getText(),
						 				genreField.getText(),
						 				shelfField.getText(), 
						 				totalstckField.getText(),
						 				nobrrwrField.getText())) {	//if may empty fields
                	JOptionPane.showMessageDialog(null, "PLEASE FILL IN ALL FIELDS", "Add Book", JOptionPane.ERROR_MESSAGE);
                }
        		else {
            		int choice = JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO UPDATE THE INFORMATION?", "Update Book", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		        	if (choice == JOptionPane.YES_OPTION) {		//if pinindot yes
		    	        
		        		int index= book.locateBook(ISBNField.getText());	//returns index of the seletec book
		    	        book.bookList.get(index).setTitle(titleField.getText()); 
		    	        book.bookList.get(index).setAuthor(authorField.getText());
		    	        book.bookList.get(index).setISBN(ISBNField.getText());
		    	        book.bookList.get(index).setEdition(editionField.getText());
		    	        book.bookList.get(index).setYearPublished(yearField.getText());
        				book.bookList.get(index).setMaterial(materialField.getText());
        				book.bookList.get(index).setCategory(genreField.getText());
        				book.bookList.get(index).setShelfNo(Integer.parseInt(shelfField.getText()));
        				book.bookList.get(index).setTotalStocks(Integer.parseInt(totalstckField.getText()));
        				book.bookList.get(index).setNoOfBorrower(Integer.parseInt(nobrrwrField.getText()));  
        			}
        		}
    	        book.saveBook();
    	        displayTable();
        	}
        });
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        updateBtn.setBackground(Color.BLACK);
        add(updateBtn);
       
        /*
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
				nobrrwrField.setText("");
				searchbookField.setText("");
				choice.clearSelection();	
			}
		});
		clearBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		add(clearBtn);
       */
        
        JButton addBtn = new JButton("Add");
        addBtn.setBounds(674, 439, 89, 23);
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
								 shelfField.getText(), 
								 totalstckField.getText(),
								 nobrrwrField.getText()
							   );
				book.saveBook();
				displayTable();
				clearFields();
				choice.clearSelection();
			}
		});
		
		
        addBtn.setForeground(Color.WHITE);
        addBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addBtn.setBackground(Color.BLACK);
        add(addBtn);
        
        JLabel titlebookReclbl = new JLabel("Title");
        titlebookReclbl.setBounds(127, 281, 46, 14);
        titlebookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(titlebookReclbl);
        
        JLabel authorbookReclbl = new JLabel("Author");
        authorbookReclbl.setBounds(127, 314, 46, 14);
        authorbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(authorbookReclbl);
        
        JLabel yearbookReclbl = new JLabel("Year Published");
        yearbookReclbl.setBounds(322, 342, 104, 14);
        yearbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(yearbookReclbl);
        
        JLabel ISBNbookReclbl = new JLabel("ISBN");
        ISBNbookReclbl.setBounds(127, 373, 70, 14);
        ISBNbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(ISBNbookReclbl);
        
        JLabel materialbookReclbl_1 = new JLabel("Material");
        materialbookReclbl_1.setBounds(127, 404, 70, 14);
        materialbookReclbl_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(materialbookReclbl_1);
        
        JLabel genrebookReclbl = new JLabel("Genre");
        genrebookReclbl.setBounds(548, 281, 70, 14);
        genrebookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(genrebookReclbl);
        
        JLabel shelfnobookReclbl = new JLabel("Shelf No.");
        shelfnobookReclbl.setBounds(548, 314, 70, 14);
        shelfnobookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(shelfnobookReclbl);
        
        JLabel totalstockbookReclbl = new JLabel("Total Stock");
        totalstockbookReclbl.setBounds(548, 342, 70, 14);
        totalstockbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(totalstockbookReclbl);
        
        JLabel borrowerbookReclbl = new JLabel("No. Borrower");
        borrowerbookReclbl.setBounds(548, 404, 89, 14);
        borrowerbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(borrowerbookReclbl);
        
        JLabel currentbookReclbl = new JLabel("Current Stock");
        currentbookReclbl.setBounds(548, 373, 89, 14);
        currentbookReclbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(currentbookReclbl);
        
        titleField = new JTextField();
        titleField.setBounds(223, 278, 315, 20);
        titleField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        titleField.setColumns(10);
        add(titleField);
        
        authorField = new JTextField();
        authorField.setBounds(223, 311, 315, 20);
        authorField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        authorField.setColumns(10);
        add(authorField);
        
        yearField = new JTextField();
        yearField.setBounds(420, 339, 118, 20);
        yearField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        yearField.setColumns(10);
        add(yearField);
        
        ISBNField = new JTextField();
        ISBNField.setBounds(223, 370, 315, 20);
        ISBNField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        ISBNField.setColumns(10);
        add(ISBNField);
        
        materialField = new JTextField();
        materialField.setBounds(223, 401, 315, 20);
        materialField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        materialField.setColumns(10);
        add(materialField);
        
        genreField = new JTextField();
        genreField.setBounds(645, 278, 315, 20);
        genreField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        genreField.setColumns(10);
        add(genreField);
        
        shelfField = new JTextField();
        shelfField.setBounds(645, 311, 315, 20);
        shelfField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        shelfField.setColumns(10);
        add(shelfField);
        
        totalstckField = new JTextField();
        totalstckField.setBounds(645, 339, 315, 20);
        totalstckField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        totalstckField.setColumns(10);
        add(totalstckField);
        
        currstckField = new JTextField();
        currstckField.setBounds(645, 370, 315, 20);
        currstckField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        currstckField.setColumns(10);
        currstckField.setEditable(false);
        add(currstckField);
        
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
      			      
        nobrrwrField = new JTextField();
        nobrrwrField.setBounds(646, 401, 315, 20);
        nobrrwrField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        nobrrwrField.setColumns(10);
        add(nobrrwrField);
        
        JLabel editionlbl = new JLabel("Edition");
        editionlbl.setBounds(127, 342, 56, 14);
        editionlbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(editionlbl);
        
        editionField = new JTextField();
        editionField.setBounds(223, 339, 89, 20);
        editionField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        editionField.setColumns(10);
        add(editionField);
        
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
		            new String[]{"Title", "Edition", "Author", "Year", "ISBN", "Material", "Category", "Shelf No."}
		    ) {
		        boolean[] columnEditables = new boolean[]{false, false, false, false, false, false, false, false};

		        public boolean isCellEditable(int row, int column) {
		            return columnEditables[column];
		        }
		    };

		    // Add data from the bookList to the model based on search criteria
		    for (CBook book : book.bookList) {
		        String attributeValue = "";
		        switch (searchChoice) {
		            case 1:
		                attributeValue = book.getTitle();
		                break;
		            case 2:
		                attributeValue = book.getAuthor();
		                break;
		            case 3:
		                attributeValue = book.getYearPublished();
		                break;
		            case 4:
		                attributeValue = book.getMaterial();
		                break;
		            case 5:
		                attributeValue = book.getCategory();
		                break;
		            default:
		            	attributeValue = book.getTitle();
		                break;
		        }
		        if (attributeValue.toLowerCase().contains(keyword.toLowerCase())) {
		            Object[] row = {
		                    book.getTitle(), book.getEdition(), book.getAuthor(), book.getYearPublished(), book.getISBN(),
		                    book.getMaterial(), book.getCategory(), book.getShelfNo()
		            };
		            model.addRow(row);
		        }
		    }

		    // Create the JTable and set the model
		    JTable table = new JTable(model);

		    // Specify the desired widths for each column
		    int[] columnWidths = {150, 30, 100, 30, 120, 80, 80, 20};

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
		                editionField.setText((String) table.getValueAt(selectedRow, 1));
		                authorField.setText((String) table.getValueAt(selectedRow, 2));
		                yearField.setText((String) table.getValueAt(selectedRow, 3));
		                ISBNField.setText((String) table.getValueAt(selectedRow, 4));
		                materialField.setText((String) table.getValueAt(selectedRow, 5));
		                genreField.setText((String) table.getValueAt(selectedRow, 6));
		                shelfField.setText(Integer.toString((int) table.getValueAt(selectedRow, 7)));
		                //totalstckField.setText(Integer.toString((int) table.getValueAt(selectedRow, 8)));
		                //nobrrwrField.setText(Integer.toString((int) table.getValueAt(selectedRow, 9)));
		                
		                int index= book.locateBook(ISBNField.getText());				//returns index of the seletec book
		                int totalStock = book.bookList.get(index).getTotalStocks();
		                int noBorrower = book.bookList.get(index).getNoOfBorrower();
		                int currentStock = totalStock - noBorrower;
		                totalstckField.setText(Integer.toString(totalStock));
		                currstckField.setText(Integer.toString(currentStock));
		                nobrrwrField.setText(Integer.toString(noBorrower));
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
	}
}
