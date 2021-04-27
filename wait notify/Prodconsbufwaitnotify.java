/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodconsbufwaitnotify;

/**
 *
 * @author michele2306
 */
public class Prodconsbufwaitnotify {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufWaitNot buff= new BufWaitNot();
        
        Produttore a= new Produttore(buff);
        Consumatore b= new Consumatore(buff);
        a.start();
        b.start();
    }
    
}
