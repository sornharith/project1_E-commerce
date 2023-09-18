
public class Product {
    private int ID;
    private String name;
    private String description;
    private float price;
    private int stock;
    
    public Product(){
        this.ID = 0;

    }

    public Product(int id, String name, String description , float price, int stock){
        this.ID = id;
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
}
