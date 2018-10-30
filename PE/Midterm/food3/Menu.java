import java.util.ArrayList;

class Menu {
    private static ArrayList<Food> menu = new ArrayList<Food>();
    private static ArrayList<Food> order = new ArrayList<Food>();

    public static void add(Food food) {
        menu.add(food);
    }

    public static void addOrder(int n) {
        for (Food food: menu) {
            if (food.getID() == n) {
                order.add(food);
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
        for (Food food: order) {
            total += food.getPrice();
            System.out.println("#" + food.getID() + " " + food.getType() + ": " + food.getName() + " (" + food.getPrice() + ")");
        }
        System.out.println("Total: " + total);
    }

}
