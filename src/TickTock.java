public class TickTock {
    String state; //contains the state of the clock

    synchronized void tick(boolean running) {
        if (!running) {
            state = "ticked";
            notify();
            return;
        }

        System.out.println("Tick");
        state = "ticked";  //set the current state to ticked
        notify(); //let tock() run. tick() notifies tock()
        try {
            while (!state.equals("tocked"))
                wait(); //wait for tock to complete . tick() waits for tock()
        } catch (InterruptedException exc) {
            System.out.println("Thread Interrupted.");
        }
    }

    synchronized void tock(boolean running) {
        if (!running) {//stop the clock
            state = "tocked";
            notify();
            return;
        }
        System.out.println("Tock");
        state = "tocked"; //ste the current state to tocked
        notify(); //let tick() run . tock() notifies tick()
        try {
            while (!state.equals("ticked"))
                wait(); //wait for tick to complete . tock() waits for tick()
        } catch (InterruptedException exc) {
            System.out.println("Thread Interrupted.");

        }
    }
}