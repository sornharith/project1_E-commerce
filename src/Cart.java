import java.util.Scanner;

public class Cart {

    private ArrayList<Product> product;
    private final LinkedList<Product> cart;
    private float total;
    private final String discount;
    private String dis;
    private static final String userName = "admin",passWord = "datastruct";
    Scanner sc = new Scanner(System.in);
    public Cart(){
        product = new Manageproduct().get_p();
        cart = new LinkedList<>();
        discount = "javaispain";
        total = 0;
    }

    public int get_size(){return cart.size()-1;}
    public void add(int n){
        Product a = product.get(n);
        if (n > product.size()-1){
            System.out.println("Sorry, we don't have this product in this store");
        } else if (!product.get(n).available_bool()) {
            if (!cart.isContain(product.get(n))) {
                a.setCount(1);
                cart.add(a);
            } else {
                int c = a.getCount();
                c++;
                a.setCount(c);
            }
            int s = a.get_stock();
            a.set_stock(s-1);
            System.out.println("Adding item -> "+a.get_name() + " to cart.");
            cart.sort();
        } else if (product.get(n).available_bool()) {
            System.out.println("Now "+a.get_name()+" is out of stock");
        }
    }

    public void add_product(){
        System.out.print("Enter new product in this formular -> ID,Name,Description,price,stock\n -> ");
        String input = sc.nextLine();
        String[] raw = input.split(",");
        product.add(new Product(raw[0],raw[1],raw[2],Float.parseFloat(raw[3]),Integer.parseInt(raw[4])));
        System.out.println("Complete adding -> "+product.get(product.size()-1).get_name() + " price: "+ product.get(product.size()-1).get_price());
    }

    public void remove_product(){
        System.out.print("Plase enter ID of product to remove from store -> ");
        int re;
        do {
            re = sc.nextInt();
            if (re > product.size()){
                System.out.print(" -> Plase check and enter ID again.\n : ");
            }
        }while (re > product.size());
        product.remove(re - 1);
        System.out.println(":Complete remove");
    }
    public void remove(int n,int q){
        Product a = product.get(n);
        int c = a.getCount();
        a.setCount(c-q);
//        System.out.println(cart.get(n).get_name()+n);
        if (a.getCount() < 1) {
            cart.remove(n);
        }
        System.out.println(":Complete remove");
    }

    public void admin(Cart a){

    }

    private void showOption(){
        System.out.println("Enter ID to select item.");
        System.out.println("Enter 'c' to look in cart.");
        System.out.println("Enter 'r' to remove item from cart.");
        System.out.println("Enter 'q' for check out.");
    }
    public void showProduct(){
        for(int i = 0 ; i < product.size() ; i++) {
//            System.out.println(product.get(i).toString());
            Product n = product.get(i);
            System.out.printf("| ID: -> %-2s %-10s | Price: %-3s | Stock: %-2d |\n",n.getShowID(),n.get_name(), n.get_price(), n.get_stock());
        }
    }

    public void showProduct(int o){
        for(int i = 0 ; i < product.size() ; i++) {
//            System.out.println(product.get(i).toString());
            Product n = product.get(i);
            System.out.printf("| ID: -> %-2s %-10s | Price: %-3s | %-4s |\n", n.getShowID(), n.get_name(), n.get_price(), n.available());
        }
        System.out.println("_".repeat(54));
        if (o == 1)showOption();
    }

    public void showCart(){
//        System.out.println("_".repeat(51));
        for (int i = 0 ; i< cart.size() ; i++){
//            System.out.println(cart.get(i).toCart());
            Product n = cart.get(i);
            System.out.printf("| ID: -> %-2s %-10s | Price: %-3s | %-1d |\n",n.get_productID(),n.get_name(), n.get_price(), n.getCount());
        }
        System.out.println("Total amout : " + totalPrice() + " Bath");
    }

    public void checkout(Cart a){
        int d = 0;
        if (!isEmpty()){
            System.out.print("Plase enter to discount code if not plase enter '-' : ");
            do {
                 dis = sc.nextLine();
                 if (dis.equals("-")){
                     break;
                 }
                 if (!dis.equals(discount)){
                     System.out.print(" -> Plase check and enter the new correct code : ");
                 } else{
                     d = 10; // change to check discount code how many % of code
                     break;
                 }

            }while (!dis.equals("-"));
            a.recipe(d);
        }
        System.out.println("=".repeat(46));
        System.out.println("\t\tThank you to come to our store.");
        save(product);
    }

    public void recipe(int per){
        String spname = "LokSorn' shop.co.dog";
        System.out.println("=".repeat(46));
        System.out.printf("\t\t\t %10s\n\t\tNo.88/8 BedonBed BangBuaThong,\n\t\t\t Nothaburi, 11110\n", spname);
        System.out.println("-".repeat(46));
        System.out.print("| ID\t | Name\t\t\t\t\t |   Price   |\n");
        System.out.println("-".repeat(46));
        for (int i = 0 ; i < cart.size() ; i++){
            Product n = cart.get(i);
            System.out.printf("| %-2s\t | %-12s x %d\t\t     %-3s   |\n",n.get_productID(),n.get_name(),n.getCount(),n.get_price_total());
        }
        System.out.println("-".repeat(46));
        float fina = totalPrice();
        System.out.printf("| Total \t\t\t\t\t\t\t  %.2f  |\n",fina);
        System.out.printf("| Discount: %-26s %.2f  |\n",dis,onlydiscount(fina,per));
        System.out.println("-".repeat(46));
        System.out.printf("| Total Amount\t\t\t\t\t\t  %.2f  |\n",totaldiscount(fina,per));

    }

    public void update(int i){
        int count = 0;
        while(true){
            if (count > 0 || i == -1){
                break;
            }
            Product n = product.get(i-1);
            System.out.println("=".repeat(51));

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
                showProduct();
                System.out.print("please enter the ID of item to update : ");
                update(sc.nextInt());
            }
                System.out.println(":After update is " + n.toString());

        }
    }

    public float totalPrice(){
        total = 0;
        for (int i = 0 ; i < cart.size() ;i++){
            Product n = cart.get(i);
            total += (n.getPrice() * n.getCount());
        }
        return total;
    }
    private float onlydiscount(float am,int pe){
        return am - totaldiscount(am,pe);
    }
    private float totaldiscount(float am,int pe){
      if (pe > 0) {
          float price = am;
          float disc = (100 - pe);
          price = price * (disc/100);
        return price;
      }
      return am;
    }

    public ArrayList<Product> get_nowproduct(){
        return this.product;
    }
    public void save(ArrayList<Product> get){
        new Manageproduct(1,get);
    }

    public boolean isEmpty(){
        return cart.size() == 0;
    }
    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
//last
}

