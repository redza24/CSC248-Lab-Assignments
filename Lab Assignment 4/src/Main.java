import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner in1 = new Scanner(System.in);

        System.out.println("Computer List Program\n");

        System.out.print(
                "1. Insert a new node into list\n2. Delete node based on serial number\n3. Print computer information\n4. Count number of computers which exceed a certain amount price\n5. Display list\n6. Exit\n\nEnter your choice: ");
        int choice = in1.nextInt();

        List list = new List();

        System.out.println();
        while (choice != 6) {
            if (choice == 1) {
                System.out.print("Enter serial number: ");
                int serialNo = in1.nextInt();

                // check if theres any computer with the same serial number
                ListNode curr = list.getFirstNode();
                boolean exist = false;
                while (curr != null) {
                    if (((Computer) curr.getObj()).getSerialNo() == serialNo) {
                        System.out.println("Serial number already exist\n");
                        exist = true;
                        break;
                    }
                    curr = curr.getNext();
                }

                if (exist) {
                    continue;
                }

                System.out.print("Enter brand: ");
                String brand = in.nextLine();
                System.out.print("Enter year: ");
                int year = in1.nextInt();
                System.out.print("Enter price (RM): ");
                double price = in1.nextDouble();

                System.out.print(
                        "\n1. Insert at the beginning of the list\n2. Insert at the end of the list\n3. Insert at middle of the list\n\nEnter your choice: ");
                int choice2 = in1.nextInt();

                if (choice2 == 1) {
                    list.insertAtFront(new Computer(serialNo, brand, year, price));
                } else if (choice2 == 2) {
                    list.insertAtBack(new Computer(serialNo, brand, year, price));
                } else if (choice2 == 3) {
                    list.insertAtMiddle(new Computer(serialNo, brand, year, price));
                } else {
                    System.out.println("Invalid choice");
                }
            } else if (choice == 2) {
                System.out.print("Enter serial number: ");
                int serialNo = in1.nextInt();
                if (list.remove(serialNo) == null) {
                    System.out.println("Serial number not found\n");
                } else {
                    System.out.println("Serial number " + serialNo + " has been deleted\n");
                }
            } else if (choice == 3) {
                System.out.print("Enter serial number: ");
                int serialNo = in1.nextInt();
                System.out.println();
                list.searchComputer(serialNo);
            } else if (choice == 4) {
                System.out.print("Enter price to print out which computers price exceed it (RM): ");
                double price = in1.nextDouble();

                System.out.println("\nThere's " + list.countComputer(price) + " computers which exceed RM " + price);

            } else if (choice == 5) {
                list.print();
            } else {
                System.out.println("Invalid choice");
            }
            System.out.print(
                    "1. Insert a new node into list\n2. Delete node based on serial number\n3. Print computer information\n4. Count number of computers which exceed a certain amount price\n5. Display list\n6. Exit\n\nEnter your choice: ");
            choice = in1.nextInt();
            System.out.println();
        }

        in.close();
        in1.close();

        System.out.println("Program terminated.");
    }
}