import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class CBorrower {
	
	//Global variable
	public static ArrayList<CBorrower> borrowerList = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	
    private String name;
    private String TUP_ID;
    private String password;

    //Constructor
    public CBorrower(String name, String TUP_ID, String password) {
        this.name = name;
        this.TUP_ID = TUP_ID;
        this.password = password;
    }
    
    //GETTERS
    public String getName() {
        return name;
    }

    public String getTUP_ID() {
        return TUP_ID;
    }

    public String getPassword() {
        return password;
    }
    
    //SETTERS
    public void setName(String update) {
    	this.name= update;
    }
    
    public void setTUP_ID(String update) {
    	this.TUP_ID= update;
    }
    
    public void setISBN(String update) {
    	this.password= update;
    }
    
    //METHODS

    public void addBorrower(String name, String TUP_ID, String password) {
        CBorrower newBorrower = new CBorrower(name, TUP_ID, password);
        borrowerList.add(newBorrower);
        
        saveBorrower(newBorrower);
        System.out.println("Borrower added successfully!");
        System.out.println();
    }
    
    public void displayBorrower() {
	    if (borrowerList.isEmpty()) {
	        System.out.println("No books found in the catalog.");
	    } else {
	        System.out.println("Catalog:");
	        for (CBorrower borrower : borrowerList) {
	            System.out.println(borrower.getName() +"\t"+ borrower.getTUP_ID() +"\t"+ borrower.getPassword());
	        }
	    }
	}
    
    public int locateBorrower(String TUP_ID) {
	    for (int i = 0; i < borrowerList.size(); i++) {
	        CBorrower borrower = borrowerList.get(i);				//create instance of CBook, then kinuha current index
	        if (borrower.getTUP_ID().equals(TUP_ID)) {				//compare sa hinahanap
	            return i; 									// Return the index if ISBN matches
	        }
	    }
	    return -1; 											// Return -1 if book is not found
	}
    
    
    public boolean loginBorrower(String enteredID, String enteredPass) {
        for (int i = 0; i < borrowerList.size(); i++) {
            if(borrowerList.get(i).getTUP_ID().equals(enteredID) && borrowerList.get(i).getPassword().equals(enteredPass)){
               //JOptionPane.showMessageDialog(null, "Authorized Credentials", "Message", 1);
                return true;
            }
        } 
        JOptionPane.showMessageDialog(null, "Incorrect Username / Password!", "Invalid Credentials", JOptionPane.YES_NO_OPTION);
        return false;
	}

    public boolean logInAdmin(String enteredUsername, String enteredPass) {
    	
    	if (enteredUsername.equals("ADMIN") && enteredPass.equals("1234")) {		//bawal ang == sa String
    		return true;
    	} else {
    	        //JOPTIONPANE ERROR: INCORRECT PASS/ID
    		return false;
    	}
    }  
    
	public void saveBorrower(CBorrower newBorrower) {		//add the newBook in excel. //Bawal mag-add habang nakabukas ang file
		String fileName = "src//files//borrowerRecords.csv";
        
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(new File(fileName),true));
            String data = 	newBorrower.getName() + "," +
            				newBorrower.getTUP_ID() + "," +
            				newBorrower.getPassword() + "\n" ;
            
            out.append(data);
            out.close();
        } catch (FileNotFoundException ex) {}
	}
	
	public void retrieveBorrower() {
		String fileName = "src//files//borrowerRecords.csv";
        int i = 0;
                
        try {
            // create file object
            File file = new File(fileName);
            try (Scanner myReader = new Scanner(file)) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    
                    if(i != 0) {
                    	String[] splitWords = data.split(",");
                		borrowerList.add(new CBorrower(
                						splitWords[0], 
                						splitWords[1], 
                						splitWords[2]
                					)
                			);
                    	//userList.add(splitWords[8]);
                    	//passList.add(splitWords[9]);
                    }
                    
                    i++;
                }
            }
            
        }
        catch(Exception e) {
            System.out.println("An error occurred.");
        }
	}
    
}