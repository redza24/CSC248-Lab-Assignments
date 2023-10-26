import java.util.*;

public class Q3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Product> listProduct1 = new ArrayList<Product>();
        ArrayList<Product> listProduct2 = new ArrayList<Product>();

        listProduct1.add(new Product("Apple", 2.99, 10));
        listProduct1.add(new Product("Tesla Model S", 99123.99, 5));
        listProduct1.add(new Product("Banana", 0.99, 30));
        listProduct1.add(new Product("Grape", 3.99, 40));
        listProduct1.add(new Product("Boeing 747", 999999.99, 1));
        listProduct1.add(new Product("Pineapple", 5.99, 60));
        listProduct1.add(new Product("Pen", 6.99, 70));
        listProduct1.add(new Product("MSI GeForce RTX 4070ti Gaming X Trio", 829.99, 10));
        listProduct1.add(new Product("Blueberry", 8.99, 90));
        listProduct1.add(new Product("Cherry", 9.99, 100));

        // Find and display the record based on productName.
        System.out.print("Enter a product name to search: ");
        String search = in.nextLine();

        boolean found = false;
        for (Product l1 : listProduct1) {
            if (l1.getProductName().equalsIgnoreCase(search)) {
                l1.toString();
                found = true;
                System.out.println("Product found at index " + listProduct1.indexOf(l1));
            }
        }
        if (!found) {
            System.out.println("Product not found.");
        }

        // Update the record where the productName is equal to Pen.
        boolean found2 = false;
        for (Product l1 : listProduct1) {
            if (l1.getProductName().equalsIgnoreCase("Pen")) {
                l1.setPrice(1.00);
                l1.setQuantity(30);
                found2 = true;
                System.out.println("\nProduct updated at index " + listProduct1.indexOf(l1));
            }
        }
        if (!found2) {
            System.out.println("\nProduct not found.");
        }

        // Remove  all  records  for  total  price  is  more  than  RM  1000  and  store  them  into listProduct2.
        for (int i = 0; i < listProduct1.size(); i++) {
            double totalPrice = listProduct1.get(i).getPrice() * listProduct1.get(i).getQuantity();
            if (totalPrice > 1000) {
                listProduct2.add(listProduct1.get(i));
                listProduct1.remove(i);
                i--;
            }
        }

        // Display the records in listProduct1 and listProduct2.
        System.out.println("\n\tList 1:");
        for (Product l1 : listProduct1) {
            System.out.println(l1.toString());
        }

        System.out.println("\n\tList 2:");
        for (Product l2 : listProduct2) {
            System.out.println(l2.toString());
        }

        in.close();
    } // end mains
} // end class