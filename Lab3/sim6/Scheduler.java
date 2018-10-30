import java.util.ArrayList;

/**
 * Contains a queue and calls server to run the prioritised event in queue until queue empty.
 * Contains an array of servers, checking each on of them to see if they are available for service.
 * Also iterates through queue to see which event out to be processed first, depending on the event time, based on status of customer.
 * Outputs stats.
 */

class Scheduler{
    static int totalLeft = 0;
    static int totalServed = 0;
    static double totalWT = 0;
    static ArrayList<Server> servers = new ArrayList<Server>();
    static ArrayList<Customer> customers = new ArrayList<Customer>();

    /**
     * Update empty list of servers with actual servers based on number of servers provided.
     * @param n number of servers.
     */

    public void createServers(int n){
        for (int i=0; i<n; i++){
            servers.add(new Server());
        }
    }

    /**
     * Customers are to be prioritised in chronological order of their next action, which differs based on status.
     * @param c customer whose time of concern is to be found.
     * @return time of concern.
     */

    public double getTimeOfConcern(Customer c){
        Event status = c.getStatus();
        double time = 0;
        switch(status){
            case ARRIVE:
                time = c.getArrivalTime();
                break;

            case WAIT:
                time = c.getServedTime();
                break;

            case DONE:
                time = c.getLeavingTime();
                break;
        }
        return time;
    }

    /**
     * Customers only prioritised if their time of concern is before everyone else's, or if they are the same, then the one with smaller ID is prioritised.
     * @return the customer to be prioritised.
     */

    public Customer priority(){
        Customer p = customers.get(0);
        for (Customer c: customers){
            if (getTimeOfConcern(c)<getTimeOfConcern(p)){
                p = c;
            } else if (getTimeOfConcern(c)==getTimeOfConcern(p)){
                if (c.getID()<p.getID()){
                    p = c;
                }
            }

        }
        return p;
    }

    /**
     * After selecting the prioritised customer, check if he is alr at a server, if yes, send him to his server; if not, find an available server.
     * Nested loops needed because regardless of whether there is an idle server, the customers will loop through all servers once first. Only if no idle server does he loop all servers again. There is no way to loop twice separately, as the customer who is already sent to an idle server will break out of first loop only to be in the second loop again, unless I check for status, which I was erm lazy to do. I'm sorry.
     * If no available server, he leaves.
     */

    public void run(){
        while (customers.size()>0){
            Customer cust = priority();
            
            if (cust.hasServer()){ //if customer is alr waiting/ served
                cust.getServer().decide(cust);
            } else {
                for (Server server: servers){
                    if (server.no_cc()){
                        server.decide(cust);
                        break;
                    } else if (server==servers.get(servers.size()-1)){ //no idle server, no cc leaving
                        for (Server s: servers){
                            if (s.canServe(cust)){ //no nc, or cc leaving
                                s.decide(cust);
                                break;
                            } else if (s==servers.get(servers.size()-1)){
                                Arrive.arrive(cust); 
                                cust.leave(); //since he came before anyone is done
                                customers.remove(cust);
                                totalLeft++;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void stats(){
        System.out.println("["+String.format("%.3f", totalWT/totalServed)+" "+totalServed+" "+totalLeft+"]");
    }
}
