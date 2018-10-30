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
        String time = String.format("%.3f", getTime());
        System.out.println(time + " " + c.getID() + " served by " + c.getServerID());
        c.done();
    }
}
