package cs2030.simulator;

/**
 * Event is an indiviudal event that has its "status" and time.
 * Individual events are queued, and once called, print msg.
 */

public abstract class Event {
    private Customer cust;

    abstract void run();

    abstract int getID();

    abstract double getTime();
}

