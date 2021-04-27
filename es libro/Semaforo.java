/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodconsem;

/**
 *
 * @author michele2306
 */
public class Semaforo {
    int valore;
    public Semaforo(int V){
    valore=V;
    }
    synchronized public void P(){
    while(valore==0){
    try{
    wait();
    }
    catch(InterruptedException e){
    e.getMessage();
    }
    }
    valore--;
    }
    synchronized public void V(){
    valore++;
    notify();
    }
}
