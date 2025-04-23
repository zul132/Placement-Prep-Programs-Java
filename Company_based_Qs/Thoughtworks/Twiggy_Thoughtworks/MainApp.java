/* 
    Twiggy - Food Delivery App for a Restaurant 
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    private String itemCode;
    private String itemName;
    private Integer cost;

    Item(String itemCode, String itemName, Integer cost) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.cost = cost;
    }

    public String getItemCode() {
        return itemCode;
    }

    public Integer getCost() {
        return cost;
    }
}

class Restaurant {
    String restCode;
    String restName;
    private Integer serviceCharge;
    private Integer orderAmountThreshold;
    List<Item> menuItems = new ArrayList<Item>();

    Restaurant(String restCode, String restName) {
        this.restCode = restCode;
        this.restName = restName;
    }

    void addMenuItem(Item menuItem) {
        menuItems.add(menuItem);
    }

    public Integer getServiceCharge() {
        return serviceCharge;
    }

    public Integer getOrderAmountThreshold() {
        return orderAmountThreshold;
    }

}

public class MainApp {
    public static void main(String[] args) {
        Restaurant r1 = new Restaurant("R001", "Restaurant A");
        Restaurant r2 = new Restaurant("R002", "Restaurant B");

        r1.addMenuItem(new Item("A001", "Fried Rice", 220));
        r1.addMenuItem(new Item("A002", "Hakka Noodles", 200));
        r1.addMenuItem(new Item("A003", "Cold Coffee", 100));
        r1.addMenuItem(new Item("A004", "Fresh Juice", 80));

        Scanner sc = new Scanner(System.in);
        String[] inputItems = sc.nextLine().split(", ");
        Integer totalCost = 0;
        Boolean itemFlag = true;

        for (String itemCode : inputItems) {
            // System.out.println(itemCode);
            itemFlag = false;

            for (Item menuItem : r1.menuItems) { // checking if the Item Code found in menu
                if (menuItem.getItemCode().equals(itemCode)) {
                    totalCost += menuItem.getCost(); // adding item's cost to total cost
                    itemFlag = true;
                }
            }

            if (!itemFlag) {
                break;
            }
        }

        if (itemFlag) { // if Item Codes are found
            if (totalCost < 300) { // if the amount is less than Rs. 300, then add a Service charge of Rs. 50
                totalCost += 50;
            }

            System.out.println(totalCost);
        } else {
            System.out.println("Incorrect Code: Item Not available in the restaurant\r\n");
        }

        sc.close();
    }
}