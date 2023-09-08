package Restaurants;

public class FifoRestaurant extends RestaurantAlgorithm {

    public FifoRestaurant(int numOfTables) {
        super(numOfTables, "FIFO");
    }

    @Override
    protected void addCustomer(Integer customerNum) {
        if (tablesAreFull()) {
            deleteCustomerFromArray(0);
            addCustomerToArray(customerNum);
        }
        else{
            addCustomerToArray(customerNum);
        }
    }
}
