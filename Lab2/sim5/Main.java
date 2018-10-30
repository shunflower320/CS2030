import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Scheduler scheduler = new Scheduler();
        Server s = new Server();

        while (sc.hasNextDouble()){
            double time = sc.nextDouble();
            Customer c = new Customer(time);
            scheduler.arrivals.add(c);
        }

        while (scheduler.arrivals.size()>0){
            s.run();
        }

        System.out.println(scheduler.stats());
    }
}
