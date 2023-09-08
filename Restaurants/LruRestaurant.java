package Restaurants;

public class LruRestaurant extends RestaurantAlgorithm {

    public LruRestaurant(int numOfTables) {
        super(numOfTables, "LRU");
    }

    @Override
    protected void addCustomer(Integer customerNum) {
        if (customerIsPresent(customerNum)) {
            deleteCustomerFromArray(customerNum);
            addCustomerToArray(customerNum);
        } else {
            if (tablesAreFull()) {
                deleteCustomerFromArray(0);
                addCustomerToArray(customerNum);
            }
            else{
                addCustomerToArray(customerNum);
            }
        }
    }
}
