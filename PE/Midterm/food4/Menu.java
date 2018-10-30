import java.util.ArrayList;

class Menu {
    private static ArrayList<Food> menu = new ArrayList<Food>();
    private static ArrayList<Order> order = new ArrayList<Order>();
    private static ArrayList<Combo> combo = new ArrayList<Combo>();

    static ArrayList<Food> getMenu() {
        return menu;
    }

    public static void addCombo(Combo c) { //changed name of item
        combo.add(c);
    }
    
    public static void add(Food food) {
        menu.add(food);
    }

    public static void addOrder(int n) {
        for (Food food: menu) {
            if (food.getID() == n) {
                order.add(food);
            } else {
                for (Combo c: combo) {
                    if (c.getID() == n) {
                        order.add(c); //changed
                        return; //changed
                    }
                }
            }
        }
    }

    static void orderedPrint (ArrayList<Food> list) {
        for (Food food: list) {
            if (food.getType().equals("Burger")) {
                System.out.println("#" + food.getID() + " " + food.getType() + ": " + food.getName() + " (" + food.getPrice() + ")");
            }
        }

        for (Food food: list) {
            if (food.getType().equals("Snack")) {
                System.out.println("#" + food.getID() + " " + food.getType() + ": " + food.getName() + " (" + food.getPrice() + ")");
             }
        }

        for (Food food: list) {
            if (food.getType().equals("Drink")) {
                System.out.println("#" + food.getID() + " " + food.getType() + ": " + food.getName() + " (" + food.getPrice() + ")");
             }
        }
    }

    public static void printMenu() {
        orderedPrint(menu);
    }

    public static void printOrder() {
        int total = 0;
        for (Order o: order) {
            if (o instanceof Food) {
                Food food = (Food) o; //changed, typecasting
                total += food.getPrice();
                System.out.println("#" + food.getID() + " " + food.getType() + ": " + food.getName() + " (" + food.getPrice() + ")");
            } else if (o instanceof Combo) { //this part changed
                Combo c = (Combo) o; //changed, typecasting
                System.out.println("#" + c.getID() + " " + "Combo " + "(" + c.getPrice() + ")"); //added
                for (Food food: c.getComboFood()) { //changed
                    System.out.println("   #" + food.getID() + " " + food.getType() + ": " + food.getName() + " (" + food.getPrice() + ")");
                }
                total += c.getPrice(); //added
            }
        }
        System.out.println("Total: " + total);
    }

}
