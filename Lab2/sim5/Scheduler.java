import java.util.LinkedList;

class Scheduler{
    static LinkedList<Customer> arrivals = new LinkedList<Customer>();
    //static LinkedList<String> events = new LinkedList<String>();
    static double totalWT = 0;
    static int totalServed = 0;
    static int totalLeft = 0;
    static int totalEvents = 100;

    public Scheduler(){
    }

    public String stats(){
        return "["+String.format("%.3f", totalWT/totalServed)+" "+totalServed+" "+totalLeft+"]";
    }

    /*public void print(){
        for (String string: events){
            System.out.println(string);
        }
        System.out.println(stats());
    }*/
}
