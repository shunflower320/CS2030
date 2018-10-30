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

    void run(){
        System.out.println(String.format("%.3f", c.getLeavingTime())+" "+c.getID()+" done serving by "+c.getServerID());
        ServiceManager.customers.remove(c);
    }
}
