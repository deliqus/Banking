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
public class BankAccount implements Comparable<BankAccount> {
    
    protected int id;
    public String owner;
    public double balance;
    protected InterestCalc ic;
    protected boolean active = true;
    
    //static String bankName = "FIO Bank";
    static String bankName;
    
    private static int accountCounter;
    
    public static int getNumberOfAccounts () {
        return accountCounter;
    }
    
    public BankAccount (String owner, double balance) {
        System.out.println("vytvarim novy ucet u banky: " + bankName);
        id = accountCounter++; // muzu z instance pristupovat na static, ale ne opacne --- i bez this
        this.owner = owner;
        this.balance = balance;
        setInterestCalc(new LooserInterestCalc());
    }
    
    public void setInterestCalc (InterestCalc ic) {
        this.ic = ic;
    }
    
    public InterestCalc getInterestCalc () {
        return ic;
    }
    
    public void setActive (boolean active) {
        this.active = active;
    }
    
    
    public int compareTo (BankAccount other) {
        //Thread.dumpStack();
        int res = (int) (this.balance - other.balance); // this neni nitne, jen pro nazornost
        System.out.println("vysledek porovnani je: " + res);
        return res;
    }
    
    public void addInterestMonthly () {
        double interest = ic.getInterest() / 12.0 * balance;
        System.out.println("interest je " + interest);
        this.balance += interest; // this nepovinny
    }
    // TODO: osetrit zaporne cislo!!!
    public void deposit (double amount) throws BankException {
        if (! active) {
            throw new BankException("Account: " + owner + " not activated yet");
        }
        balance += amount;
    }
       
    /**
     * Toto je sofistikovana metoda jak vybrat prachy
     * @param amount to prece znamena kolik chci vybrat
     * @throws InsufficientFundsException kdyz je nekdo socka
    */
    public double withdraw (double amount) throws BankException {
                
        
        if (balance - amount < 0) {
            throw new InsufficientFundsException ("Nedostatek prostredku na uctu: " + balance + " a zkusilo se vybrat: " + amount);
        }
        balance -= amount; // balance = balance - amount; // += *= /= &=
        return balance;
    }
    
    public void doTransfer (BankAccount target, double amount) throws BankException {
        
        
        withdraw(amount);
        
        
        try {
        
        target.deposit (amount);
        
        } catch (BankException be) {
            deposit(amount); // rollback> vracim prachy ktery jsem uz odepsal
            throw be;
        }
    }
    
    public String toString () {
        return "ID uctu je: " + id + "(" + accountCounter + ") " + owner + " " + balance + " Kc";
    }
    
    
}
