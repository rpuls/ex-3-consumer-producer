/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonaccithreads;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author rasmu
 */
public class Main {

    public static ArrayBlockingQueue<Long> s1 = new ArrayBlockingQueue<>(100);
    public static ArrayBlockingQueue<Long> s2 = new ArrayBlockingQueue<>(100);
    public static AtomicInteger producerThreads = new AtomicInteger(4);

    public static void main(String[] args) throws InterruptedException {
        long[] values = {4, 5, 8, 12, 21, 22, 34, 35, 36, 37, 42};
        ArrayList<FibCalcThread> producers = new ArrayList<>();

        for (long i : values) {
            s1.put(i);
        }

        for (int i = 0; i < producerThreads.get(); i++) {
            FibCalcThread p = new FibCalcThread();
            p.start();
            producers.add(p);
        }
        
        Consumer con = new Consumer();
        con.start();
        con.join();
        
        for(FibCalcThread p : producers){
            p.join();
        }
        
    }

}
