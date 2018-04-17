/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banking;

import java.util.*;

/**
 *
 * @author Michael
 */
public class BankAccountComparator implements Comparator {
    
    public int compare (Object o1, Object o2) {
        BankAccount ba1 = (BankAccount) o1;
        BankAccount ba2 = (BankAccount) o2;
       // System.out.println("vola se BankAccountComparator na objektech: " + o1 +
        //        "a    " + o2);
        //Thread.dumpStack();
         int res = (int) (ba1.balance - ba2.balance);
         System.out.println("vysledek porovnani je: " + res);
         return res;
    }
}
