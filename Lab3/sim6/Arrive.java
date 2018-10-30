/**
 * Outputs arrival text.
 */

class Arrive{    
    public static void arrive(Customer c){
        System.out.println(String.format("%.3f", c.getArrivalTime())+" "+c.getID()+" arrives");
    }
}
