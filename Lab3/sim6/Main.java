/**
 * Takes in inputs to create Customers to be passed to Scheduler.
 * Starts scheduler and outputs stats.
 */

import java.util.Scanner;
import java.util.ArrayList;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Scheduler scheduler = new Scheduler();

        int n = sc.nextInt();
        scheduler.createServers(n);

        while (sc.hasNextDouble()){
            double time = sc.nextDouble();
            Customer c = new Customer(time);
            Scheduler.customers.add(c);
        }

        scheduler.run();

        scheduler.stats();
    }
}
