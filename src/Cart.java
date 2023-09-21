import java.util.Objects;
import java.util.Scanner;

public class Cart {
    private final ArrayList<Product> product;
    private final LinkedList<Product> cart;
    Scanner sc = new Scanner(System.in);
    public Cart(){
        product = new ArrayList<>();
        product.add(new Product("coke","soda",15,10));
        product.add(new Product("minera","water",10,5));
        product.add(new Product("HongThai","inhaler",45,20));

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
        System.out.println("Enter ID to select item");
        System.out.println("Enter 'q' for exit");
    }
    public void showProduct(){
        for(int i = 0 ; i < product.size() ; i++) {
//            System.out.println(product.get(i).toString());
            Product n = product.get(i);
            System.out.printf("| ID: -> %-2d %-10s | Price: %.2f | Stock: %-2d |%n",n.get_productID(),n.get_name(), n.get_price(), n.get_stock());
        }
    }

    public void showProduct(int o){
        for(int i = 0 ; i < product.size() ; i++) {
//            System.out.println(product.get(i).toString());
            Product n = product.get(i);
            System.out.printf("| ID: -> %-2d %-10s | Price: %.2f | %-4s |%n", n.get_productID(), n.get_name(), n.get_price(), n.available());
        }
        if (o == 1)showOption();
    }


    public void showCart(){
        for (int i = 0 ; i< cart.size() ; i++){
//            System.out.println(cart.get(i).toCart());
            Product n = product.get(i);
            System.out.printf("| ID: -> %-2d %-10s | Price: %.2f | %-2d |%n",n.get_productID(),n.get_name(), n.get_price(), n.getCount());
        }
    }

    public void update(int i){
        int count = 0;
        while(true){
            if (count > 0 || i == -1){
                break;
            }
            Product n = product.get(i);
            System.out.println("---------------------------------------------------");
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

//last
}

