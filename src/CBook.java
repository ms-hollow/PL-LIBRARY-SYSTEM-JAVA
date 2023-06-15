import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

class CBook {
	
	//Global variable - ma-a-access ng lahat ng methods
	public static ArrayList<CBook> bookList = new ArrayList<>();		//if need i-access ng ibang class, gagawa lang ng instance ng CBook
	private static Scanner scanner = new Scanner(System.in);
	
    private String title = "";
    private String author = "";
    private String ISBN = "";
    private String edition = "";
    private String yearPublished = "";
    private String material = "";
    private String category = "";
    private int shelfNo = 0;
    private int totalStocks = 0;
    private int noOfBorrower = 0;
   

    public CBook(String title, String author, String ISBN, String edition, String yearPublished, String material, String category, int totalStocks, int noOfBorrower, int shelfNo) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.edition = edition;
        this.yearPublished = yearPublished;
        this.material = material;
        this.category = category;
        this.totalStocks = totalStocks;
        this.noOfBorrower = noOfBorrower;
        this.shelfNo =  shelfNo;  
    }

    //GETTERS
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }
    
    public String getEdition() {
        return edition;
    }
    
    public String getYearPublished() {
        return yearPublished;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public String getCategory() {
        return category;
    }
    
    public int getShelfNo() {
        return shelfNo;
    }
    
    public int getTotalStocks() {
        return totalStocks;
    }
    
    public int getNoOfBorrower() {
        return noOfBorrower;
    }
    
    
    //SETTERS
    public void setTitle(String update) {
    	this.title= update;
    }
    
    public void setAuthor(String update) {
    	this.author= update;
    }
    
    public void setISBN(String update) {
    	this.ISBN= update;
    }
    
    public void setEdition(String update) {
    	this.edition= update;
    }
    
    public void setYearPublished(String update) {
    	this.yearPublished= update;
    }
    
    public void setMaterial(String update) {
    	this.material= update;
    }
    
    public void setCategory(String update) {
    	this.category= update;
    }
    
    public void setShelfNo(int update) {
    	this.shelfNo= update;
    }
    
    public void setTotalStocks(int update) {
    	this.totalStocks= update;
    }
    
    public void setNoOfBorrower(int update) {
    	this.noOfBorrower= update;
    }
      
    //METHODS
    public void getInfoBook(String title, String author, String ISBN, String edition, String yearPublished, String material, String category, String shelfNo, String totalStocks, String noOfBorrower) {
        
        //JOP CONFIRMATION
        if(locateBook(ISBN)>-1) {		//if existing na sa record
        	JOptionPane.showMessageDialog(null, "THE BOOK ALREADY EXISTS IN THE RECORD", "Add Book", JOptionPane.ERROR_MESSAGE);
        }
        
        else if(!checkBookFields(title, author, ISBN, edition, yearPublished, material, category, shelfNo, totalStocks, noOfBorrower)) {	//if may empty fields
        	JOptionPane.showMessageDialog(null, "PLEASE FILL IN ALL FIELDS", "Add Book", JOptionPane.ERROR_MESSAGE);
        }
        
        else {
	        int choice = JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO ADD THIS BOOK RECORD?", "Add Book", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        if (choice == JOptionPane.YES_OPTION) {
	            // User clicked Yes
	        	 addBook(title, author, ISBN, edition, yearPublished, material, category, Integer.parseInt(shelfNo), Integer.parseInt(totalStocks), Integer.parseInt(noOfBorrower));	//after makuha info, i-add na.
	        	 JOptionPane.showMessageDialog(null, "BOOK RECORD SUCCESSFULLY ADDED!", "Add Book", JOptionPane.INFORMATION_MESSAGE);
	             // PUNTA SA NEXT FRAME
	        }
        }
    }

    public void addBook(String title, String author, String ISBN, String edition, String yearPublished, String material, String category, int shelfNo, int totalStocks, int noOfBorrower) {
    	CBook newBook = new CBook(title, author, ISBN, edition, yearPublished, material, category, shelfNo, totalStocks, noOfBorrower);
        int index = 0;
        
        // Find the index where the new book should be inserted alphabetically based on the title
        for (int i = 0; i < bookList.size(); i++) {						//traverse sa loop
            CBook book = bookList.get(i);								//created object book the get current index
            if (title.compareToIgnoreCase(book.getTitle()) < 0) {		//if may nahanap na mas mababa ang newBoo,
                index = i;
                break;
            } else {
                index = i + 1;
            }
        }
        
        // Insert the new book at the determined index
        bookList.add(index, newBook);
        //PAKITAWAG ANG SAVEBOOK AFTER MAG-ADD NG BOOK SA MAIN.
    }

	public void displayBooks() {
		int currentStock;
	    if (bookList.isEmpty()) {
	    	JOptionPane.showMessageDialog(null, "NO ANY RECORD FOUND!", "Display Book", JOptionPane.ERROR_MESSAGE);
	    } else {
	        System.out.println("All Books:");
	        for (CBook book : bookList) {
	            System.out.println(book.getTitle() +"\t"+ book.getAuthor() +"\t"+ book.getISBN() +"\t"+ book.getEdition() +"\t"+ book.getYearPublished() +"\t"+ book.getMaterial() +"\t"+ book.getCategory() +"\t"+ book.getShelfNo() +"\t"+ book.getTotalStocks() +"\t"+ book.getNoOfBorrower());

	        }
	    }
	}
	
	public void updateBook() {
		String updatedInfo = null;
		int updatedInfoInt=0;
		
		System.out.println("ENTER THE ISBN OF THE BOOK: ");
        String ISBN = scanner.nextLine();
        int index= locateBook(ISBN);
        
        if(index>=0) {		//if existing ang book
        	//ASK WHAT ATTRIBUTE I-UPDATE
        	System.out.println("[1] TITLE\n[2]AUTHOR\n[3]ISBN\n[4]EDITION\n[5]YEAR PUBLISHED\n[6]MATERIAL\n[7]CATEGORY\n[8]SHELF NO.\n[9]TOTAL NO. OF STOCK\n[10]TOTAL NO. OF BORROWER");
    		System.out.println("ENTER ATTRIBUTE TO UPDATE: ");
    		int attributeChoice = scanner.nextInt(); scanner.nextLine();
    		
			System.out.println("ENTER THE UPDATED INFORMATION: ");
			if(attributeChoice>7) {
				updatedInfoInt = scanner.nextInt();	scanner.nextLine();
			}
			else {
				updatedInfo = scanner.nextLine();
			}
    		
    		//ASK IF CONFIRM UPDATING
        	int choice = JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO UPDATE THE INFORMATION?", "Update Book", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        if (choice == JOptionPane.YES_OPTION) {		//if pinindot yes
	            switch(attributeChoice){				//switch case para i-update info
	            case 1: bookList.get(index).setTitle(updatedInfo); 
	            		break;
	            case 2: bookList.get(index).setAuthor(updatedInfo);
	            		break;
	            case 3: bookList.get(index).setISBN(updatedInfo);
	            		break;
	            case 4: bookList.get(index).setEdition(updatedInfo);
        				break;
	            case 5: bookList.get(index).setYearPublished(updatedInfo);
        				break;
	            case 6: bookList.get(index).setMaterial(updatedInfo);
        				break;
	            case 7: bookList.get(index).setCategory(updatedInfo);
        				break;
	            case 8: bookList.get(index).setShelfNo(updatedInfoInt);
        				break;
	            case 9: bookList.get(index).setTotalStocks(updatedInfoInt);
        				break;
	            case 10: bookList.get(index).setNoOfBorrower(updatedInfoInt);
        				break;
	            }
	        }
    		saveBook();		//save updated bookList
    		JOptionPane.showMessageDialog(null, bookList.get(index).getTitle() +" IS UPDATED SUCCESSFULLY!", "Update Book", JOptionPane.INFORMATION_MESSAGE);
        }
        else {	//if di existing book
        	JOptionPane.showMessageDialog(null, "BOOK NOT FOUND!", "Update Book", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public int locateBook(String ISBN) {
	    for (int i = 0; i < bookList.size(); i++) {
	        CBook book = bookList.get(i);					//create instance of CBook, then kinuha current index
	        if (book.getISBN().equals(ISBN)) {				//compare sa hinahanap
	            return i; 									// Return the index if ISBN matches
	        }
	    }
	    return -1; 											// Return -1 if book is not found
	}
	
	public void deleteBook() {
		System.out.println("ENTER THE ISBN OF THE BOOK YOU WANT TO DELETE: ");
		String ISBN= scanner.nextLine();
	    int index = locateBook(ISBN);
	    if (index >= 0) {
	    	
	    	//ASK IF CONFIRM UPDATING
        	int choice = JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO UPDATE THE INFORMATION?", "Delete Book", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        if (choice == JOptionPane.YES_OPTION) {		//if pinindot yes
		        bookList.remove(index);
		        JOptionPane.showMessageDialog(null, bookList.get(index).getTitle() +" IS DELETED SUCCESSFULLY!", "Delete Book", JOptionPane.INFORMATION_MESSAGE);
	        }
	    } else {
	    	JOptionPane.showMessageDialog(null, "BOOK NOT FOUND!", "Delete Book", JOptionPane.ERROR_MESSAGE);
	    }
	    saveBook();
	}
	
	public void searchBook() {
	    System.out.println("Select an attribute for searching: ");
	    System.out.println("[1] Title");
	    System.out.println("[2] Author");
	    System.out.println("[3] ISBN");
	    System.out.println("[4] EDITION");
	    System.out.println("[5] YEAR PUBLISHED");
	    System.out.println("[6] MATERIAL");
	    System.out.println("[7] CATEGORY");
	    System.out.print("Enter search category: ");
	    int choice = scanner.nextInt();
	    scanner.nextLine(); // Consume the newline character

	    System.out.print("Enter the search keyword or substring: ");
	    String keyword = scanner.nextLine();

	    boolean foundMatch = false;
	    for (CBook book : bookList) {
	        String attributeValue;
	        switch (choice) {
	            case 1:
	                attributeValue = book.getTitle();
	                break;
	            case 2:
	                attributeValue = book.getAuthor();
	                break;
	            case 3:
	                attributeValue = book.getISBN();
	                break;
	            case 4:
	                attributeValue = book.getEdition();
	                break; 
	            case 5:
	                attributeValue = book.getYearPublished();
	                break;
	            case 6:
	                attributeValue = book.getMaterial();
	                break;
	            case 7:
	                attributeValue = book.getCategory();
	                break;
	            default:
	                attributeValue = "";
	                break;
	        }

	        if (attributeValue.toLowerCase().contains(keyword.toLowerCase())) {		//finds sa bookList na may gabnong substring ignoring cases.
	        	System.out.println(book.getTitle() +"\t"+ book.getAuthor() +"\t"+ book.getISBN() +"\t"+ book.getEdition() +"\t"+ book.getYearPublished() +"\t"+ book.getMaterial() +"\t"+ book.getCategory() +"\t"+ book.getShelfNo() +"\t"+ book.getTotalStocks() +"\t"+ book.getNoOfBorrower());
	            foundMatch = true;
	        }
	    }

	    if (!foundMatch) {
	    	JOptionPane.showMessageDialog(null, "NO MATCHING BOOKS FOUND.", "Search Book", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
	
    //rewrites all the data in the file, not just append.
    public void saveBook() {		
    	
        String fileName = "src//files//BookRecords.csv";

        try {
            FileWriter writer = new FileWriter(fileName, false); // Set the second argument to 'false' to overwrite the file
            
            for (CBook book : bookList) {
                String data = book.getTitle() + "," +
                              book.getAuthor() + "," +
                              book.getISBN() + "," +
                              book.getEdition() + "," +
                              book.getYearPublished() + "," +
                              book.getMaterial() + "," +
                              book.getCategory() + "," +
                              book.getShelfNo() + "," +
                              book.getTotalStocks() + "," +
                              book.getNoOfBorrower() + "\n";

                writer.write(data);
            }
            
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error saving borrower data: " + ex.getMessage());
        }
    }
	
	public void retrieveBook() {
		String fileName = "src//files//bookRecords.csv";
                
        try {
            // create file object
            File file = new File(fileName);
            try (Scanner myReader = new Scanner(file)) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    	String[] splitWords = data.split(",");
                		addBook(
							splitWords[0], 
							splitWords[1], 
							splitWords[2],
							splitWords[3],
							splitWords[4],
							splitWords[5],
							splitWords[6],
							Integer.parseInt(splitWords[7]),	//since kinukuha niya as string, convert sa integer.
							Integer.parseInt(splitWords[8]),
							Integer.parseInt(splitWords[9])
                		);
                    }
            }
       }
       catch(Exception e) {
            System.out.println("An error occurred.");
       }
       saveBook();					//para kapag na-arrange after ng retrieve, ma-save sa excel.
	}
	
	//checks if may laman lahat ng fields.
	public boolean checkBookFields(String title, String author, String ISBN, String edition, String yearPublished, String material, String category, String shelfNo, String totalStocks, String noOfBorrower) {
		if(	title.equals("") ||
			author.equals("") ||
			ISBN.equals("") ||
			edition.equals("") ||
			yearPublished.equals("") ||
			material.equals("") ||
			category.equals("") ||
			shelfNo.equals("") ||
			totalStocks.equals("") ||
			noOfBorrower.equals("")
			) {
			return false;}
		else {
			return true;}

	}
	
	
	

	
	//END OF CLASS
}
