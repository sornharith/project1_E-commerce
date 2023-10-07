import java.text.DecimalFormat;

public class Product implements Comparable<Product> {
    public static final DecimalFormat df = new DecimalFormat("0.00");
    private String ID;
    private final int showID;
    private String name;
    private String description;
    private float price;
    private int stock;
    private int count = 0;
    private static int runningID = 0; // to let user easy to input while add to cart
    
    public Product(){
        this.showID = ++runningID;

    }

    public Product(String Id,String name, String description , float price, int stock){
//        this.ID = ++runningID;
        this.ID = Id;
        this.showID = ++runningID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public int getShowID() {
        return showID;
    }
    public void set_prodectID(String id){
        this.ID = id;
    }

    public String get_productID(){
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

    public String get_price(){
        String p = df.format(this.price);
        if (price < 10) p += " ";
        return p;
    }
    public String get_price_total(){
        String p = df.format(this.price*count);
        if (price < 10) p += " ";
        return p;
    }
    public float getPrice(){
        return price;
    }

    public void set_stock(int stock){
        this.stock = stock;
    }

    public int get_stock(){
        return this.stock;
    }

    public String available(){
        if (stock <= 0) return "out of stock";
        else return "  available ";
    }
    public boolean available_bool(){
        return stock == 0;
    }
    @Override
    public String toString(){
        return "ID: "+ID+" -> "+name+" \tprice: "+price+"\t"+"stock: "+stock;
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
        return CharSequence.compare(this.get_productID(), o.get_productID());
    }
}
