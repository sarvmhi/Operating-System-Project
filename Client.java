import Restaurants.FifoRestaurant;
import Restaurants.LruRestaurant;
import Restaurants.RestaurantAlgorithm;
import Restaurants.SecondChanceRestaurant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    static final int PORT = 1002;
    static final String IP = "localhost";

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(IP, PORT);
        DataInputStream socketIn = new DataInputStream(socket.getInputStream());

        int numOfTables = socketIn.readInt();
        System.out.println("TABLES: " + numOfTables);
        start(socketIn,numOfTables);

    }

    private static void start(DataInputStream reader, int numOfTables) throws IOException {
        ArrayList<RestaurantAlgorithm> restaurants = new ArrayList<>();
        restaurants.add(new FifoRestaurant(numOfTables));
        restaurants.add(new LruRestaurant(numOfTables));
        restaurants.add(new SecondChanceRestaurant(numOfTables));
        while (true){
            int input = reader.readInt();
            if(input == 0){
                System.out.println("\nResults:");
                for(RestaurantAlgorithm r : restaurants){
                    System.out.println(r);
                }
                return;
            }

            System.out.println("New customer: " + input);

            for(RestaurantAlgorithm r : restaurants){
                r.newCustomer(input);
                System.out.println(r.className + ": " + r.tablesString() + " | Page Faults: " + r.getPageFaults());
            }
            System.out.println("_______________________________________________");
        }
    }
}
