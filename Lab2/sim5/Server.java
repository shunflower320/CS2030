import java.util.LinkedList; //there's double-adding!!!!

class Server{
    static double serviceTime = 1.0;
    static Customer cc;
    static Customer nc;
    Scheduler scheduler;

    public Server(){
        scheduler = new Scheduler();
    }

    public void serve(Customer c){
        String output_serve = String.format("%.3f", c.getServedTime())+" "+c.getID()+" served";
        System.out.println(output_serve);
        

        cc = c;
        cc.status = Event.DONE;
        scheduler.arrivals.add(cc);
        scheduler.arrivals.removeFirst();

        //System.out.println("first customer is now: "+scheduler.arrivals.get(0).getID()); //shld be new cust

        scheduler.totalServed++;
        
        //run();
    }

    public void arrive(Customer c){
        String output_arr = String.format("%.3f", c.getArrivalTime())+" "+c.getID()+" arrives";
        System.out.println(output_arr);
    }

    public void wait(Customer c){
        String output_wait = String.format("%.3f", c.getArrivalTime())+" "+c.getID()+" waits";
        System.out.println(output_wait);

        nc = c;
        c.status = Event.WAIT;
        nc.servedTime = cc.getLeavingTime();
        scheduler.totalWT+=nc.getWaitingTime();

        scheduler.arrivals.add(nc);
        scheduler.arrivals.removeFirst();
        //System.out.println("the first customer is now: "+scheduler.arrivals.get(0).getID()); //shld be new cust
    }

    public void arrival(Customer c){
        if (cc==null){
            arrive(c); //returning cust dont come here
            serve(c);
        } else {
            if (nc==null){
                //System.out.println("current customer is: "+cc.getID());
                if (c.getArrivalTime()<cc.getLeavingTime()){
                    arrive(c);
                    wait(c);
                } else {
                    scheduler.arrivals.addFirst(cc);
                    scheduler.arrivals.removeLast(); //since this person comes after cc is served, then cc gets done before this person's arrival msg
                    //System.out.println("is first customer == cc? "+cc.getID()==scheduler.arrivals.get(0).getID()); //shld return true
                }
            } else {
                if (c.getArrivalTime()<nc.getServedTime()){
                    arrive(c);
                    String output_leave = String.format("%.3f", c.getArrivalTime())+" "+c.getID()+" leaves";
                    System.out.println(output_leave);
                    scheduler.totalLeft++;

                    scheduler.arrivals.removeFirst();
                    //System.out.println("c.getArrivalTime is "+c.getArrivalTime());
                    //System.out.println("nc.getServedTime is "+nc.getServedTime());
                    //System.out.println("first customer is now another new customer: "+scheduler.arrivals.get(0).getID());
                    
                } else {
                    scheduler.arrivals.addFirst(nc);
                    scheduler.arrivals.addFirst(cc);
                    scheduler.arrivals.removeLast();
                    scheduler.arrivals.removeLast();
                    //System.out.println("is first customer == cc? "+cc.getID()==scheduler.arrivals.get(0).getID()); //shld return true
                    //System.out.println("is second customer == nc? "+nc.getID()==scheduler.arrivals.get(1).getID()); //shld return true
                }
            }
        }

        //run();
    }

    public void done(Customer c){ //take care of last cust
        String output_done = String.format("%.3f", c.getLeavingTime())+" "+c.getID()+" done";
        System.out.println(output_done);

        scheduler.arrivals.removeFirst();
        cc = null;

        //System.out.println("the first customer now should be nc, and will become cc "+nc.getID()==scheduler.arrivals.get(0).getID());
        //System.out.println(scheduler.arrivals.size());//sth wrong here

        //run();

    }

    public void run(){
        Customer c = scheduler.arrivals.get(0);
        //System.out.println("first cust in queue is: "+c.getID());
        Event event = c.getStatus();
        switch(event){
            case ARRIVE:
                arrival(c);
                break;

            case WAIT:
                nc = null;
                //System.out.println("current customer is: "+cc);
                serve(c);
                break;

            case DONE:
                //System.out.println("next customer is: "+nc.getID());
                done(c);
                break;
        }
    }
}
