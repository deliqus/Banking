/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banking;

/**
 *
 * @author Michael
 */
public class OverdraftAccount extends BankAccount {
    
    /**
     * o kolik se muze jit do minusu
     */
    protected final double overdraft = 5000 ;
    

    public OverdraftAccount(String owner) {
        super(owner, 0);
        //overdraft = 5000;
    }
    
    public OverdraftAccount(String owner, double amount) {
        super(owner, amount);
    }
    
     public double withdraw (double amount) throws InsufficientFundsException {
                
        
        if (balance + overdraft - amount < 0) {
            throw new InsufficientFundsException("Precerpan kontokorent");
        }
        balance -= amount; // balance = balance - amount; // += *= /= &=
        return balance;
    }
    
}
