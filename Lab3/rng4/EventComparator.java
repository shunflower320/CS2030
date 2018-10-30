package cs2030.simulator;

import java.util.Comparator;

/**
 * Compares event times.
 */

class  EventComparator implements Comparator<Event> {
    @Override
    public int compare(Event e1, Event e2) {
        if (e1.getTime() < e2.getTime()) {
            return -1;
        } else if (e1.getTime() == e2.getTime()) {
            if (e1.getID() < e2.getID()) {
                return -1;
            } else if (e1.getID() == e2.getID()) {
                if (e1 instanceof Arrive) {
                    return -1;
                } else if (e2 instanceof Arrive) {
                    return 1;
                } else if (e1 instanceof Wait) {
                    return -1;
                } else if (e2 instanceof Wait) {
                    return 1;
                } else if (e1 instanceof Serve) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
