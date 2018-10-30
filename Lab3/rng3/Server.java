package cs2030.simulator;

/**
 * Contains current customer (cc) and next customer (nc), if there is a waiting customer.
 * Does not know about events.
 * Labelled by ID, with customisable service time.
 * Sets customer's served time and leaving time, updates cc and nc.
 */

class Server {
    static int ID = 0;

    private String status;
    Customer cc;
    Customer nc;
    private int sID;

    Server() {
        ID++;
        sID = ID; //fixed
    }

    int getID() {
        return sID;
    }

    void serve(Customer c) {
        cc = c;
        c.served();
        Scheduler.totalServed++;
    }

    void wait(Customer c) {
        nc = c;
    }

    void done(Customer c) {
        if (nc!=null) {
            nc.servedTime = cc.getLeavingTime();
            serve(nc);
        }
        cc = nc;
        nc = null;
    }
    
}

