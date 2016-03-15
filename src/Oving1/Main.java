package Oving1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        finnPrim(0, 200);
    }
    public static void finnPrim(int start, int end){
        ArrayList<Integer> numbers = new ArrayList();
        ReentrantLock numbers_mutex =new ReentrantLock();

        int partial = (end-start)/4;
        int p1 = start + partial;
        int p2 = p1 + partial;
        int p3 = p2 + partial;

        try {
            Thread1 thread1 = new Thread1(start, p1, numbers, numbers_mutex);
            thread1.start();
            Thread1 thread2 = new Thread1(p1, p2, numbers, numbers_mutex);
            thread2.start();
            Thread1 thread3 = new Thread1(p2, p3, numbers, numbers_mutex);
            thread3.start();
            Thread1 thread4 = new Thread1(p3, end, numbers, numbers_mutex);
            thread4.start();
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.sort(numbers);
        for(Integer i : numbers){
            System.out.println(i);
        }

    }
}
class Thread1 extends Thread {
    int start, end;
    ArrayList numbers;
    ReentrantLock numbers_mutex;
    Thread1(int start, int end, ArrayList<Integer> numbers, ReentrantLock numbers_mutex) {
        this.start = start;
        this.end = end;
        this.numbers=numbers;
        this.numbers_mutex=numbers_mutex;
    }
    @Override
    public void run() {
        for(int i=start;i<end;i++) {
            if(isPrime(i)){
                numbers_mutex.lock();
                numbers.add(i);
                numbers_mutex.unlock();
            }
        }
    }
    //checks whether an int is prime or not.
    boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}