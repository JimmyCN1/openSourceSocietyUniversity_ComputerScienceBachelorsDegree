package ui;

import model.Order;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderScreen {

    private Scanner scanner;
    private boolean runProgram;
    private Integer orderNumber;

    private ArrayList<Order> orders = new ArrayList<Order>();


    public static void main(String[] args) {
        OrderScreen orderScreen = new OrderScreen();
        orderScreen.scanner = new Scanner(System.in);
        orderScreen.runProgram = true;
        orderScreen.orderNumber = 1;

        while (orderScreen.runProgram) {
            Order order = new Order(orderScreen.orderNumber);
            orderScreen.orderNumber++;

            System.out.println("\n\nWelcome!\nMay I take your order please?");
            System.out.println("Type \"yes\" or \"no\"");

            String input = orderScreen.scanner.nextLine();
            if (input.equals("yes")) {
                System.out.println("What is you name");
                input = orderScreen.scanner.nextLine();
                order.setCustomerName(input);

                System.out.println("Which combo would you like to order");
                System.out.println("A, B, C or D?");
                input = orderScreen.scanner.nextLine();
                order.setComboID(input);
                order.setPriceAndWaitTime(input);
                System.out.println("That will come to: $" + order.getPrice());

                System.out.println("\nAny special requirements?");
                System.out.println("If none then type \"no\".");
                input = orderScreen.scanner.nextLine();
                if (!input.equals("no")) {
                    order.setSpecialInstructions(input);
                }

                System.out.println("\nThank you for your order." + order.getCustomerName() +
                        "\nYour ticket number is " + order.getTicketNumber() +
                        "\nYour wait time will be approximately" + order.getWaitTime());


                orderScreen.orders.add(order);
            } else {
                System.out.println("Goodbye");
            }



        }

    }


}
