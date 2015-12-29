/**
 * Created by donghoon on 2015. 12. 29..
 */
public class ThreadExcer {

    public static void main(String[] args) {
        ThreadExcer ex = new ThreadExcer();
        ex.someMethod();
    }

    private void someMethod() {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                doSomethingBackground();
            }
        }, "Background Thread");

        System.out.println("Start");
        backgroundThread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " is counting " + i);
        }
        System.out.println("Done");
    }

    private void doSomethingBackground() {
        System.out.println(Thread.currentThread().getName() + " is Running in the background.");
    }
}
