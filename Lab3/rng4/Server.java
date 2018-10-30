package cs2030.simulator;

/**
 * Contains current customer (cc) and next customer (nc), if there is a waiting customer.
 * Does not know about events.
 * Labelled by ID, with customisable service time.
 * Sets customer's served time and leaving time, updates cc and nc.
 */

class Server {
    static int ID = 0;
 
    private Customer cc;
    private Customer nc;
    private int sID;

    Server() {
        ID++;
        sID = ID; //fixed
    }

    int getID() {
        return sID;
    }

    Customer getCC() {
        return cc;
    }

    Customer getNC() {
        return nc;
    }

    void serve(Customer c) {
        this.cc = c; //does work
    }

    void wait(Customer c) {
        this.nc = c;
        nc.setServedTime(cc.getLeavingTime());
    }
    
    void done(Customer c) {
        cc = nc;
        nc = null;
    }
    
}

