
package programmingassignment1;

public class ProgrammingAssignment1 {


    public static void main(String[] args) {
        LoanAccount loan1 = new LoanAccount(5000);
        LoanAccount loan2 = new LoanAccount(31000);
        
        double interestRates[] = {0.01, 0.05};
        
        for (double interest : interestRates){
            LoanAccount.setAnnualInterestRate(interest);
            System.out.printf("Monthly payments for loan1 of $%.2f and loan2 $%.2f", loan1.getPrinciple(), loan2.getPrinciple());
            System.out.printf(" for 3, 5, and 6 year loans at %d%% interest. %n", (int)(100*interest));
            System.out.printf("Loan\t3 years\t5 years\t6 years \n");
            System.out.printf("Loan1\t%.2f\t%.2f\t%.2f \n", 
                loan1.calculateMonthlyPayment(36), 
                loan1.calculateMonthlyPayment(60),
                loan1.calculateMonthlyPayment(72));
            System.out.printf("Loan2\t%.2f\t%.2f\t%.2f \n", 
                loan2.calculateMonthlyPayment(36), 
                loan2.calculateMonthlyPayment(60),
                loan2.calculateMonthlyPayment(72));
            System.out.println();
        }
       
    }
    
}
