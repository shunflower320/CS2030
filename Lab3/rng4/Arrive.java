package cs2030.simulator;

import java.util.ArrayList;

/**
 * Outputs arrival text and creates serve/ wait/ leave event.
 */

class Arrive extends Event {
    private Customer c;

    Arrive(Customer c) {
        this.c = c;
    }

    int getID() {
        return c.getID();
    }

    double getTime() {
        return c.getArrivalTime();
    }

    /**
     * Outputs arrival text, and checks for available server.
     * If server has no cc, then customer can be served immediately.
     * If server has no nc, then customer waits.
     * Else, customer leaves.
     */
    
    void run() {
        System.out.println(String.format("%.3f", getTime()) + " " + getID() + " arrives");
        ArrayList<Server> servers = ServiceManager.getServers();
 
        for (Server server: servers) {
            if (server.getCC() == null) {
                c.setServer(server);
                c.served();
                break;
            } else if (server == servers.get(servers.size() - 1)) {
                for (Server s: servers) {
                    if (s.getNC() == null) {
                        c.setServer(s);
                        c.waits();
                        break;
                    } else if (s == servers.get(servers.size() - 1)) {
                        c.leaves();
                        Scheduler.totalLeft++;
                        break;
                    }
                }
            }
        }
    }
}
