/**
 * Outputs waiting text and changes status of customer, and adds waiting time to stats.
 */

class Wait{
    public static void wait(Customer c){
        System.out.println(String.format("%.3f", c.getArrivalTime())+" "+c.getID()+" waits to be served by "+c.getServerID());
        c.setStatus(Event.WAIT);
        Scheduler.totalWT+=c.getWaitingTime();
    }
}
