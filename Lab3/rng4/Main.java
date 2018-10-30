/**
 * Takes in number of servers and arrival times of customers.
 * Max 1000 customers, hence take minimum for num.
 * ServiceManager creates RG and customers.
 */
import java.util.Scanner;
import java.util.ArrayList;
import cs2030.simulator.Scheduler;
import cs2030.simulator.ServiceManager;
import cs2030.simulator.Customer;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int seed = sc.nextInt();

        int n = sc.nextInt();
        ServiceManager.createServers(n);

        int num = Math.min(1000, sc.nextInt());

        double arrivalRate = sc.nextDouble();
        double serviceRate = sc.nextDouble();

        ServiceManager.createRG(seed, arrivalRate, serviceRate);
        ServiceManager.getCustomers(num);

        Scheduler.run();
        Scheduler.stats();
    }
}
