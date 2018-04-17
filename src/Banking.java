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
public class Banking {

    public static void main(String[] args) throws BankException{

        BankAccount.bankName = "mBank";
        System.out.println(BankAccount.getNumberOfAccounts());

        TreeSet clients = new TreeSet<BankAccount>(new BankAccountComparator());
        //TreeSet clients = new TreeSet<BankAccount> ();
        BankAccount ba = null;

        BankAccount chudacek;
        BankAccount babis;
        BankAccount vopicka;

        ba = new BankAccount("Novak", 10000);
        clients.add(ba);
        ba = vopicka = new BankAccount("Vopicka", 11000);
        clients.add(ba);
        ba = chudacek = new OverdraftAccount("Chudacek", 50);
        clients.add(ba);
        ba = babis = new BankAccount("Babis", 5000000);
        ba.setInterestCalc(new VIPInterestCalc());
        clients.add(ba);
        //clients.add("AAAAAAA");

        for (Iterator<BankAccount> it = clients.iterator(); it.hasNext();) {
            ba = it.next();
            //String owner = ba.owner;
            //double balance = ba.balance;

            System.out.println(ba.owner + " " + ba.balance + " a ma urok: "
                    + ba.getInterestCalc().getInterest());

            ba.addInterestMonthly();

            System.out.println(ba.owner + " " + ba.balance + " a ma urok: "
                    + ba.getInterestCalc().getInterest());

        }

        //int bbb = 0b101010;
        //int bbb = 0xA1;
        //System.out.println(bbb);
        //System.out.println(Integer.toBinaryString(bbb));
        //System.out.println(Integer.toHexString(bbb));

        // tady jako urednik v bankce do GUI napsal kolik vybrat penez

        //chudacek.withdraw(1000); // tady neni kod ze ktereho muze vyjimka vyskocit kontrolovany

        //chudacek.withdraw(1000);

        try {
            chudacek.withdraw(1000);
            System.out.println(chudacek.owner + " " + chudacek.balance + " a ma urok: "
                    + chudacek.getInterestCalc().getInterest());


        } catch (InsufficientFundsException e) {
            // tady by se udelala akce 1
            System.out.println("Akce 1");
            System.out.println(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.out.println("Akce IAE");
            System.out.println(e.getMessage());
            // tady by v jako mu vyskocil dialog ze tam chudacek ma malo penez
        }

        try {
            babis.setActive(false);
            chudacek.doTransfer(ba, 0.3);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (BankException e) {
            System.out.println("tady");
            System.out.println(e.getMessage());
        }


        //chudacek.bankName = "CSOB";


        System.out.println(vopicka.toString()); // toString neni nutne
        System.out.println(babis);
        System.out.println(chudacek);
        System.out.println(chudacek.getNumberOfAccounts ());

        System.out.println("******************");

        Bank bank = Bank.getInstance();
        System.out.println(bank);
        bank = Bank.getInstance();
        System.out.println(bank);
        bank = Bank.getInstance();
        System.out.println(bank);

        System.out.println("******************");

        Bank2 bank21 = new Bank2 ();
        Bank2 bank22 = new Bank2 (); // predek
        bank22.nejakaStatickaMetoda ();

        System.out.println("******************");
        Bank2 bank3 = new Bank3 (); // potomek
        bank3.nejakaStatickaMetoda (); // volam statickou metodu pres promennou

        Bank3.nejakaStatickaMetoda (); //volam statickou metodu pres nazev tridy

        bank22.nestatickaMetoda();
        bank3.nestatickaMetoda();



    }

}
