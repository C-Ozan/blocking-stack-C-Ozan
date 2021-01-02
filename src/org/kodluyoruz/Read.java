package org.kodluyoruz;

import java.util.Stack;
import java.util.concurrent.Semaphore;

public class Read extends Thread {

    private Stack<Integer> stack;

     Semaphore semaphore = new Semaphore(1);

    public Read(Stack<Integer> stack,Semaphore sem) {

        super("READER");
        this.stack = stack;
        this.semaphore = sem;
    }


    public void run() {

        try {
            semaphore.acquire();

            int i = 0;
            while (i < 10) {


                System.out.println(getName() + "------" + stack.get(i));
                i++;
                semaphore.release();
                sleep(100);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
