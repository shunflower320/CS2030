class Customer{
    static int ID = 0;
    double arrivalTime;
    double servedTime;
    int c_ID;
    Event status;

    Scheduler scheduler = new Scheduler();
    Server s = new Server();

    public Customer(double time){
        this.arrivalTime = time;
        this.servedTime = time;
        ID++;
        this.c_ID = ID;
        this.status = Event.ARRIVE;
    }

    public int getID(){
        return this.c_ID;
    }

    public double getArrivalTime(){
        return this.arrivalTime;
    }

    public double getServedTime(){
        return this.servedTime;
    }

    public double getLeavingTime(){
        return this.servedTime+s.serviceTime;
    }

    public Event getStatus(){
        return this.status;
    }

    public double getWaitingTime(){
        return this.servedTime - this.arrivalTime;
    }
}
