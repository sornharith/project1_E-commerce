public class ArrayList<T> {

    private static final int INIT_CAPA = 10;
    private Object[] array;
    private int size;

    public ArrayList(){
        array = new Object[INIT_CAPA];
        size = 0;
    }

    public void add(T item){
        ensureCAPA();
        array[size++] = item;
    }

    public void add(int index, T item){
        ensureCAPA();
        for (int i = index ; i <= size ; i++){
            array[i+1] = array[i];
        }
        array[index] = item;
        size++;
    }

    public int size() {
        return size;
    }

    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T)array[index];
    }

    private void ensureCAPA(){
        if (size == array.length) {
            int newCapacity = array.length * 2;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public void remove(int index){
       if (index < 0 || index >= size){
           throw new IndexOutOfBoundsException();
       }

       for (int i = index ; i < size ; i++){
            array[i] = array[i+1];
       }
       array[size - 1] = null;
       size--;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        array = null;
        size = 0;
    }

    public T toArray(){
        String toA = new String();
        for(int i = 0 ; i < array.length ;i++){
            String a = (String)array[i];
            toA += a;
        }
        return (T) toA;
    }
}