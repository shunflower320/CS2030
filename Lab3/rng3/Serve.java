package cs2030.simulator;

class Serve extends Event {
    private Customer c;

    Serve(Customer c) {
        this.c = c;
    }

    int getID() {
        return c.getID();
    }

    double getTime() {
        return c.getServedTime();
    }

    void run() {
        System.out.println(String.format("%.3f", c.getServedTime())+" "+c.getID()+" served by "+c.getServerID());
    }
}
