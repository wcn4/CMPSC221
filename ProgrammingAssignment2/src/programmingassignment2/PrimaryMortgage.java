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
    
    private final Address address;
    private double PMIMonthlyAmount;
    public PrimaryMortgage(double principle, double annualInterestRate, int months, 
            double PMIMonthlyAmount, Address address){
        super(principle, annualInterestRate, months);
        this.address = address;
        this.PMIMonthlyAmount = PMIMonthlyAmount;
        
    }
    
    public double getPMIMonthlyAmount(){
        return PMIMonthlyAmount;
    }
    
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
