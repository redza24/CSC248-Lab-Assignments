import java.util.Scanner;
import java.util.ArrayList;

public class Q2 {
    public static int choice;

    static Scanner in = new Scanner(System.in);
    static Scanner in1 = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<String>();
        names.add("Adam");
        names.add("Haikal");
        names.add("Lukman");
        names.add("Faris");
        names.add("Mail");
        System.out.println();
        System.out.println("The list: " + names);

        menuSelection();

        int ind;
        String ele;
        while (choice != 7) {
            switch (choice) {
                case 1:
                    System.out.print("Enter new name to be added: ");
                    ele = in.nextLine();
                    System.out.print("Enter index of the new name: ");
                    ind = in1.nextInt();

                    try {
                        names.add(ind, ele);
                    } catch (IndexOutOfBoundsException e) {
                        names.add(ele);
                        ind = names.indexOf(ele);
                        System.out.println(
                                "\nDue to index out of bounds, the new name was added at the end of the list instead, which is at index "
                                        + ind);
                    }
                    System.out.println();
                    System.out.println("The updated list: " + names);
                    break;
                case 2:
                    System.out.print("Enter index of the name to be deleted: ");
                    ind = in1.nextInt();
                    names.remove(ind);
                    System.out.println();
                    System.out.println("The updated list: " + names);
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Size of the list: " + names.size());
                    break;
                case 4:
                    System.out.println();
                    System.out.print("Enter the name to find: ");
                    ele = in.nextLine();

                    if (names.contains(ele)) {
                        System.out.println("Name is found at index " + names.indexOf(ele));
                    } else
                        System.out.println("Name not found in the list.");
                    break;
                case 5:
                    for (int i = 0; i < names.size(); i++) {
                        for (int j = i + 1; j < names.size(); j++) {
                            if (names.get(i).compareTo(names.get(j)) > 0) {
                                String temp = names.get(i);
                                names.set(i, names.get(j));
                                names.set(j, temp);
                            }
                        }
                    }
                    System.out.println("The updated list: " + names);
                    break;
                case 6:
                    System.out.println("The list: " + names);
                    break;
                case 7:
                    System.out.println("Thank you for using this program!");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            // System pause
            System.out.print("\nPress enter to continue...");
            in.nextLine();
            menuSelection();
        }

        in.close();
        in1.close();
    }

    public static void menuSelection() {
        System.out.print(
                "\n\n\tMenu Selection\n1. Add new element into the list\n2. Delete element from the list\n3. The number of elements in the list\n4. Find if a name exists in the list\n5. Sort the list of names in ascending order\n6. Print all the names in the list\n7. Exit\n\nEnter your choice: ");
        choice = in1.nextInt();
    }
}
