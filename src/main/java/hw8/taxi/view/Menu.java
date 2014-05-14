package hw8.taxi.view;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.service.ClientService;
import hw8.taxi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */

@Component
public class Menu {
    private static final int SHOW_ALL_USERS_ITEM = 1;
    private static final int EXIT_ITEM = 0;
    private static final int ADD_NEW_USER_ITEM = 2;
    private static final int ADD_NEW_ORDER = 3;
    private static final int SHOW_ALL_ORDERS = 4;

    @Autowired
    private ClientService clientService;

    @Autowired
    private OrderService orderService;

    private Scanner scan;

    public Menu() {
        scan = new Scanner(System.in);
    }

    public Menu(ClientService clientService, OrderService orderService) {
        this.clientService = clientService;
        this.orderService = orderService;
        scan = new Scanner(System.in);
    }

    @PostConstruct
    public void main() {
        int choise = EXIT_ITEM;

        do {
            showMenu();
            choise = getInput();

            switch (choise) {
                case EXIT_ITEM:
                    System.exit(0);
                    break;
                case SHOW_ALL_USERS_ITEM:
                    showAllUsers();
                    break;
                case ADD_NEW_USER_ITEM:
                    addNewUser();
                    break;
                case ADD_NEW_ORDER:
                    addNewOrder();
                    break;
                case SHOW_ALL_ORDERS:
                    showAllOrders();
                    break;
            }
        } while (choise != EXIT_ITEM);

    }

    private void showAllUsers() {
        for (Client user : clientService.getAllUsers()) {
            System.out.println(user);
        }
    }

    private void showAllOrders() {
        for (Order order : orderService.getAllOrders()) {
            System.out.println(order);
        }
    }


    private void addNewUser() {
        System.out.println("Input name");
        String name = scan.nextLine();
        Client user = new Client(name);
        System.out.println("Added user " + user);
        clientService.addNewUser(user);
    }

    private void addNewOrder() {
        int attempt_count=0;
        Client client=null;
        while (attempt_count<3){
            System.out.println("Input client name:");
            String name = scan.nextLine();
            client = clientService.getByName(name);
            if (client != null){
                break;
            }
            System.out.println("No such client");
            attempt_count++;
        }
        if (client==null){
            System.out.println("You cant find the client");
            return;
        }
        System.out.println("Input Address");
        String address = scan.nextLine();
        int amount = scanIntWithRetry("Input amount");
        Order order = new Order(client, address, amount);
        orderService.addNewOrder(order);
    }


    private double scanDoubleWithRetry(String message) {
        return 0;
    }

    private Date scanDateWithRetry(String message) {
        final String DATE_FORMAT = "mm.dd.yyyy";
        Date date = null;
        String dateStr;
        do {
            System.out.println(message);
            dateStr = scan.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            try {
                date = sdf.parse(dateStr);
            } catch (ParseException pe) {
                System.out.println("Illegal date format, correct format is \'" + DATE_FORMAT + "\', try again");
            }
        } while (date == null);
        return date;
    }

    private int scanIntWithRetry(String ageMsg) {
        Integer age = null;
        String ageStr;
        do {
            System.out.println(ageMsg);
            ageStr = scan.nextLine();
            try {
                age = Integer.valueOf(ageStr);
            } catch (NumberFormatException nfe) {
                System.out.println("Not an int value, input again");
            }
        } while (age == null);

        return age;
    }

    private int getInput() {
        int res = -1;
        String inputStr = scan.nextLine();
        try {
            res = Integer.parseInt(inputStr);
        } catch (NumberFormatException nfe) {
            System.out.println("String " + inputStr + " is not a number");
        }

        return res;
    }

    public void showMenu() {
        System.out.println("-----------------");
        System.out.println("1. Show all clients");
        System.out.println("2. Add new client");
        System.out.println("3. Add new order");
        System.out.println("4. Show all orders");
        System.out.println("0. Exit");
    }
}
