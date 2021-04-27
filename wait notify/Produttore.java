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
public class Produttore extends Thread{
    private BufWaitNot b;
    private int num=0;
    
    public Produttore(BufWaitNot buf){
    b=buf;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
                num=(int)(Math.random()*50);
                b.deposita(num);
            try{
                sleep((int)(Math.random()*50));
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    
}
