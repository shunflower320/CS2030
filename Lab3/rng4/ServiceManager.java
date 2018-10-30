package cs2030.simulator;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

/** Contains an array of servers to check for availability.
 * Sends customers to servers.
 * Add customers to customers list.
 * Contains a list of customers to be done, generated and called when a new customer comes.
 * They have to be of the same leaving time.
 */

public class ServiceManager {
    private static ArrayList<Server> servers = new ArrayList<Server>();
    static RandomGenerator rg;

    Scheduler scheduler = new Scheduler();

    /**
     * Creates a RandomGenerator.
     */
    
    public static void createRG(int seed, double lambda, double mu) {
        rg = new RandomGenerator(seed, lambda, mu);
    }

    /**
     * Update empty list of servers with actual servers based on number of servers provided.
     * @param n number of servers.
     */

    public static void createServers(int n) {
        for (int i = 0; i < n; i++) {
            servers.add(new Server());
        }
    }

    static ArrayList<Server> getServers() {
        return ServiceManager.servers;
    }

    /**
     * Creates customers and adds Arrive Events to Scheduler.
     * @param num number of customers.
     */

    public static void getCustomers(int num) {
        Customer cust = new Customer(0.0);
        cust.arrives();
        double time = 0.0;
        for (int i = 0; i < num - 1; i++) {
            time += rg.genInterArrivalTime();
            Customer c = new Customer(time);
            c.arrives();
        }
    }
}
