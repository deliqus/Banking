/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banking;


class X {
    public int cislo = 5;
    public X () {
        System.out.println("vytvarim X");
    }
}
/**
 *
 * @author Michael
 */
 class Bank2 {
 
    static X x = new X();
    
    static void nejakaStatickaMetoda () {
        System.out.println("nejakaMetoda z Bank2");   
        
    }
    
    void nestatickaMetoda () {
        System.out.println("nestaticka metoda z Predka tj. z Bank 2");    
    }
    
    void ffooo () {
        
    }
}

class Bank3 extends Bank2 {
    static void nejakaStatickaMetoda () {
        System.out.println("nejakaMetoda z Bank3");   
    }
    
        void nestatickaMetoda () {
        System.out.println("nestaticka metoda z Potomka tj. z Bank3");    
    }

}
