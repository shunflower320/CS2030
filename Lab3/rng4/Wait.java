package cs2030.simulator;

/**
 * Outputs waiting text and changes status of customer, and adds waiting time to stats.
 */

class Wait extends Event {
    private Customer c;

    Wait(Customer c) {
        this.c = c;
    }

    int getID() {
        return c.getID();
    }

    double getTime() {
        return c.getArrivalTime();
    }

    void run() {
        String time = String.format("%.3f", c.getArrivalTime());
        System.out.println(time + " " + c.getID() + " waits to be served by " + c.getServerID());
        c.served();
    }
}
