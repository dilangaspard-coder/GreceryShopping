import java.util.Scanner;


class Item {
        String name;
        float price;
        int quantity;
        int morality;

        Item (String name, float price, int quantity, int morality){
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.morality = morality;
        }
    }

public class GreceryShopping {

//Method to search for the place of an item in the list of items
    public static void Search ( Item [] item, String name ){

        System.out.println("Search the place of the item.");

        for (int i = 0; i < item.length; ++i) {
        if (name.equalsIgnoreCase(item[i].name)) {
            System.out.println ("The item '" + name + "' is at index: " + i);
            System.out.println(i);
        }
    }
    
}

//Method to calculate the average price of the items in the list of prices
    public static void AveragePrice (Item [] item){ 
        float sum = 0.00f;
        for (int i = 0; i < item.length;++i){
            sum += item[i].price;
        }
        float average = sum / (float)item.length;
        System.out.println("The average price of the items is: " + average);   
}

//Method to put a maximum price affordable for the user and to show the items that are under this price
    public static float MaxPrice ( Item [] item, Scanner input){
        System.out.println("What is the maximum price you can afford?");
        float maxPrice = input.nextFloat ();
        input.nextLine(); // to consume the newline character after reading the float input ?? A Comprendre, j'ai pas full capté
        System.out.println("The items that are under the price of " + maxPrice + " are: ");
        for (int i = 0; i < item.length; ++i){
            if (item [i].price <= maxPrice){
                System.out.println(item[i].name);
            }
        }
        return maxPrice;
    }

