import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class studentDisplayBooks extends JPanel {
	
	private static CBook book = new CBook("","","","","","","",0,0,0);    //creates an instance of an object book para matawag mga methods na nasa class Book 
	/**
	 * Create the panel.
	 */
	public studentDisplayBooks() {
		
		setBounds(0, 0, 1005, 480);
        setLayout(null);
        
        JScrollPane displayScrollTable = new JScrollPane();
        displayScrollTable.setBounds(33, 24, 939, 427);
        add(displayScrollTable);
        
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
     		displayScrollTable.setViewportView(table);
     		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

}
