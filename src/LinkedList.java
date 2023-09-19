public class LinkedList<T extends Comparable<T>> {
    
    private Node<T> head;
    private int size;

    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void add(T item){
        Node<T> newN = new Node<>(item);
        
        if (this.head == null){
            this.head = newN;
        } else {
            Node<T> current = this.head;
            while (current.next != null) {
                current = current.next; // put it to next node
            }
            current.next = newN;
        }
        size++;
    }

    public T remove(int index){
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }

        Node<T> current = head;

        if (index == 0) {
            size--;
            head = current.next;
            return (T) current.data;
        }

        Node<T> temp = null;
        for (int i = 1; i <= index; i++) {
            temp = current;
            current = current.next;
        }

        temp.next = current.next;
        size--;

        return (T) current.data;
    }

    public int size(){ return this.size;}

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = item;
    }

    public boolean isContain(T item) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void sort() {
        head = mergeSort(head);
    }

    private Node<T> mergeSort(Node<T> head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the linked list
        Node<T> middle = getMiddle(head);
        Node<T> nextOfMiddle = middle.next;

        // Set the next pointer of the middle node to null
        middle.next = null;

        // Recursively sort the two halves
        Node<T> left = mergeSort(head);
        Node<T> right = mergeSort(nextOfMiddle);

        // Merge the sorted halves
        return merge(left, right);
    }

    private Node<T> merge(Node<T> left, Node<T> right) {
        Node<T> result;
        result = null;

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.data.compareTo(right.data) <= 0) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }
    private Node<T> getMiddle(Node<T> head) {
        if (head == null) {
            return null;
        }

        Node<T> slowPtr = head;   // Moves one step at a time
        Node<T> fastPtr = head;   // Moves two steps at a time

        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;
    }

}
