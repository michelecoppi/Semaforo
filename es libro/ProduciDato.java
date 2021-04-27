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
public class ProduciDato extends Thread{
    Semaforo pieno;
    Semaforo vuoto;
    int tanti=5;
    final int attesa=600;
    public ProduciDato(Semaforo s1, Semaforo s2){
    pieno=s1;
    vuoto=s2;
    }

    @Override
    public void run() {
        for (int k = 0; k < tanti; k++) {
        vuoto.P();
        ProdConSem.buffer=k;
            System.out.println("Scrittore: dato scritto: "+k);
            pieno.V();
            try{
                Thread.sleep(attesa);
            }catch(Exception E){
            
            }
        }
        System.out.println("Scrittore: termine scrittura dati.");
    }
    
    
}
