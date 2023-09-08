package Restaurants;

import java.util.ArrayList;

public abstract class RestaurantAlgorithm {
    protected final int numOfTables;
    private int pageFaults = 0;
    private ArrayList<Integer> currentCustomers;
    public final String className;

    public RestaurantAlgorithm(int numOfTables, String className) {
        this.numOfTables = numOfTables;
        this.className = className;
        currentCustomers = new ArrayList<>();
    }

    public void newCustomer(int customerNum) {
        if (!customerIsPresent(customerNum)) {
            pageFaults++;
        }
        addCustomer(customerNum);
    }

    protected void addCustomerToArray(int customerNum) {
        currentCustomers.add(customerNum);
    }

    protected void addCustomerToArray(int customerNum, int index) {
        currentCustomers.add(index, customerNum);
    }


    protected boolean customerIsPresent(int customerNum) {
        return currentCustomers.contains(customerNum);
    }

    protected void deleteCustomerFromArray(int index) {
        currentCustomers.remove(index);
    }

    protected Integer deleteCustomerFromArray(Integer customerNum) {
        currentCustomers.remove(customerNum);
        return customerNum;
    }

    protected void replaceCustomer(int index, Integer customerNum) {
        currentCustomers.set(index, customerNum);
    }

    protected boolean tablesAreFull() {
        return currentCustomers.size() == numOfTables;
    }

    protected int tableNumOfCustomer(Integer customerNum) {
        return currentCustomers.indexOf(customerNum);
    }

    protected Integer customerOnTable(int tableNum) {
        try {
            return currentCustomers.get(tableNum);
        } catch (Exception e) {
            return null;
        }
    }


    protected abstract void addCustomer(Integer customerNum);

        public String tablesString() {
        String output = "";
        for (int i = 0; i < numOfTables; i++) {
            if (i >= currentCustomers.size()) {
                output += " _ ";
            } else {
                output += " " + currentCustomers.get(i) + " ";
            }
        }
        return output;
    }

    public int getPageFaults() {
        return pageFaults;
    }

    @Override
    public String toString() {
        return getClass().toString() + " Page Faults : " + pageFaults;
    }
}
