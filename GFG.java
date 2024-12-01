import java.io.*;
class MyThread extends Thread {
    public void run()
    {
        for (int i = 0; i < 10; i++) {
            System.out.println(
                "Thread " + Thread.currentThread().getId()
                + ": " + i);
        }
    }

    public void run2()
    {
        for (int i = 0; i < 10; i++) {
            System.out.println(
                "Thread " + Thread.currentThread().getId()
                + ": " + i*i);
        }
    }
}
public class GFG {
    public static void main(String[] args)
    {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        // Start the threads
        thread1.start();
        thread2.run2();;
    }
}