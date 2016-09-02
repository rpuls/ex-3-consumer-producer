/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonaccithreads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rasmu
 */
public class Consumer extends Thread {

    @Override
    public void run() {
        try {
            long sum = 0;
            while (Main.producerThreads.get() > 0) {
                long v = Main.s2.take();
                sum += v;
                System.out.println("new number in list " + v);
            }
            System.out.println("the total sum is " + sum);
        } catch (InterruptedException ex) {
            System.out.println("fejl i take");
        }
    }

}
