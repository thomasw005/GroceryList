import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> groceryList = new ArrayList<>();

        loop: while (true) {
            System.out.print("""
                    Available actions:
                    
                    0 - to shutdown
                    
                    1 - to add item(s) to list (comma-delimited list)
                    
                    2 - to remove any items (comma-delimited list)
                    
                    Enter a number for which action you want to do:""" + " ");

            switch (Integer.parseInt(input.nextLine())) {
                default -> {
                    break loop;
                }
                case 1 -> addItems(groceryList);
                case 2 -> removeItems(groceryList);

            }

            groceryList.sort(Comparator.naturalOrder());
            System.out.println(groceryList);
        }
    }

    // Add items to ArrayList.
    private static void addItems(ArrayList<String> groceryList) {
        // Separate each item into an item in an array.
        System.out.println("Add item(s) [separate items by comma]:");
        String[] items = input.nextLine().split(",");

        // Trim whitespace and add unique items to the list.
        for (String item : items) {
            String trimmedItem = item.trim();
            if (trimmedItem.isEmpty()) {
                continue;
            }
            if (!groceryList.contains(trimmedItem)) {
                groceryList.add(trimmedItem);
            }
        }
    }

    // Remove items from ArrayList.
    private static void removeItems(ArrayList<String> groceryList) {
        // Separate each item into an item in an array.
        System.out.println("Remove item(s) [separate items by comma]:");
        String[] items = input.nextLine().split(",");

        // Trim whitespace and remove items from the list.
        for (String item : items) {
            String trimmedItem = item.trim();
            if (trimmedItem.isEmpty()) {
                continue;
            }
            groceryList.remove(trimmedItem);
        }
    }
}