import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Item> menu = new ArrayList<>();
        while(sc.next().equals("add")) {
            String type = sc.next();
            if (type.equals("Burger")){
                menu.add(new Burger(sc.next(), sc.nextInt()));
            }
            else if(type.equals("Snack")){
                menu.add(new Snack(sc.next(), sc.nextInt()));
            }
            else if (type.equals("Drink")){
                menu.add(new Drink(sc.next(), sc.nextInt()));
            }
            else if (type.equals("Combo")){
                Combo comb = new Combo();
                int burger = sc.nextInt();
                int snack = sc.nextInt();
                int drink = sc.nextInt();
                try {
                    comb.addBurger(menu.get(burger));
                    comb.addSnack(menu.get(snack));
                    comb.addDrink(menu.get(drink));
                    menu.add(comb);
                }
                catch (Exception e){
                    Item.total--;
                    System.out.println("Error: Invalid combo input " + burger + " " + snack + " " + drink);
                }
            }

        }
        //I forgot the isInstance method
        for(Item item:menu){
            if (item.getType() == "Burger"){
                System.out.println(item);
            }
        }
        for (Item item:menu){
            if (item.getType() == "Snack"){
                System.out.println(item);
            }
        }
        for (Item item:menu){
            if (item.getType() == "Drink"){
                System.out.println(item);
            }
        }
        for (Item item:menu){
            if (item.getType() == "Combo"){
                System.out.println(item);
            }
        }
        ArrayList<Item> order = new ArrayList<>();
        while(true){
            try{
                order.add(menu.get(sc.nextInt()));
            }
            catch(Exception ex){
                break;
            }
        }
        int totalcost = 0;
        System.out.println("--- Order ---");
        for (Item item:order){
            totalcost += item.getCost();
            System.out.println(item);
        }
        System.out.println("Total: " + totalcost);

    }
}