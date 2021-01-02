package org.kodluyoruz;

import java.util.Stack;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();
        Semaphore semaphore = new Semaphore(1);


        Write w1 = new Write(stack,semaphore);
        Read r1 = new Read(stack,semaphore);


        w1.start();
        r1.start();




    }
}
