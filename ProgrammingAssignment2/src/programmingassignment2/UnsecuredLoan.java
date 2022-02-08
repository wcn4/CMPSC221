/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingassignment2;

/**
 *
 * @author Yoshi
 */
public class UnsecuredLoan extends LoanAccount{
    
    //Creates an Unsecured Loan by creating a Loan Account
    public UnsecuredLoan(double principle, double annualInterestRate, int months){
        super(principle, annualInterestRate, months);
    }
    
    @Override
    public String toString(){
        return String.format("Unsecured Loan with:%n%s", super.toString());
    }
}
