package cs2030.simulator;

/**
 * Customer class attaches ID, arrival time, served time (if any) and leaving time to a Customer.
 * It communicates with the ServerManager to see if it returns a (available) server.
 * If the server can serve, customer creates arrive event, sends it to the scheduler.
 * If customer can be served immediately, it calls serve(c) in server.
 * This would mean that there is either no cc, or that the cc is leaving.
 * If not, customer creates wait event, and sends it to scheduler.
 * When wait even is run, it will trigger serve(cc) in server.
 */

public class Customer {
    static int ID = 0;
    private double arrivalTime;
    private double servedTime;
    private int cID;
    private Server server;
    private double serviceTime;

    Customer(double arrivalTime) { //removed this.server line
        this.arrivalTime = arrivalTime;
        this.servedTime = arrivalTime;
        this.serviceTime = 0;
        ID++;
        this.cID = ID;
    }

    void setServiceTime(double time) {
        this.serviceTime = time;
    }

    void setServedTime(double time) {
        this.servedTime = time;
    }

    Server getServer() {
        return this.server;
    }

    void setServer(Server s) {
        this.server = s;
    }

    int getID() {
        return this.cID;
    }

    int getServerID() {
        return server.getID();
    }

    double getArrivalTime() {
        return this.arrivalTime;
    }

    double getServedTime() {
        return this.servedTime;
    }

    double getLeavingTime() {
        if (server == null) {
            return this.arrivalTime;
        } else {
            return this.servedTime + this.serviceTime;
        }
    }

    double getWaitingTime() {
        return this.servedTime - this.arrivalTime;
    }

    void arrives() {
        Arrive arrive = new Arrive(this);
        Scheduler.events.add(arrive);
    }

    /**
     * Calls server to change cc to this, adds Serve Event to Scheduler and adds waiting time.
     */

    void served() {
        Serve serve = new Serve(this);
        Scheduler.events.add(serve);
        server.serve(this);
        Scheduler.totalServed++;
        Scheduler.totalWT += getWaitingTime();
    }

    /*
    void immediateServe() {
        //arrives();
        servedTime = arrivalTime;
        ServiceManager.customers.remove(this);
        server.serve(this);
    }
    */

    /**
     * Adds Wait Event to Scheduler.
     * Server will change customer's served time.
     */

    void waits() {
        Wait wait = new Wait(this);
        Scheduler.events.add(wait);
        server.wait(this);
    }

    /**
     * Adds Done Event to Scheduler and generates service time.
     */

    void done() {
        double service = ServiceManager.rg.genServiceTime();
        this.serviceTime = service;
        Done done = new Done(this);
        Scheduler.events.add(done);
        //server.done(this);
    }

    void leaves() {
        Leave leave = new Leave(this);
        Scheduler.events.add(leave);
    }
}
