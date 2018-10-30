package cs2030.simulator;

/**
 * Outputs arrival text.
 */

class Arrive extends Event {
    private Customer c;

    Arrive(Customer c) {
        this.c = c;
    }

    int getID() {
        return c.getID();
    }

    double getTime() {
        return c.getArrivalTime();
    }
    
    void run() {
        double time = c.getArrivalTime();
        System.out.println(String.format("%.3f", time) + " " + getID() + " arrives");
    }
}
