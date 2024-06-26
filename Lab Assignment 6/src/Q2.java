import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner in1 = new Scanner(System.in);

        Queue qCustomer = new Queue();
        Queue qQualify = new Queue();

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter customer name: ");
            String name = in.nextLine();
            System.out.print("Enter account number: ");
            int accountNo = in1.nextInt();
            System.out.print("Enter saving (RM): ");
            double saving = in1.nextDouble();
            System.out.print("Enter total transaction (RM): ");
            double totalTransaction = in1.nextDouble();

            Customer customer = new Customer(name, accountNo, saving, totalTransaction);

            qCustomer.enqueue(customer);
            if (customer.process()) {
                qQualify.enqueue(customer);
            }
        }

        while (!qQualify.isEmpty()) {
            System.out.println(qQualify.dequeue() + "\n");
        }

        in1.close();
        in.close();
    }
}

class Customer {
    private String name;
    private int accountNo;
    private double saving;
    private double totalTransaction;

    public Customer(String name, int accountNo, double saving, double totalTransaction) {
        this.name = name;
        this.accountNo = accountNo;
        this.saving = saving;
        this.totalTransaction = totalTransaction;
    }

    public String getName() {
        return name;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public double getSaving() {
        return saving;
    }

    public double getTotalTransaction() {
        return totalTransaction;
    }

    @Override
    public String toString() {
        return "Customer name: " + name + "\nAccount No: " + accountNo + "\nSaving: RM "
                + String.format("%,.2f", saving)
                + "\nTotal Transaction: RM " + String.format("%,.2f", totalTransaction);
    }

    public boolean process() {
        return saving > 1000;
    }
}

class Node {
    Object data;
    Node link;

    public Node(Object elem) {
        this.data = elem;
        this.link = null;
    }

    public Node(Object elem, Node nextElem) {
        this.data = elem;
        this.link = nextElem;
    }

    public Object getData() {
        return data;
    }

    public Node getLink() {
        return link;
    }
}

class ListNode {
    Node first;
    Node last;

    public ListNode() {
        this.first = null;
        this.last = null;
    }
}

class Queue extends ListNode {
    public Queue() {
        super();
    }

    public void enqueue(Object elem) {
        Node newNode = new Node(elem);
        if (this.first == null) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.link = newNode;
            this.last = newNode;
        }
    }

    public Object dequeue() {
        if (this.first != null) {
            Object data = this.first.data;
            this.first = this.first.link;
            return data;
        }
        return null;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public Object getFirst() {
        if (this.first != null) {
            return this.first.data;
        } else {
            return null;
        }
    }

    public Object getNext() {
        if (this.first != null && this.first.link != null) {
            return this.first.link.data;
        } else {
            return null;
        }
    }

    public Object getLast() {
        if (this.last != null) {
            return this.last.data;
        } else {
            return null;
        }
    }
}