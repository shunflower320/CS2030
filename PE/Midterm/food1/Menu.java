import java.util.ArrayList;

class Menu {
    private static ArrayList<Food> menu = new ArrayList<Food>();

    public static void add(Food food) {
        menu.add(food);
    }

    public static void print() {
        for (Food food: menu) {
            System.out.println("#" + food.getID() + " " + food.getType() + ": " + food.getName() + " (" + food.getPrice() + ")");
        }
    }

}
