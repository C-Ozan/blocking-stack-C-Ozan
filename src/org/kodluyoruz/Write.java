package org.kodluyoruz;

import java.util.Stack;
import java.util.concurrent.Semaphore;

public class Write extends Thread {

    private Stack<Integer> stack;
    Semaphore semaphore;

    public Write(Stack<Integer> stack, Semaphore sem) {

        super("WRITER");
        this.stack = stack;
        this.semaphore = sem;

    }

    public void run() {

        for (int i = 0; i < 10; i++) {

            try {
                semaphore.acquire();

                stack.add(i);
                System.out.println(getName() + "-----" + i);

                semaphore.release();
                sleep(100);

            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }


}
