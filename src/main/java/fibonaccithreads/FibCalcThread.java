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
public class FibCalcThread extends Thread {

    @Override
    public void run() {
        try {
            Long value;
            while (null != (value = Main.s1.poll())) {
                long f = fib(value);
                Main.s2.put(f);
            }
            Main.producerThreads.getAndDecrement();
        } catch (InterruptedException ex) {
            System.out.println("fejl i put");
        }
        

    }

    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

}
