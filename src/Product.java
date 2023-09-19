
public class Product implements Comparable<Product> {
    private int ID;
    private String name;
    private String description;
    private float price;
    private int stock;
    private int count = 0;
    private static int runningID = 0;
    
    public Product(){
        this.ID = ++runningID;

    }

    public Product(String name, String description , float price, int stock){
        this.ID = ++runningID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public void set_prodectID(int id){
        this.ID = id;
    }

    public int get_productID(){
        return this.ID;
    }

    public void set_name(String name){
        this.name = name;
    }

    public String get_name(){
        return this.name;
    }

    public void set_description(String description){
        this.description = description;
    }

    public String get_description(){
        return this.description;
    }

    public void set_price(float price){
        this.price = price;
    }

    public float get_price(){
        return this.price;
    }

    public void set_stock(int stock){
        this.stock = stock;
    }

    public int get_stock(){
        return this.stock;
    }

    private String available(){
        if (stock <= 0) return "out of stock";
        else return "available";
    }
    @Override
    public String toString(){
        return "ID: "+ID+" -> "+name+" \tprice: "+price+"\t\t"+available();
    }

    public String toCart(){
        return "ID: "+ID+" -> "+name+" \tprice: "+price+"\t\t"+count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(Product o) {
        return Integer.compare(this.get_productID(), o.get_productID());
    }
}
