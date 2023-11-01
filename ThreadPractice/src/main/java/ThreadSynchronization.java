class Print {
    synchronized public void printMsg(String msg) {
        for (int i = 0; i < 5; i++) {
            System.out.println(msg);
            try {
                // making the current thread sleep for 1000 milliseconds
                Thread.sleep(1000);
            } catch (Exception exception) {

            }
        }
    }
}

class Thread1 extends Thread {
    Print p;

    Thread1(Print p) {
        this.p = p;
    }

    public void run() {
        p.printMsg("Thread 1");
    }
}

class Thread2 extends Thread {
    Print p;

    Thread2(Print p) {
        this.p = p;
    }

    public void run() {
        p.printMsg("Thread 2");
    }
}


public class ThreadSynchronization {

    public static void main(String[] args) {
        Print p = new Print();
        Thread1 thread1 = new Thread1(p);
        Thread2 thread2 = new Thread2(p);

        thread1.start();
        thread2.start();
    }

}
