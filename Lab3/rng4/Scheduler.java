package cs2030.simulator;

import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * Contains a queue and calls events in queue to run until queue empty.
 * Once queue empty, all customers done.
 * Each event calls other events, until the customer leaves.
 * Outputs stats.
 */

public class Scheduler {
    static int totalLeft = 0;
    static int totalServed = 0;
    static double totalWT = 0;
    static Comparator<Event> comparator = new EventComparator();
    static PriorityQueue<Event> events = new PriorityQueue<Event>(comparator);

    /**
     * Takes out the earliest event to be processed, and runs it.
     */

    public static void run() {
        while (events.size() > 0) {
            Event e = events.poll();
            e.run();
        }
    }

    public static void stats() {
        String ave = String.format("%.3f", totalWT / totalServed);
        System.out.println("[" + ave + " " + totalServed + " " + totalLeft + "]");
    }
}
