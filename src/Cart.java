import java.util.Scanner;

public class Cart {

    private ArrayList<Product> product;
    private final LinkedList<Product> cart;
    Scanner sc = new Scanner(System.in);
    public Cart(){
        product = new Readproduct().get_p();
        cart = new LinkedList<>();
    }

    public void add(int n){
        if (n > product.size()-1){
            System.out.println("Sorry, we don't have this product in this store");
        } else {
            if (!cart.isContain(product.get(n))) {
                Product a = product.get(n);
                a.setCount(1);
                cart.add(a);
                System.out.println("Adding item -> "+a.get_name());
            } else {
                Product a = product.get(n);
                int c = a.getCount();
                a.setCount(c + 1);
                System.out.println("Adding item -> "+a.get_name());
            }
            cart.sort();
        }
    }

    public void add_product(){
        System.out.print("Input new product in this formular -> Name,Description,price,stock\n -> ");
        String input = sc.nextLine();
        String[] raw = input.split(",");
        product.add(new Product(raw[0],raw[1],Float.parseFloat(raw[2]),Integer.parseInt(raw[3])));
        System.out.println("Complete adding -> "+product.get(product.size()-1).get_name() + " price: "+ product.get(product.size()-1).get_price());
    }
    public void remove(int n){
        Product a = product.get(n);
        int c = a.getCount();
        if (c > 1){
            a.setCount(c-1);
        } else if (c == 1){
            cart.remove(n);
        } else {
            System.out.println("not have this item in cart");
        }
    }

    private void showOption(){
        System.out.println("Enter ID to select item.");
        System.out.println("Enter 'c' to look in cart");
        System.out.println("Enter 'q' for check out.");
    }
    public void showProduct(){
        for(int i = 0 ; i < product.size() ; i++) {
//            System.out.println(product.get(i).toString());
            Product n = product.get(i);
            System.out.printf("| ID: -> %-2d %-10s | Price: %-3s | Stock: %-2d |%n",n.get_productID(),n.get_name(), n.get_price(), n.get_stock());
        }
    }

    public void showProduct(int o){
        for(int i = 0 ; i < product.size() ; i++) {
//            System.out.println(product.get(i).toString());
            Product n = product.get(i);
            System.out.printf("| ID: -> %-2d %-10s | Price: %-3s | %-4s |%n", n.get_productID(), n.get_name(), n.get_price(), n.available());
        }
        if (o == 1)showOption();
    }

    public void showCart(){
        for (int i = 0 ; i< cart.size() ; i++){
//            System.out.println(cart.get(i).toCart());
            Product n = product.get(i);
            System.out.printf("| ID: -> %-2d %-10s | Price: %-3s | %-2d |%n",n.get_productID(),n.get_name(), n.get_price(), n.getCount());
        }
        System.out.println(product.size());
    }

    public void update(int i){
        int count = 0;
        while(true){
            if (count > 0 || i == -1){
                break;
            }
            Product n = product.get(i);
            System.out.println("_".repeat(51));

            System.out.println("Now is " + n.toString());
            System.out.print(" - Enter 1 to change price\n - Enter 2 to update stock\n - Enter 0 to select new item\n - Enter -1 to exit\n -> ");
            int op = sc.nextInt();
            if (op == 1) {
                System.out.print("Enter new price : ");
                float p = sc.nextFloat();
                n.set_price(p);
                System.out.println("now price is : " + n.get_price());
            } else if (op == 2) {
                System.out.print("Enter new stock : ");
                int s = sc.nextInt();
                n.set_stock(s);
                System.out.println("now stock is : " + n.get_stock());
            } else if (op == 0 || op == -1) {
                count++;
                if (op == -1){
                    break;
                }
                System.out.println("After update is " + n.toString());
                showProduct();
                System.out.print("please enter the ID of item to update : ");
                update(sc.nextInt());
            }

        }
    }

    public ArrayList<Product> get_nowproduct(){
        return this.product;
    }
    public void save(ArrayList<Product> get){
        new Readproduct(1,get);
    }
//last
}

