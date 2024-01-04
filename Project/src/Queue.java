public class Queue extends List{
    public Queue() {
        super();
    }

    public int size() {
        return size();
    }

    public boolean isEmpty() {
        return isEmpty();
    }

    public void enqueue(Object obj) {
        insertAtBack(obj);
    }

    public Object dequeue() {
        return removeFront();
    }

    public Object front() {
        return getFirst();
    }

    public Object back() {
        return getLast();
    }

    public Patient removedPatient(String icNum) {
        return removedPatient(icNum);
    }

    public Object searchPatient(String icNum) {
        return searchPatient(icNum);
    }
}
