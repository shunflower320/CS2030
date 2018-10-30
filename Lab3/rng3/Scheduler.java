package cs2030.simulator;

import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * Contains a queue and calls events in queue to run until queue empty.
 * Outputs stats.
 */

public class Scheduler {
    static int totalLeft = 0;
    static int totalServed = 0;
    static double totalWT = 0;
    static Comparator<Event> comparator = new EventComparator();
    static PriorityQueue<Event> events = new PriorityQueue<Event>(100, comparator);

    
    public void run() {
        while (events.size()>0) {
            Event e = events.poll();
            e.run();
        }
    }

    public void stats() {
        System.out.println("["+String.format("%.3f", totalWT/totalServed)+" "+totalServed+" "+totalLeft+"]");
    }
}
