import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ID = 0;

        while(sc.next().equals("add")) {
            String type = sc.next();
            String name = sc.next();
            int price = sc.nextInt();
            Food food = new Food(ID, type, name, price);
            Menu.add(food);
            ID++;
        }

        while (sc.hasNext()) {
            Menu.addOrder(sc.nextInt());
        }


        Menu.printMenu();
        System.out.println("--- Order ---");
        Menu.printOrder();
    }
}
