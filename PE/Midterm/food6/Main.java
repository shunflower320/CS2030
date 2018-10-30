import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int id = 0;

        //changed
        while (sc.next().equals("add")) {
            String type = sc.next();
            if (type.equals("Combo")) {
                
                ArrayList<Food> menu = Menu.getMenu();

                int one = sc.nextInt();   
                int two = sc.nextInt();
                int three = sc.nextInt();

                
                Food burger = null;
                Food snack = null;
                Food drink = null;
                

                for (Food food: menu) {
                    if (food.getid() == one & food.getType().equals("Burger")) {
                        burger = food;
                    } else if (food.getid() == two & food.getType().equals("Snack")) {
                        snack = food;
                    } else if (food.getid() == three & food.getType().equals("Drink")) {
                        drink = food;
                    }
                }

                if (burger != null & snack != null & drink != null) {
                    Combo combo = new Combo(id, "Combo", "Combo", 0);
                    combo.add(burger);
                    combo.add(snack);
                    combo.add(drink);
                    Menu.addCombo(combo);
                    id++;
                } else {
                    System.out.println("Error: Invalid combo input " 
                            + one + " " + two + " " + three);
                }

                //all combo inputs done
                //sc.next() is "add"
            } else {
                String name = sc.next();
                int price = sc.nextInt();
                Food food = new Food(id, type, name, price);
                Menu.add(food);
                id++;
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
