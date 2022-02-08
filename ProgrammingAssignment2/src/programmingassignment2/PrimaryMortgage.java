/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingassignment2;

/**
 *
 * @author Yoshi
 */
public class PrimaryMortgage extends LoanAccount {
    
    //Primary Mortgage address does not change
    private final Address address;
    
    //Assuming PMIMonthlyAmount is fixed for now, can be changed later
    private final double PMIMonthlyAmount;
    
    //Creates a Primary Mortgage by creating a LoanAccount and then defines properties
    // PMIMonthlyAmount and the address of the primary Mortgage
    public PrimaryMortgage(double principle, double annualInterestRate, int months, 
            double PMIMonthlyAmount, Address address){
        super(principle, annualInterestRate, months);
        this.address = address;
        this.PMIMonthlyAmount = PMIMonthlyAmount;
        
    }
    
    //Getter function for the PMIMonthlyAmount
    public double getPMIMonthlyAmount(){
        return PMIMonthlyAmount;
    }
    
    //Getter function for property Address
    public Address getAddress(){
        
        return address;
    }
    
    
    @Override
    public String toString(){
        return String.format("Primary Mortgage Loan with:%n"
                + "%sPMI Monthly Amount: $%.2f%n%s%n", 
                super.toString(), this.getPMIMonthlyAmount(), this.getAddress().toString());
    }
    
}
