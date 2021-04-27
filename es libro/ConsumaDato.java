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
public class ConsumaDato extends Thread{
    Semaforo pieno;
    Semaforo vuoto;
    int a;
    public ConsumaDato(Semaforo s1, Semaforo s2){
    pieno=s1;
    vuoto=s2;
    }

    @Override
    public void run() {
        while(true){
        pieno.P();
        a= ProdConSem.buffer;
        System.out.println("Lettore: dato letto "+a);
        vuoto.V();
        }
    }
    
}