    public static void List (Item [] item){
        System.out.println("The items in store are: ");
        System.out.println("");
        for (int i = 0; i < item.length; ++i){
            System.out.println(item[i].name);
            
        }
        System.out.println("");
    }

    

// Main 
    public static void main(String s []){

    //INTERFACE 
    System.out.println("");
    System.out.println("");
    System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
    System.out.println("");
    System.out.println("                                                  - GRECERY SHOPPING -                                              ");
    System.out.println("");
    System.out.println("");
    System.out.println("WELCOME TO THE GRECERY SHOPPING, the best place to buy whatever you want...Yeahhh really wathever... You weirdo!");
    System.out.println("");
    System.out.println("");
    System.out.println("Here, you can choose between 6 options: name of article, search, average, maxPrice, bill or list.");
    System.out.println("");
    System.out.println("I recommande you to start with 'list' or 'maxPrice' if you're broke to let you see all the items we have in store.");
    System.out.println("");
    System.out.println("You can also write 'Finish' if you don't want to buy anything or if you want to leave... OH you will leave, don't worry HAHA");
    System.out.println("");
    System.out.println("");
    System.out.println("Have Fun!!");
    System.out.println("");
    System.out.println("");
    System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
    System.out.println("");
     System.out.println("");

        Item [] item = new Item [15];
        item [0] = new Item ("Bread", 1.50f, 10,1);
        item [1] = new Item ("shark", 250.00f, 4, -1);
        item [2] = new Item ("red fish", 0.20f, 100, 0);
        item [3] = new Item ("BigMac", 8.00f, 15, 2);
        item [4] = new Item ("iphone", 999.99f, 3, -1);
        item [5] = new Item ("goat", 49.00f, 1, 0);
        item [6] = new Item ("knife", 9.99f, 10, 1);
        item [7] = new Item ("gun", 500.00f, 4, 3);
        item [8] = new Item ("girl", 2000.00f, 1, 10);
        item [9] = new Item ("boy", 2000.00f,1,9);
        item [10] = new Item ("old racist", 50.00f, 1, 8);
        item [12] = new Item ("blood", 10.00f, 50, 1);
        item [13] = new Item ("salad", 3.50f, 25, -1);
        item [14] = new Item ("toilet paper", 0.80f, 50, 0);     

        int maxMorality = 50;
        int currentMorality = 0;
        Scanner input = new Scanner (System.in);
        boolean x = true;

        while (x == true){


        boolean y = true;
        float totalBill = 0;
        float maxPrice = 1000000.00f;
        

        while (y == true){

            boolean condition = true;
            System.out.println ("Choose: article, search, average, maxPrice or bill, please. If you don't want any or wanna go, write 'Finish'.");
            String choice = input.nextLine();
            int index = -1; 

        // Finish et donc a la fin du programme
            if (choice.equalsIgnoreCase ("Finish")){
                System.out.printf("Thanks, your total bill is: %.2f coins. Bye.%n", totalBill); // Genre y a pas plus facile et propre comme façon d'arrondir les float ???
                System.out.println ("Now Paye or Die motherfucker!! HAHAHA");
                System.out.println ("");
                System.out.println ("");
                System.out.println ("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
                y = false;
                break;
            }
        // Search Method
            else if (choice.equalsIgnoreCase("Search")){
                System.out.println("What item do you want to search for?");
                String name = input.nextLine();
                Search(item, name);
                continue; // pas sûr des 2 dernières lignes 
            }

            else if (choice.equalsIgnoreCase("List")){
                List(item);
                continue;
            }
        // Average Price Method
            else if (choice.equalsIgnoreCase("Average")){
                AveragePrice(item);
                continue;
            }

        // Max Price Method
            else if (choice.equalsIgnoreCase("MaxPrice")){
                 maxPrice = MaxPrice(item, input);
                continue;
            }

        // Bill Method
            else if (choice.equalsIgnoreCase("Bill")){
                System.out.printf("Your current bill is: %.2f coins.%n", totalBill);
            }

        // Article Method
            else {
            for (int i = 0; i < item.length && condition == true; ++i){
                
                if (choice.equalsIgnoreCase(item[i].name)){

    //DIALOG
                    if (item[i].name.equalsIgnoreCase("knife")){
                        System.out.println("Mmmh, I hope it's not for killing...");
                        System.out.println ("");
                    }
                    if (item[i].name.equalsIgnoreCase("gun")){
                        System.out.println("You look like someone whom I shouldn't give that to...");
                        System.out.println ("");
                    }
                    if (item[i].name.equalsIgnoreCase("girl")){
                        System.out.println("WTF DUDE, WHAT THE FUCKING HELL, You're a fcking kreep, you should be ashamed of yourself!!");
                        System.out.println ("");
                    }
                    if (item[i].name.equalsIgnoreCase("boy")){
                        System.out.println("I don't even wanna ask anything about that, you're just a sicko!!");
                        System.out.println ("");
                    }
                    if (item[i].name.equalsIgnoreCase("old racist")){
                        System.out.println("You know, he's still a human being, even this kind yep...");
                        System.out.println ("");
                    }
                    if (item[i].name.equalsIgnoreCase("blood")){
                        System.out.println("I hope you won't suck mine in my sleep HAHAHA");
                        System.out.println ("");
                    }
                    if (item[i].name.equalsIgnoreCase("salad")){
                        System.out.println("Fresh and healthy choice! Good boy.");
                        System.out.println ("");
                    }
                    if (item[i].name.equalsIgnoreCase("bigmac")){
                        System.out.println("Big Mac, the classic choice! BUT IT'S FAST FOOD, IDIOT!!");
                        System.out.println ("");
                    }
                    if (item[i].name.equalsIgnoreCase("goat")){
                        System.out.println("You're the GOAAAAAT!! No kidding, you're not GOTAGAAAAA.");
                        System.out.println ("");
                    }
                    if (item[i].name.equalsIgnoreCase("red fish")){
                        System.out.println("Who cares about those, really?..");
                        System.out.println ("");
                    }
                    if (item[i].name.equalsIgnoreCase("shark")){
                        System.out.println("Shark, the king of the sea! You're a real warrior bro! GG");
                        System.out.println ("");
                    }
                    if (item[i].name.equalsIgnoreCase("bread")){
                        System.out.println("Bread... You know this shit ended up killing some kings... Be careful with it");
                        System.out.println ("");
                    }
//DIALOG

                    if (item [i].price <= maxPrice && item[i].quantity > 0 && item[i].morality <= maxMorality){
                        System.out.println("Your item is taken");
                    index = i;
                    totalBill += item [i].price;
                    item[i].quantity -= 1;
                    currentMorality += item[i].morality;
                    condition = true;
                    break;
                    }

                    else if (item [i].quantity <= 0){
                        System.out.println("You're pissing me off!! Choose an other one.");
                        condition = false;
                        break;
                    }

                    else if (item [i].morality > maxMorality){
                        System.out.println("You reached too much immorality, you're desgusting me!! Choose something else.");
                        condition = false;
                        break;
                    }

                    else if (item [i].price > maxPrice){
                        System.out.println("Your item is too expensive, you can't take it. Please choose an other one.");
                        condition = false;
                        break;
                    }
                    
                }
                
                
                else if (i == (item.length - 1) && index == -1 && !choice.equalsIgnoreCase("Finish")){
                    throw new RuntimeException("Item '" + choice + "' not found, please try again.");
                }
                
            }
            }
        }

    // Exit Method
        System.out.println("Do you want to leave the place? Press 'Exit'");
         String word = input.nextLine();
            if (word.equalsIgnoreCase("Exit")){
                x = false;
                break;
            }
            
        }   
        
    }

}

