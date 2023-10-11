import java.util.Scanner;
import java.io.*;

public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Land[] lands = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("customerData.txt"));

            // Count the number of lines in the file
            int count = 0;
            String line = br.readLine();
            while (line != null) {
                count++;
                line = br.readLine();
            }
            br.close();
            lands = new Land[count];

            // Read data into lands array
            br = new BufferedReader(new FileReader("customerData.txt"));
            int i = 0;
            String inData;
            while ((inData = br.readLine()) != null) {
                String[] tokens = inData.split(";");

                String id = tokens[0];
                String ownerName = tokens[1];
                char type = tokens[2].charAt(0);
                double area = Double.parseDouble(tokens[3]);

                lands[i] = new Land(id, ownerName, type, area);
                i++;
            } // end while

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Menu selection
        int option = 0;
        while (option != 4) {
            System.out.println("\n\t Menu Selection");
            System.out.println("1. Sorting using Bubble Sort");
            System.out.println("2. Sorting using Insertion Sort");
            System.out.println("3. Searching using Binary Search");
            System.out.println("4. Exit");
            System.out.print("\nYour Option: ");
            option = in.nextInt();
            System.out.println("\n----------------------------------");

            switch (option) {
                case 1:
                    System.out.println("\tSorting using Bubble Sort\n");
                    bubbleSort(lands);
                    break;
                case 2:
                    System.out.println("\tSorting using Insertion Sort\n");
                    insertionSort(lands);
                    break;
                case 3:
                    System.out.println("\tSearching using Binary Search\n");
                    // Implement binary search logic here
                    break;
                case 4:
                    System.out.println("\n\tThank you for using this program.\n");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        in.close();
    } // end main

    public static void bubbleSort(Land[] lands) {
        for (int i = 0; i < lands.length; i++) {
            for (int j = 0; j < lands.length - 1 - i; j++) {
                if (lands[j].calcTax() > lands[j + 1].calcTax()) {
                    Land temp = lands[j];
                    lands[j] = lands[j + 1];
                    lands[j + 1] = temp;
                }
            }
        }

        // Print sorted lands and their taxes
        for (Land land : lands) {
            System.out.println(land.toString());
            System.out.printf("Tax : RM%,.2f%n", land.calcTax());
            System.out.println();
        }
        System.out.println("\tSorted based on tax price");
        System.out.println("----------------------------------");
    } // end bubbleSort

    public static void insertionSort(Land[] lands) {
        for (int i = 1; i < lands.length; i++) {
            Land temp = lands[i];
            int j = i - 1;
            while (j >= 0 && lands[j].getId().compareTo(temp.getId()) > 0) {
                lands[j + 1] = lands[j];
                j--;
            }
            lands[j + 1] = temp;
        }

        for (Land land : lands) {
            System.out.println(land.toString());
            System.out.printf("Tax : RM%,.2f%n", land.calcTax());
            System.out.println();
        }

        System.out.println("\tSorted based on owner id");
        System.out.println("----------------------------------");
    } // end insertionSort

    

} // end class
