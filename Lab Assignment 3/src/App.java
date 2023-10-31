import java.util.Scanner;
import java.util.LinkedList;

public class App {
    public static int choice;

    static Scanner in = new Scanner(System.in);
    static Scanner in1 = new Scanner(System.in);

    public static void main(String[] args) {

        LinkedList<Friend> sList = new LinkedList<Friend>();

        menuSelection();

        while (choice != 6) {
            switch (choice) {
                case 1:

                    System.out.println("Enter ID");
                    int id = in1.nextInt();
                    System.out.println("Enter name");
                    String name = in.nextLine();
                    System.out.println("Enter HP");
                    String hp = in.nextLine();
                    System.out.println("Enter email");
                    String email = in.nextLine();

                    Friend f = new Friend(id, name, hp, email);

                    // Verify no duplicates
                    for (Friend friend : sList) {
                        if (friend.getId() == id) {
                            System.out.println("Duplicate ID");
                            break;
                        } else {
                            sList.add(f);
                            System.out.println("Friend added");
                            break;
                        }
                    }

                    break;
                case 2:
                    System.out.println("Enter ID");
                    int id1 = in1.nextInt();

                    for (Friend friend : sList) {
                        if (friend.getId() == id1) {
                            System.out.println();
                            System.out.println(friend);
                            break;
                        } else {
                            System.out.println("Friend id not found");
                            break;
                        }
                    }

                    break;
                case 3:

                    if (sList.isEmpty()) {
                        System.out.println("List is empty");
                        break;
                    } else if (sList.size() == 1) {
                        System.out.println("List has only 1 friend");
                        break;
                    } else {
                        for (Friend friend : sList) {
                            System.out.println("Enter ID");
                            int id2 = in1.nextInt();
                            if (friend.getId() == id2) {
                                sList.remove(friend);
                                System.out.println("Friend removed.");
                                break;
                            }
                        }
                    }

                    break;
                case 4:
                    System.out.println("Enter ID");
                    int id3 = in1.nextInt();

                    for (Friend friend : sList) {
                        if (friend.getId() == id3) {
                            System.out.println("Enter new HP");
                            String hp1 = in.nextLine();
                            System.out.println("Enter new email");
                            String email1 = in.nextLine();

                            friend.setHP(hp1);
                            friend.setEmail(email1);

                            System.out.println("Friend updated");
                            break;
                        } else {
                            System.out.println("Friend id not found");
                            break;
                        }
                    }

                    break;
                case 5:
                    if (sList.isEmpty()) {
                        System.out.println("List is empty");
                        break;
                    } else {
                        for (Friend friend : sList) {
                            System.out.println(friend.toString());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            // System pause
            System.out.print("\nPress enter to continue...");
            in.nextLine();
            menuSelection();
        }

    }

    public static void menuSelection() {
        System.out.println(
                "1. Add Friend\n2. View Friend\n3. Remove Friend\n4. Update Friend\n5. Display All Friends\n6. Exit");
        System.out.print("Enter choice: ");
        choice = in1.nextInt();
    }
}
