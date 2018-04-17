/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banking;

import java.io.*;

/**
 *
 * @author Michael
 */

class A {
    A(String s) {
        System.out.println("volam konstruktor A s parametrem: " + s);
    }
    
    A () {
        this ("Ahoj"); // vola jiny konstruktor stejne tridy
    }
}

/**
 * Ukazka navrhoveho vzoru singleton - chci zajistit aby v cele aplikaci existovala maximalne jedna instance 
 * @author Michael
 */
public class Bank {
    
    private static Bank instance;
    
    public static Bank getInstance () {
        if (instance == null) {
            
           instance = new Bank ();
        }
        return instance;
    }
    
    private Bank () {
        System.out.println("vytvarim instanci");
    }
    
    public static void delejNeco () {
        
    }
    
    public static void delejDFoo () {
            
    }
}
