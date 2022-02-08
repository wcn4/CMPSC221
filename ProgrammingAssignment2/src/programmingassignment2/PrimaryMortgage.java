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
            Address address, double PMIMonthlyAmount){
        super(principle, annualInterestRate, months);
        this.address = address;
        this.PMIMonthlyAmount = PMIMonthlyAmount;
        
    }
    
}
