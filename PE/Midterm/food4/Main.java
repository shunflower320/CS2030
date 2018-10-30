import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ID = 0;

        //changed
        while(sc.next().equals("add")) {
            String type = sc.next();
            if (type.equals("Combo")) {
                //take in all numbers following combo
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = 0; i < 3; i++) { //changed to for loop
                    list.add(sc.nextInt());
                }
                Combo combo = new Combo(ID);
                for (int i: list) {
                    combo.add(i);
                }
                Menu.addCombo(combo);
                ID++;
                //all combo inputs done
                //sc.next() is "add"
            } else {
                String name = sc.next();
                int price = sc.nextInt();
                Food food = new Food(ID, type, name, price);
                Menu.add(food);
                ID++;
                //still in while loop
            }
        }

        while (sc.hasNext()) {
            Menu.addOrder(sc.nextInt());
        }


        Menu.printMenu();
        System.out.println("--- Order ---");
        Menu.printOrder();
    }
}
