class Serve{
    public static void serve(Customer c){
        System.out.println(String.format("%.3f", c.getServedTime())+" "+c.getID()+" served by "+c.getServerID());
        c.setStatus(Event.DONE);
        Scheduler.customers.remove(c); //c is removed from the front
        Scheduler.customers.add(c); //add to back
        Scheduler.totalServed++;
    }
}
