import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class CBorrower {
	
	//Global variable
	public static ArrayList<CBorrower> borrowerList = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	
	//Attributes
    private String name, TUP_ID, password, yearSection, contactNum, email;
  
    //Constructor
    public CBorrower(String name, String TUP_ID, String password, String yearSection, String contactNum, String email) {
        this.name= name;
        this.TUP_ID= TUP_ID;
        this.password= password;
        this.yearSection= yearSection;
        this.contactNum = contactNum;
        this.email= email;
    }
    
    //GETTERS
    public String getName() {return name;}
    public String getTUP_ID() {return TUP_ID;}
    public String getPassword() {return password;}
    public String getYearSection() {return yearSection;}
    public String getContactNum() {return contactNum;}
    public String getEmail() {return email;}

    //SETTERS
    public void setName(String update) {this.name= update;}
    public void setTUP_ID(String update) {this.TUP_ID= update;}
    public void setPassword(String update) {this.password= update;}
    public void setYearSection(String update) {this.yearSection= update;}
    public void setContactNum(String update) {this.contactNum= update;}
    public void setEmail(String update) {this.email= update;}
    
    //METHODS
     
    //accepts info of borrower then add to borrowerList
    public void addBorrower(String name, String TUP_ID, String password, String yearSection, String contactNum, String email) {
    	CBorrower newBorrower = new CBorrower(name, TUP_ID, password, yearSection, contactNum, email);
        int index = 0;
        
        // Find the index kung san i-insert (alphabetically)
        for (int i = 0; i < borrowerList.size(); i++) {								//traverse sa loop
            CBorrower borrower = borrowerList.get(i);								//created object book the get current index
            if (name.compareToIgnoreCase(borrower.getName()) < 0) {					//if may nahanap na mas mababa ang newBoo,
                index = i;
                break;
            } else {
                index = i + 1;
            }
        }
        
        // Insert the new book at the determined index
        borrowerList.add(index, newBorrower);  
        saveBorrower();																//automatic mase-save kada may bagong add. 
    }
    
    //display all borrower in the borrowerList
    public void displayBorrower() {
	    if (borrowerList.isEmpty()) {
	    	JOptionPane.showMessageDialog(null, "NO ANY RECORD FOUND!", "Display Borrower", JOptionPane.ERROR_MESSAGE);
	    } else {
	        System.out.println("All Borrower:");
	        for (CBorrower borrower : borrowerList) {
	            System.out.println(borrower.getName() +"\t"+ borrower.getTUP_ID() +"\t"+ borrower.getPassword() +"\t"+ borrower.getYearSection() +"\t"+ borrower.getContactNum() +"\t"+ borrower.getEmail() );
	        }
	    }
	}
    
    //accepts TUP_ID, then finds the corresponding index of that TUP_ID in the borrowerList
    public int locateBorrower(String TUP_ID) {
	    for (int i = 0; i < borrowerList.size(); i++) {
	        CBorrower borrower = borrowerList.get(i);				//create instance of CBook, then kinuha current index
	        if (borrower.getTUP_ID().equals(TUP_ID)) {				//compare sa hinahanap
	            return i; 									// Return the index if ISBN matches
	        }
	    }
	    return -1; 											// Return -1 if book is not found
	}
    
    //compares the TUP_ID and password in the borrowerList
    public boolean loginBorrower(String enteredID, String enteredPass) {
        for (int i = 0; i < borrowerList.size(); i++) {
            if(borrowerList.get(i).getTUP_ID().equals(enteredID) && borrowerList.get(i).getPassword().equals(enteredPass)){
            	JOptionPane.showMessageDialog(null, "LOG IN SUCCESSFULLY!", "Student Log in", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } 
        JOptionPane.showMessageDialog(null, "INCORRECT TUP ID OR PASSWORD", "Student Log in", JOptionPane.ERROR_MESSAGE);
        return false;
	}

    public boolean logInAdmin(String enteredUsername, String enteredPass) {
    	
    	if (enteredUsername.equals("ADMIN") && enteredPass.equals("1234")) {		//bawal ang == sa String
    		JOptionPane.showMessageDialog(null, "LOG IN SUCCESSFULLY!", "Admin Log in", JOptionPane.INFORMATION_MESSAGE);
    		return true;
    	} else {
    		JOptionPane.showMessageDialog(null, "INCORRECT TUP ID OR PASSWORD", "Admin Log in", JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    }  
    //rewrites the arrayList borrowerList in the borrowerRecords.csv
    //rewrites all the data in the file, not just append.
    public void saveBorrower() {								
        String fileName = "src//files//borrowerRecords.csv";

        try {
            FileWriter writer = new FileWriter(fileName, false); // Set the second argument to 'false' to overwrite the file
            
            for (CBorrower borrower : borrowerList) {
                String data = borrower.getName() + "," +
                              borrower.getTUP_ID() + "," +
                              borrower.getPassword() + "," +
				              borrower.getYearSection() + "," +
				              borrower.getContactNum() + "," +
				              borrower.getEmail() + "\n";
                writer.write(data);
            }
            
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error saving borrower data: " + ex.getMessage());
        }
    }

    //scans the borrowerRecords.csv then add each row in the borrowerList
	public void retrieveBorrower() {
		String fileName = "src//files//borrowerRecords.csv";
                
        try {
            // create file object
            File file = new File(fileName);
            try (Scanner myReader = new Scanner(file)) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    	String[] splitWords = data.split(",");
                		addBorrower(
							splitWords[0], 
							splitWords[1], 
							splitWords[2],
							splitWords[3], 
							splitWords[4], 
							splitWords[5]
                			
                		);
                    }
            }
       }
       catch(Exception e) {
            System.out.println("An error occurred.");
       }
       saveBorrower();					//para kapag na-arrange after ng retrieve, ma-save sa excel.
	}
}
