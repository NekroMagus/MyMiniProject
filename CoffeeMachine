import java.util.Scanner;

public class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int disCups = 9;
    private int money = 550;

    private boolean flag = false;
    private Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        new CoffeeMachine().go();
    }

    private void go(){
        while(!flag) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String choiceAction = scan.nextLine();
            switch(choiceAction){
                case "buy":
                    actionBuy();
                    break;
                case "fill":
                    actionFill();
                    break;
                case "take":
                    actionTake();
                    break;
                case "remaining":
                    actionRemaining();
                    break;
                case "exit":
                    flag = true;
                    System.out.println("Bye-bye");
                    break;
                default:
                    System.err.println("Invalid action\n");
                    break;
            }
        }
    }

    private void actionBuy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                if(water < 250) System.out.println("Sorry, not enough water!");
                else if(coffeeBeans < 16) System.out.println("Sorry, not enough coffee beans!");
                else {
                    water -= 250;
                    coffeeBeans -= 16;
                    money += 4;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;

            case 2:
                if(water < 350) System.out.println("Sorry, not enough water!");
                else if(milk < 75) System.out.println("Sorry, not enough milk!");
                else if(coffeeBeans < 20) System.out.println("Sorry, not enough coffee beans!");
                else {
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    money += 7;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;

            case 3:
                if(water < 200) System.out.println("Sorry, not enough water!");
                else if(milk < 100) System.out.println("Sorry, not enough milk!");
                else if(coffeeBeans < 12) System.out.println("Sorry, not enough coffee beans!");
                else {
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    money += 6;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;

            default:
                System.err.println("Invalid action\n");
                break;
        }
    }

    private void actionFill(){
        System.out.println("Write how many ml of water do you want to add: ");
        int choice = scan.nextInt();
        water += choice;

        System.out.println("Write how many ml of milk do you want to add: ");
        choice = scan.nextInt();
        milk += choice;

        System.out.println("Write how many grams of coffee beans do you want to add: ");
        choice = scan.nextInt();
        coffeeBeans += choice;

        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        choice = scan.nextInt();
        disCups += choice;
    }

    private void actionTake(){
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private void actionRemaining(){
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water\n%d of milk \n%d of coffee beans \n%d of disposable cups \n$%d of money\n\n",water,milk,coffeeBeans,disCups,money );
    }

}
