package programmingassignment3;
import java.util.*;
public class Customer {
    
    //The following three properties are 
    //assumed to be final
    private final String firstName;
    private final String lastName; 
    private final String SSN;
    //Stores all the loans that the customer owns
    private ArrayList<LoanAccount> loanAccounts;
    
    public Customer(String firstName, String lastName, String SSN){
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        loanAccounts = new ArrayList<LoanAccount>();
    }
    
    //Getter function for firstName
    public String getFirstName() {
        return firstName;
    }
    
    //Getter function for lastName
    public String getLastName() {
        return lastName;
    }

    
    //Getter function for SSN
    public String getSSN() {
        return SSN;
    }
    
    //Function to add new loan account to Customer Class
    public void addLoanAccount(LoanAccount account){
        loanAccounts.add(account);
    }
    
    //Despite the name printMonthlyReport, it will return a string instead to
    //make it work with the main method. I'm unsure if we are allowed to change
    //the main method code
    public String printMonthlyReport(){
        String message = String.format("Account Report for Customer: %s %s with SSN %s\n\n", 
                firstName, lastName, SSN);
        for (LoanAccount loan:loanAccounts){
            message = message + loan;
        }
        return message;
    }
}
