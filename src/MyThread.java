public class MyThread implements Runnable {
    Thread thread;
    TickTock tickTock;

    public MyThread(String name, TickTock tickTock) {
        this.thread = new Thread(this, name);
        this.tickTock = tickTock;
    }

    public static MyThread createAndStart(String name, TickTock tickTock) {
        MyThread myThread = new MyThread(name, tickTock);
        myThread.thread.start();
        return myThread;
    }


    /**
     * Inside the run( ) method of MyThread, ifthe name of the thread is "Tick",
     * then calls to tick( ) are made. If the name of the thread is "Tock",
     * then the tock( ) method is called.
     * Five calls that pass true as an argument are made to each method.
     * The clock runs as long as true is passed. A final
     * call that passes false to each method stops the clock.
     */

    @Override
    public void run() {
        if (thread.getName().compareTo("Tick") == 0) {
            for (int i = 0; i < 500; i++)
                tickTock.tick(true);

            tickTock.tick(false);
        } else {
            for (int i = 0; i < 500; i++)
                tickTock.tock(true);
            tickTock.tock(false);
        }
    }
}