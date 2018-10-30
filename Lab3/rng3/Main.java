/**
 * Takes in number of servers and arrival times of customers, creating them and putting them into a list.
 */

import java.util.Scanner;
import java.util.ArrayList;
import cs2030.simulator.Scheduler;
import cs2030.simulator.ServiceManager;
import cs2030.simulator.Customer;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ServiceManager sm = new ServiceManager();
        Scheduler scheduler = new Scheduler();

        int seed = sc.nextInt();

        int n = sc.nextInt();
        sm.createServers(n);

        int num = Math.max(100, sc.nextInt());

        double arrivalRate = sc.nextDouble();
        double serviceRate = sc.nextDouble();

        Customer c = new Customer(0, 1.0);
        sm.customers.add(c);

        double time = 0;

        RandomGenerator rg = new RandomGenerator(seed, arrivalRate, serviceRate);

        while (num>0){
            time += rg.genInterArrivalTime();
            Customer cust = new Customer(time, serviceRate);
            sm.customers.add(cust);
            num--;
        }

        sm.run();
        scheduler.run();
        scheduler.stats();
    }
}
