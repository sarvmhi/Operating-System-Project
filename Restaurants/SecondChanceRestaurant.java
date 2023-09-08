package Restaurants;

import java.util.HashSet;

public class SecondChanceRestaurant extends RestaurantAlgorithm {
    private HashSet<Integer> hasSecondChances;
    private int pointer = 0;

    public SecondChanceRestaurant(int numOfTables) {
        super(numOfTables, "SecondChance");
        hasSecondChances = new HashSet<>();
    }

    @Override
    protected void addCustomer(Integer customerNum) {
        if (customerIsPresent(customerNum)) {
            hasSecondChances.add(customerNum);
        } else {
            if (customerOnTable(pointer) == null) {
                addCustomerToArray(customerNum);
                pointerToNext();
            } else {
                while (hasSecondChances.contains(customerOnTable(pointer))) {
                    pointerToNext();
                }
                replaceCustomer(pointer, customerNum);
            }
        }
    }

    private void pointerToNext() {
        pointer++;
        if (pointer >= numOfTables) {
            pointer = 0;
        }
    }
}
