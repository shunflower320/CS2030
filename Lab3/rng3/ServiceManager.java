package cs2030.simulator;

import java.util.ArrayList;

/** Contains an array of servers to check for availability.
 * Iterates through the customer queue until empty.
 * Sends customers to servers.
 */

public class ServiceManager {
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    static ArrayList<Server> servers = new ArrayList<Server>();

    Scheduler scheduler = new Scheduler();

    /**
     * Update empty list of servers with actual servers based on number of servers provided.
     * @param n number of servers.
     */

    public void createServers(int n) {
        for (int i = 0; i < n; i++) {
            servers.add(new Server());
        }
    }

    void findServer(Customer cust) {
            for (Server server: servers) {
                if (server.cc == null) {
                    cust.setServer(server);
                    cust.immediateServe();
                    break;
                } else if (server.cc.getLeavingTime() <= cust.getArrivalTime()) {
                    server.cc.done();
                    break;
                } else if (server == servers.get(servers.size() - 1)) { //no idle server, no cc leaving
                    for (Server s: servers) {
                        if (s.nc == null) {
                            cust.setServer(s);
                            cust.waits();
                            break;
                        } else if (s == servers.get(servers.size() - 1)) {
                            cust.arrives();
                            cust.leaves();
                            customers.remove(cust);
                            Scheduler.totalLeft++;
                            break;
                        }
                    }
                }
            }
    }

    public void run() {
        while (!customers.isEmpty()) {
            findServer(customers.get(0));
        }

        for (Server s: servers) {
            while (s.cc!=null) {
                s.cc.done();
            }
        }
    }
}
