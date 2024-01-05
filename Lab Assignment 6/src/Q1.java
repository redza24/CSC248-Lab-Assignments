import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner in1 = new Scanner(System.in);

        Queue qHouse = new Queue();
        Queue qSemi_D = new Queue();
        Queue qTerrace = new Queue();
        Queue temporary = new Queue();

        for (int i = 0; i < 2; i++) {
            System.out.print("1. Semi-D\n2. Terrace\nEnter house type: ");
            int typeInt = in.nextInt();

            String type = "";
            if (typeInt == 1)
                type = "Semi-D";
            else if (typeInt == 2)
                type = "Terrace";
            else
                System.out.println("Invalid input.");

            System.out.print("Enter location: ");
            String location = in1.nextLine();
            System.out.print("Enter size (Metre): ");
            double size = in.nextDouble();
            System.out.print("Enter price per unit (RM): ");
            double price = in.nextDouble();

            qHouse.enqueue(new House(type, location, size, price));
            System.out.println();
        }

        while (!qHouse.isEmpty()) {
            House house = (House) qHouse.dequeue();

            if (house.getType().equals("Semi-D")) {
                qSemi_D.enqueue(house);
            } else if (house.getType().equals("Terrace")) {
                qTerrace.enqueue(house);
            }

            temporary.enqueue(house);
        }

        while (!temporary.isEmpty()) {
            qHouse.enqueue(temporary.dequeue());
        }

        int countTerrace = 0;
        while (!qTerrace.isEmpty()) {
            House house = (House) qTerrace.dequeue();

            if (house.getPrice() < 150000) {
                countTerrace++;
                if (countTerrace == 1)
                    System.out.println("Houses with price less than RM 150,000.00: ");
                System.out.println(house);
            }
        }

        if (countTerrace == 0)
            System.out.println("No houses with price less than RM 150,000.00.");

        while (!temporary.isEmpty()) {
            qTerrace.enqueue(temporary.dequeue());
        }

        int count = 0;
        while (!qHouse.isEmpty()) {
            House house = (House) qHouse.dequeue();

            if (house.getPrice() > 300000) {
                count++;
                if (count == 1)
                    System.out.println("Houses with price more than RM 300,000.00: ");
                System.out.println(house);
            }
        }

        if (count == 0)
            System.out.println("No houses with price more than RM 300,000.00.");

        while (!temporary.isEmpty()) {
            qHouse.enqueue(temporary.dequeue());
        }
        System.out.println("Number of houses with price more than RM 300,000.00: " + count);

        in1.close();
        in.close();
    }
}

class Queue extends LinkedList<Object> {
    protected LinkedList<Object> list;

    public Queue() {
        list = new LinkedList<Object>();
    }

    public void enqueue(Object element) {
        list.addFirst(element);
    }

    public Object dequeue() {
        return list.removeLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

class House {
    private String type;
    private String location;
    private double size;
    private double price;

    public House(String type, String location, double size, double price) {
        this.type = type;
        this.location = location;
        this.size = size;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public double getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "House type: " + type + "\nLocation: " + location + "\nSize (Metre): " + String.format("%,.2f", size)
                + "\nPrice: RM " + String.format("%,.2f", price) + "\n";
    }
}