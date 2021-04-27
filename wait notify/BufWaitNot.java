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
public class BufWaitNot {
    private static int valore;
    private boolean pieno=false;
    
    public synchronized int preleva(){
    while(pieno==false){
    try{
        wait();
        
    }
    catch(InterruptedException e){
    System.out.println(e.getMessage());
    }
    }
    pieno=false;
    notify();
    System.out.println("Consuma "+valore);
    return valore;
    }
    
    public synchronized void deposita (int value){
    while(pieno){
    try{
    wait();
    }catch(InterruptedException e){
    System.out.println(e.getMessage());
    }
    
    }
    pieno=true;
    valore=value;
    notify();
    System.out.println("Produce "+valore);
    }
}
