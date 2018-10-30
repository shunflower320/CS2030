package cs2030.simulator;

/**
 * Outputs done text and removes customer from queue.
 */

class Done extends Event {
    private Customer c;

    Done(Customer c) {
        this.c = c;
    }

    int getID() {
        return c.getID();
    }

    double getTime() {
        return c.getLeavingTime();
    }

    void run() {
        String time = String.format("%.3f", c.getLeavingTime());
        System.out.println(time + " " + c.getID() + " done serving by " + c.getServerID());
        c.getServer().done(c);
    }
}
