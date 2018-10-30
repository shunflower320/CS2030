/**
 * Customer class attaches ID, arrival time, served time (if any) and leaving time to a Customer.
 * It also outputs customer leaving if no server is available.
 */

class Customer{
    static int ID = 0;
    private double arrivalTime;
    double servedTime;
    private int c_ID;
    private Event status;
    private Server server;

    public Customer(double time){
        this.arrivalTime = time;
        this.servedTime = time;
        ID++;
        this.c_ID = ID;
        this.status = Event.ARRIVE;
        this.server = null;
    }

    public boolean hasServer(){
        return server!=null;
    }

    public Server getServer(){
        return this.server;
    }

    public void setServer(Server s){
        this.server = s;
    }

    public int getID(){
        return this.c_ID;
    }

    public int getServerID(){
        return server.getID();
    }

    public double getArrivalTime(){
        return this.arrivalTime;
    }

    public double getServedTime(){
        return this.servedTime;
    }

    public double getLeavingTime(){
        return this.servedTime+Server.serviceTime;
    }

    public Event getStatus(){
        return this.status;
    }

    public void setStatus(Event status){
        this.status = status;
    }

    public double getWaitingTime(){
        return this.servedTime - this.arrivalTime;
    }

    public void leave(){
        System.out.println(String.format("%.3f", getArrivalTime())+" "+getID()+" leaves");
    }
}
