/**
 * Outputs done text and removes customer from queue.
 */

class Done{
    public static void done(Customer c){
        System.out.println(String.format("%.3f", c.getLeavingTime())+" "+c.getID()+" done serving by "+c.getServerID());
        Scheduler.customers.remove(c);
    }
}
