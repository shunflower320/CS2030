/**
 * Contains current customer (cc) and next customer (nc), if there is a waiting customer.
 * Labelled by ID, with customisable service time.
 * Decides what to do with customer based on his status.
 * Sets customer's served time and leaving time, updates cc and nc.
 */

class Server{
    static int ID = 0;
    static double serviceTime = 1;

    private String status;
    Customer cc;
    Customer nc;
    private int s_ID;

    public Server(){
        ID++;
        s_ID = ID; //fixed
    }

    public int getID(){
        return s_ID;
    }

    public boolean no_cc(){
        return cc==null;
    }

    /**
     * This function is only to be used when the server is already serving a customer.
     * If cc is null, the scheduler can directly schedule the customer to be served. Complication only arises when there is no idle server, so scheduelr needs to check if any server has room to decide whether the customer waits immediately, or wait at the same time as cc's leaving is processed and nc is served, or simply pushed to the back to the queue because there is no coincidence of action.
     */

    public boolean canServe(Customer c){
        if (nc==null){
            return true;
        } else {
            return c.getArrivalTime()>=nc.getServedTime();
        }
    }

    /**
     * If customer's status is ARRIVE, he is a new customer, and since he made it here, he is either to be served or can be dealt with later.
     * To be dealt with later, he either waits immediately or just remains in the queue (because even if there is coincidence of action, nc will be served before he is scheduled to wait here). Waiting immediately only occurs when nc is null.
     * For WAIT customers, they were nc, and now they are cc, hence the update. nc is then set to be null so that new customers (if any) can take the spot of nc.
     * For DONE customers, they were served, and they will be removed after their action is printed. cc will then be null. If nc exists, he is brought brought forward as cc just in case my code screws up and a new customer appears as "priority" and is served before nc. If nc does not exist, cc and nc will still be null, and server will be idle afterwards.
     */

    public void decide(Customer c){
        Event status = c.getStatus();
        switch(status){
            case ARRIVE:
                if (cc==null){
                    Arrive.arrive(c);
                    c.setServer(this);
                    Serve.serve(c);
                    cc = c;
                } else if (nc==null) {
                    c.setServer(this);
                    Arrive.arrive(c);
                    nc = c;
                    nc.servedTime = cc.getLeavingTime();
                    Wait.wait(c);
                }
                break;
            
            case WAIT:
                cc = nc;
                nc = null;
                Serve.serve(c);
                break;

            case DONE:
                cc = nc; //bring forward to prevent newly arrived cust from being served as cc immediately
                Done.done(c);
                break;
            }
    }
}
