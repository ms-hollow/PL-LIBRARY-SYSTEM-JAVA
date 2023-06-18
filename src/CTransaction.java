import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CTransaction {
	
	//Global variable - ma-a-access ng lahat ng methods
	private static Scanner scanner = new Scanner(System.in);
	public static ArrayList<CTransaction> transactionList = new ArrayList<>();		//if need i-access ng ibang class, gagawa lang ng instance ng CBook
	public static CBorrower Borrower = new CBorrower("", "", "", "", "", "");		//PARA MA-ACCES METHODS NG CBorrower
	private static CBook Book= new CBook("","","","","","","",0,0,0);	
	  
    private String title;
    private String author;
    private String ISBN;
    private String borrower;
    private String TUP_ID;
    private String dateBorrowed;
    private String dateToReturn;
    private String librarian;
    private String refNum;
    private String status;
    public static int accountIndex;		//public static para ma-access directly ng logIn.
    public static int bookIndex;

    public CTransaction(String title, String ISBN, String TUP_ID, String dateBorrowed, String dateToReturn, String status, String borrower, String author,  String librarian, String refNum) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.borrower = borrower;
        this.TUP_ID = TUP_ID;
        this.dateBorrowed = dateBorrowed;
        this.dateToReturn = dateToReturn;
        this.librarian = librarian;
        this.refNum = refNum;
        this.status= status;
    }
    

    //GETTERS
    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public String getISBN() {return ISBN;}
    public String getBorrower() {return borrower;}
    public String getTUP_ID() {return TUP_ID;}
    public String getDateBorrowed() {return dateBorrowed;}
    public String getDateToReturn() {return dateToReturn;}
    public String getLibrarian() {return librarian;}
    public String getRefNum() {return refNum;}
    public String getStatus() {return status;}
    public int getAccountIndex() {return accountIndex;}
    public int getBookIndex() {return bookIndex;}
 
    //SETTERS
    public void setTitle(String update) {this.title= update;}
    public void setAuthor(String update) {this.author= update;}
    public void setISBN(String update) {this.ISBN= update;}
    public void setBorrower(String update) {this.borrower= update;}
    public void setTUP_ID(String update) {this.TUP_ID= update;}
    public void setDateBorrowed(String update) {this.dateBorrowed= update;}
    public void setDateToReturn(String update) {this.dateToReturn= update;}
    public void setLibrarian(String update) {this.librarian= update;}
    public void setRefNum(String update) {this.refNum= update;}
    public void setStatus(String update) {this.status= update;}
    

    //METHODS
    public void getInfoTransaction(String selectedTitle, String selectedAuthor, String selectedISBN) {
    	//Gets the logged in account of the current user.
    	int index = getAccountIndex();			//direct change ng variable.
    	int bookIndex =  getBookIndex();
    	
    	JPanel panel = new JPanel();
    	panel.setLayout(new FlowLayout(FlowLayout.LEFT));

    	JLabel welcomeLabel = new JLabel("TUP READS");
    	welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
    	welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the label horizontally
    	welcomeLabel.setForeground(Color.RED); // Set font color to red
    	panel.add(welcomeLabel);

    	JLabel libLabel = new JLabel("Welcome to TUP READS, " + CBorrower.borrowerList.get(index).getName());
    	libLabel.setFont(new Font("Arial", Font.BOLD, 16));
    	panel.add(libLabel);
    	
    	
    	JLabel tupIdLabel = new JLabel("TUP ID: " + CBorrower.borrowerList.get(index).getTUP_ID());
    	tupIdLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    	panel.add(tupIdLabel);

    	JLabel yearSectionLabel = new JLabel("Year and Section: " + CBorrower.borrowerList.get(index).getYearSection());
    	yearSectionLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    	panel.add(yearSectionLabel);


    	JTextField titleField = new JTextField(selectedTitle);
    	titleField.setPreferredSize(new Dimension(500, 30));
    	panel.add(new JLabel("Book to Borrow"));
    	titleField.setEditable(false);
    	panel.add(titleField);

    	JTextField authorField = new JTextField(selectedAuthor);
    	authorField.setPreferredSize(new Dimension(500, 30));
    	panel.add(new JLabel("Book Author"));
    	authorField.setEditable(false);
    	panel.add(authorField);

    	JTextField ISBNField = new JTextField(selectedISBN);
    	ISBNField.setPreferredSize(new Dimension(500, 30));
    	panel.add(new JLabel("ISBN"));
    	ISBNField.setEditable(false);
    	panel.add(ISBNField);

    	JTextField dateBorrowedField = new JTextField();
    	dateBorrowedField.setPreferredSize(new Dimension(500, 30));
    	dateBorrowedField.setEditable(false);

    	// Set the current date in CurrentDate field
    	SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
    	String currentDate = dateFormat.format(new Date());
    	dateBorrowedField.setText(currentDate);
    	panel.add(new JLabel("Enter Date Borrowed"));
    	panel.add(dateBorrowedField);

    	JTextField dateToReturnField = new JTextField();
    	dateToReturnField.setPreferredSize(new Dimension(500, 30));
    	panel.add(new JLabel("Enter Date to Return"));
    	panel.add(dateToReturnField);

    	JButton calendarButton = new JButton("Calendar");
    	calendarButton.setPreferredSize(new Dimension(30, dateToReturnField.getPreferredSize().height));
    	calendarButton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JCalendar calendar = new JCalendar();
    	        calendar.setMinSelectableDate(new Date()); // Set the minimum selectable date as today
    	        calendar.setMaxSelectableDate(null); // Remove the maximum selectable date limitation
    	        int option = JOptionPane.showOptionDialog(dateToReturnField, calendar, "Select Date", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
    	        if (option == JOptionPane.OK_OPTION) {
    	            Date selectedDate = calendar.getDate();
    	            String returnDate = dateFormat.format(selectedDate);

    	            if (isWithinSevenDays(dateBorrowedField.getText(), returnDate)) {
    	                dateToReturnField.setText(returnDate);
    	            } else {
    	                JOptionPane.showMessageDialog(null, "Return date should be within 7 days from the date borrowed.", "Invalid Return Date", JOptionPane.ERROR_MESSAGE);
    	            }
    	        }
    	    }
    	});
    	panel.add(calendarButton);

    	JTextField librarianField = new JTextField("Ms. Laica");
    	librarianField.setPreferredSize(new Dimension(500, 30));
    	librarianField.setEditable(false);
    	panel.add(new JLabel("Library In-charge"));
    	panel.add(librarianField);

    	JTextField statusField = new JTextField("To Approve");
    	statusField.setPreferredSize(new Dimension(500, 30));
    	statusField.setEditable(false);
    	panel.add(new JLabel("Status"));
    	panel.add(statusField);

    	Object[] fields = {
    	        welcomeLabel,
    	        "\n\n",
    	        libLabel,
    	        "\n",
    	        tupIdLabel,
    	        yearSectionLabel,
    	        "\n\n",
    	        "Book to Borrow", titleField,
    	        "Book Author", authorField,
    	        "ISBN", ISBNField,
    	        "Enter Date Borrowed", dateBorrowedField,
    	        "Enter Date to Return", dateToReturnField, calendarButton,
    	        "Library In-charge", librarianField,
    	        "Status", statusField
    	};

    	// Kapag may empty na field, maglo-loop siya sa get info hanggang magkaroon ng laman lahat ng field
    	while (true) {
    	    int choice = JOptionPane.showConfirmDialog(null, fields, "Fill-in Transaction Form", JOptionPane.OK_CANCEL_OPTION);
    	    if (choice != JOptionPane.OK_OPTION) {
    	        // User clicked Cancel or closed the dialog
    	        return;
    	    }
    	    // Isasalin sa string lahat ng nasa textfield
    	    String title = titleField.getText();
    	    String author = authorField.getText();
    	    String ISBN = ISBNField.getText();
    	    String dateBorrowed = dateBorrowedField.getText();
    	    String dateToReturn = dateToReturnField.getText();
    	    String librarian = librarianField.getText();
    	    String status = statusField.getText();
        	String TUP_ID = CBorrower.borrowerList.get(index).getTUP_ID();
        	String borrower = CBorrower.borrowerList.get(index).getName();
    	    

            // Check transaction fields
	        if (!checkTransactionFields(title, ISBN , TUP_ID, dateBorrowed, dateToReturn, status, borrower, author, librarian, "-")) {
	            JOptionPane.showMessageDialog(null, "PLEASE FILL IN ALL FIELDS", "Borrow book", JOptionPane.ERROR_MESSAGE);
	            continue;
	        }

	        else if (Book.locateBook(ISBN) < 0) {
	            JOptionPane.showMessageDialog(null, "ENTERED RECORD DOES NOT EXIST", "Borrow book", JOptionPane.ERROR_MESSAGE);
	            continue;
	           
	        }
	        
	        /*else if(){
	            //if greater than 3 na nahiram niyang book
	        }*/
	        setRefNum(generateRefNum());
	        String displayMessage =
	        			"\nReference Number: "		+ getRefNum() + "\n\n" +
	        		
						"Name: "		+ CBorrower.borrowerList.get(index).getName() + "\n" +
						"TUP ID: "		+ CBorrower.borrowerList.get(index).getTUP_ID() + "\n" +
						"Year and Section: "		 + CBorrower.borrowerList.get(index).getYearSection() + "\n\n" +
    	                "Title of the book: "		+ title + "\n" +
    	                "Author of the Book: "		+ author + "\n" +
    	                "ISBN of the book: "		+ ISBN + "\n" +
    	                "Enter Date Borrowed: "		+ dateBorrowed + "\n" +
    	                "Enter Date to Return: "		+ dateToReturn + "\n" +
    	                "Days Remaining: "			+ calculateRemainingDays(dateToReturn) + "\n" +
    	                "Library In-charge: "		+ librarian + "\n" +
    	                "Status: "		+ status;

	        JOptionPane.showMessageDialog(null, displayMessage, "Statement of Transaction", JOptionPane.INFORMATION_MESSAGE);
	        int remainingDays = calculateRemainingDays(dateToReturn); 
	        addTransaction(title, author, ISBN, borrower, TUP_ID, dateBorrowed, dateToReturn, librarian, refNum, status); //after makuha info, i-add na.
	        saveTransaction();
	        JOptionPane.showMessageDialog(null, "TRANSACTION SUCCESSFULLY SUBMITTED. PROCEED TO THE LIBRARIAN TO APPROVE TRANSACTION", "Borrow Book", JOptionPane.INFORMATION_MESSAGE);
	        // PUNTA SA NEXT FRAME
	        break;
	    }

	}

    public static int calculateRemainingDays(String dateToReturn) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Date returnDate = dateFormat.parse(dateToReturn);
            Date currentDate = new Date(); // Get the current date

            long diff = returnDate.getTime() - currentDate.getTime(); // Calculate the difference between return date and current date
            long remainingDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

            if (remainingDays >= 0) {
                return (int) remainingDays;
            } else {
                return 0; // 0 value indicates overdue
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return -1; // Return -1 if there is an error parsing the date
        }
    }


    public void addTransaction(String title, String author, String ISBN, String borrower, String TUP_ID, String dateBorrowed, String dateToReturn, String librarian, String refNum,  String status) {
    	CTransaction newTransaction = new CTransaction(title, author, ISBN, borrower, TUP_ID, dateBorrowed, dateToReturn, librarian, refNum, status);
        int index = 0;
        
        // Find the index where the new transactionshould be inserted alphabetically based on the title
        for (int i = 0; i < transactionList.size(); i++) {						//traverse sa loop
            CTransaction transaction = transactionList.get(i);								//created object transactionthe get current index
            if (title.compareToIgnoreCase(transaction.getTitle()) < 0) {		//if may nahanap na mas mababa ang newBoo,
                index = i;
                break;
            } else {
                index = i + 1;
            }
        }
        
        // Insert the new transactionat the determined index
        transactionList.add(index, newTransaction);
        //PAKITAWAG ANG SAVEtransactionAFTER MAG-ADD NG transactionSA MAIN.
    }

	public void displayTransaction() {

	    if (transactionList.isEmpty()) {
	    	JOptionPane.showMessageDialog(null, "NO ANY RECORD FOUND!", "Display Book", JOptionPane.ERROR_MESSAGE);
	    } else {
	        System.out.println("All Books:");
	        for (CTransaction transaction: transactionList) {
	        	  
	        	 int remainingDays = calculateRemainingDays(transaction.getDateToReturn());
	            System.out.println( generateRefNum() +"\t"+ transaction.getTitle() +"\t"+ transaction.getAuthor() +"\t"+ transaction.getISBN() +"\t"+ transaction.getBorrower() +"\t"+ transaction.getTUP_ID() +"\t"+ transaction.getDateBorrowed() 
	            +"\t"+ transaction.getDateToReturn() +"\t"+ transaction.getLibrarian() +"\t"+ transaction.getStatus() +"\t"+ remainingDays);
	        }
	    }
	}
	
	public void updateTransaction() {
		String updatedInfo = "";
		
		System.out.println("ENTER THE REFERENCE NO. OF TRANSACTION: ");
        String refNum = scanner.nextLine();
        int index= locateTransaction(refNum);
        
        if(index>=0) {		//if existing ang book
        	//ASK WHAT ATTRIBUTE I-UPDATE
        	System.out.println("[1] TITLE\n[2]AUTHOR\n[3]ISBN\n[4]BORROWER\n[5]TUP_ID\n[6]DATE BORROWED\n[7]DATE TO RETURN \n[8]LIBRARIAN \n[9]STATUS");
    		System.out.println("ENTER ATTRIBUTE TO UPDATE: ");
    		int attributeChoice = scanner.nextInt(); scanner.nextLine();
			System.out.println("ENTER THE UPDATED INFORMATION: ");
			updatedInfo= scanner.nextLine();

    		//ASK IF CONFIRM UPDATING
        	int choice = JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO UPDATE THE INFORMATION?", "Update Transaction", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        if (choice == JOptionPane.YES_OPTION) {		//if pinindot yes
	            switch(attributeChoice){				//switch case para i-update info
	            case 1: transactionList.get(index).setTitle(updatedInfo); 
	            		break;
	            case 2: transactionList.get(index).setAuthor(updatedInfo);
	            		break;
	            case 3: transactionList.get(index).setISBN(updatedInfo);
	            		break;
	            case 4: transactionList.get(index).setBorrower(updatedInfo);
        				break;
	            case 5: transactionList.get(index).setTUP_ID(updatedInfo);
        				break;
	            case 6: transactionList.get(index).setDateBorrowed(updatedInfo);
        				break;
	            case 7: transactionList.get(index).setDateToReturn(updatedInfo);
        				break;
	            case 8: transactionList.get(index).setLibrarian(updatedInfo);
        				break;
	            case 9: transactionList.get(index).setStatus(updatedInfo);
        				break;
	            }
	        }
    		saveTransaction();		//save updated transactionList
    		JOptionPane.showMessageDialog(null, "TRANSACTION UPDATED SUCCESSFULLY!", "Update Transaction", JOptionPane.INFORMATION_MESSAGE);
        }
        else {	//if di existing transaction
        	JOptionPane.showMessageDialog(null, "TRANSACTION NOT FOUND!", "Update Transaction", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public int locateTransaction(String refNum) {
	    for (int i = 0; i < transactionList.size(); i++) {
	        CTransaction transaction= transactionList.get(i);					//create instance of CBook, then kinuha current index
	        if (transaction.getISBN().equals(ISBN)) {				//compare sa hinahanap
	            return i; 									// Return the index if ISBN matches
	        }
	    }
	    return -1; 											// Return -1 if transactionis not found
	}
	
	public void searchTransaction() {
	    System.out.println("Select an attribute for searching: ");
	    System.out.println("[1] Title");
	    System.out.println("[2] Author");
	    System.out.println("[3] ISBN");
	    System.out.println("[4] BORROWER");
	    System.out.println("[5] YEAR PUBLISHED");
	    System.out.println("[6] dateBorrowed");
	    System.out.println("[7] dateToReturn");
	    System.out.println("[7] REFERENCE NO.");
	    System.out.print("Enter search dateToReturn: ");
	    int choice = scanner.nextInt();
	    scanner.nextLine(); // Consume the newline character

	    System.out.print("Enter the search keyword or substring: ");
	    String keyword = scanner.nextLine();

	    boolean foundMatch = false;
	    for (CTransaction transaction: transactionList) {
	        String attributeValue;
	        switch (choice) {
	            case 1:
	                attributeValue = transaction.getTitle();
	                break;
	            case 2:
	                attributeValue = transaction.getAuthor();
	                break;
	            case 3:
	                attributeValue = transaction.getISBN();
	                break;
	            case 4:
	                attributeValue = transaction.getBorrower();
	                break; 
	            case 5:
	                attributeValue = transaction.getTUP_ID();
	                break;
	            case 6:
	                attributeValue = transaction.getDateBorrowed();
	                break;
	            case 7:
	                attributeValue = transaction.getDateToReturn();
	                break;
	            default:
	                attributeValue = "";
	                break;
	        }

	        if (attributeValue.toLowerCase().contains(keyword.toLowerCase())) {		//finds sa transactionList na may gabnong substring ignoring cases.
	        	System.out.println(transaction.getTitle() +"\t"+ transaction.getAuthor() +"\t"+ transaction.getISBN() +"\t"+ transaction.getBorrower() +"\t"+ transaction.getTUP_ID() +"\t"+ transaction.getDateBorrowed() +"\t"+ transaction.getDateToReturn() +"\t"+ transaction.getLibrarian());
	            foundMatch = true;
	        }
	    }

	    if (!foundMatch) {
	    	JOptionPane.showMessageDialog(null, "NO MATCHING TRANSACTION FOUND.", "Search Transaction", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
	
    //rewrites all the data in the file, not just append.
	//rewrites all the data in the file, not just append.
    public void saveTransaction() {								
        String fileName = "src//files//transactionRecords.csv";

        try {
            FileWriter writer = new FileWriter(fileName, false); // Set the second argument to 'false' to overwrite the file
            
            for (CTransaction transaction: transactionList) {
            	int index = getAccountIndex();
                String data = 
                			
                			transaction.getTitle() + "," +
                			transaction.getISBN() + "," +
                			CBorrower.borrowerList.get(index).getTUP_ID() + "," +
                			transaction.getDateBorrowed() + "," +
                			transaction.getDateToReturn() + "," +
                			transaction.getStatus() + "," +
                			CBorrower.borrowerList.get(index).getTUP_ID() + "," +
                			transaction.getAuthor() + "," +
                			transaction.getLibrarian() +"," +
                			transaction.getRefNum() + "\n" ;
                


                writer.write(data);
            }
            
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error saving borrower data: " + ex.getMessage());
        }
    }
	
	public void retrieveTransaction() {
		String fileName = "src//files//TransactionRecords.csv";
        try {
            // create file object
            File file = new File(fileName);
            try (Scanner myReader = new Scanner(file)) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    	String[] splitWords = data.split(",");
                		addTransaction(	
							splitWords[0], 
							splitWords[1], 
							splitWords[2],
							splitWords[3],
							splitWords[4],
							splitWords[5],
							splitWords[6],
							splitWords[7],	//since kinukuha niya as string, convert sa inte
							splitWords[8],
							splitWords[9]
							
                		);
                    }
            }
       }
       catch(Exception e) {
            System.out.println("An error occurred.");
       }
       saveTransaction();					//para kapag na-arrange after ng retrieve, ma-save sa excel.
	}
	
	//checks if may laman lahat ng fields.
	public boolean checkTransactionFields(String title, String ISBN, String TUP_ID, String dateBorrowed, String dateToReturn, String status, String borrower, String author,  String librarian, String refNum) {
		if(	

				title.equals("")||
				ISBN.equals("")||
				TUP_ID.equals("")||
				dateBorrowed.equals("")||
				dateToReturn.equals("")||
				status.equals("")||
				borrower.equals("")||
				author.equals("")||
				librarian.equals("")||
				refNum.equals("")
			)
			{
			return false;}
		else {
			return true;}

	}
	

    private static boolean isWithinSevenDays(String startDate, String endDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
            Date start = dateFormat.parse(startDate);
            Date end = dateFormat.parse(endDate);

            long difference = end.getTime() - start.getTime();
            long daysDifference = difference / (24 * 60 * 60 * 1000);

            return daysDifference <= 7;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
    public String generateRefNum() {
	    // Generate a random number between 100000 and 999999
	    int randomNumber = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
	    
	    // Convert the random number to a string
	    String refNum = String.valueOf(randomNumber);
	    
	    return refNum;
	}

	//END OF CLASS
}
