package cs2030.simulator;

class Leave extends Event {
    private Customer cust;
    
    Leave(Customer cust) {
        this.cust = cust;
    }

    double getTime() {
        return cust.getLeavingTime();
    }

    int getID() {
        return cust.getID();
    }

    void run() {
        double time = getTime();
        System.out.println(String.format("%.3f", time) + " " + getID() + " leaves");
    }
}

