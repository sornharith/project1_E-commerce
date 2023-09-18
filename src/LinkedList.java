public class LinkedList<T> {
    
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
}
