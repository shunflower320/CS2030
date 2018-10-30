package cs2030.simulator;

import java.util.Comparator;

/**
 * Compares leaving time, only for customers who are going to be served.
 */

class CustomerComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        if (c1.getLeavingTime() < c2.getLeavingTime()) {
            return -1;
        } else if (c1.getLeavingTime() == c2.getLeavingTime()) {
            if (c1.getServerID() < c2.getServerID()) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}

