import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // for string 
        Scanner in1 = new Scanner(System.in); 

        // i) declare two array lists
        ArrayList<Computer> listComputer1 = new ArrayList<Computer>();
        ArrayList<Computer> listComputer2 = new ArrayList<Computer>();

        // ii) insert some computer data into listComputer1, number of data to be inserted is based on user input
        System.out.print("Enter number of computer to be inserted: ");
        int n = in1.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.print("Enter brand: ");
            String brand = in.nextLine();
            System.out.print("Enter serial no: ");
            int serialNo = in1.nextInt();
            System.out.print("Enter year: ");
            int year = in1.nextInt();
            System.out.print("Enter price: ");
            double price = in1.nextDouble();

            listComputer1.add(new Computer(brand, serialNo, year, price));
        }

        // iii) display the computer data in listComputer1
        System.out.println();
        System.out.println("\t\tCOMPUTER INFORMATION");
        System.out.println("Brand\t\tSerial Number\t\tYear\t\tPrice(RM)");
        int total = 0;
        for (Computer c : listComputer1) {
            System.out.println(c.getBrand() + "\t\t" + c.getSerialNo() + "\t\t" + c.getYear() + "\t\t" + c.getPrice());
            total += c.getPrice();
        }
        System.out.println("Total Price of all computers: RM" + total);

        // iv) move listComputer1 data (year greater than 2015) into listComputer2
        for (int i = 0; i < listComputer1.size(); i++) {
            if (listComputer1.get(i).getYear() > 2015) {
                listComputer2.add(listComputer2.size(), listComputer1.get(i));
                listComputer1.remove(i);
                i--;
            }
        }

        System.out.println();
        System.out.println("\t\tCOMPUTER INFORMATION");
        System.out.println("Brand\t\tSerial Number\t\tYear\t\tPrice(RM)");
        for (Computer c : listComputer1) {
            System.out.println(c.getBrand() + "\t\t" + c.getSerialNo() + "\t\t" + c.getYear() + "\t\t" + c.getPrice());
        }
        System.out.println();
        System.out.println("\t\tCOMPUTER INFORMATION");
        System.out.println("Brand\t\tSerial Number\t\tYear\t\tPrice(RM)");
        for (Computer c : listComputer2) {
            System.out.println(c.getBrand() + "\t\t" + c.getSerialNo() + "\t\t" + c.getYear() + "\t\t" + c.getPrice());
        }

        // v) search for the computer that has serial number 10001010 from listComputer1
        // and replace it with new computer data
        for (int i = 0; i < listComputer1.size(); i++) {
            if (listComputer1.get(i).getSerialNo() == 10001010) {
                String brand = "Acer";
                int serialNo = 10001011;
                int year = 2004;
                double price = 5000.00;
                listComputer1.set(i, new Computer(brand, serialNo, year, price));

            }
        }

        System.out.println();
        System.out.println("\t\tCOMPUTER INFORMATION");
        System.out.println("Brand\t\tSerial Number\t\tYear\t\tPrice(RM)");
        for (Computer c : listComputer1) {
            System.out.println(c.getBrand() + "\t\t" + c.getSerialNo() + "\t\t" + c.getYear() + "\t\t" + c.getPrice());
        }

        in.close();
        in1.close();
    }
}

class Computer {
    private String brand;
    private int serialNo;
    private int year;
    private double price;

    public Computer(String b, int s, int y, double p) {
        brand = b;
        serialNo = s;
        year = y;
        price = p;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getSerialNo() {
        return this.serialNo;
    }

    public int getYear() {
        return this.year;
    }

    public double getPrice() {
        return this.price;
    }
}
