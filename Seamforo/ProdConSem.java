/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;
import java.util.concurrent.Semaphore;
/**
 *
 * @author michele2306
 */
public class ProdConSem {
    private static Semaphore SemVuoto= new Semaphore(1);
    private static Semaphore SemPieno= new Semaphore(0);
    private static int buffer=0;
    
    static class Produttore extends Thread{

    @Override
    public void run() {
        
       while(true){
           try{
         SemVuoto.acquire();
         buffer++;
         System.out.println("Prodotto "+buffer);
         SemPieno.release();
           }catch(InterruptedException e){
           System.out.println(e.getMessage());
           }
       }
    }
 
 
 
 }
     static class Consumatore extends Thread{

    @Override
    public void run() {
        int a=0;
       while(true){
           try{
         SemPieno.acquire();
         a=buffer;
         System.out.println("Consumato "+a);
         SemVuoto.release();
           }catch(InterruptedException e){
           System.out.println(e.getMessage());
           }
       }
    }
 
 
 
 }
   public static void main(String[] args) throws InterruptedException {
       long a=2;
        Produttore Produttore = new Produttore();
        Produttore.start();
        Consumatore Consumatore=new Consumatore();
        Consumatore.start();
        Produttore.join(a);
        Consumatore.join(a);
    }
      
    
    
}

