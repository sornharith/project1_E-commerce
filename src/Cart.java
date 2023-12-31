import java.util.Scanner;

public class Cart {
    //    /*
    String yellowColor = "\u001B[33m"; // Yellow text
    String magentaColor = "\u001B[35m"; // Magenta text
    String cyanColor = "\u001B[36m";   // Cyan text
    String whiteColor = "\u001B[37m";  // White text
    String brightRedColor = "\u001B[91m"; // Bright red text
    String resetColor = "\u001B[0m";    // Reset to default color
    //    */
    private ArrayList<Product> product;
    private final LinkedList<Product> cart;
    private float total;
    private final String discount;
    private String dis;
    private static final String userName = "admin",passWord = "datastruct"; // set the user and password of admin account from here
    private static int page;
    private int show_p = 0;
    private int showinpage;
    private boolean Frontp,Lastp;
    Scanner sc = new Scanner(System.in);
    public Cart(){
        product = new Manageproduct().get_p();
        cart = new LinkedList<>();
        discount = "javaispain";
        total = 0;
        page = 1;
        showinpage = 15; // setting how many item to show in one page
        Frontp = true;
        Lastp = false;
    }

    public int get_size(){return cart.size()-1;}
    public void add(int n){
        Product a = product.get(n);
        if (n > product.size()-1){
            System.out.println(brightRedColor+"Sorry, we don't have this product in this store"+resetColor);
        } else if (!product.get(n).available_bool()) {
            if (!cart.isContain(product.get(n))) { // check that in the cart not have this product yet
                a.setCount(1);
                cart.add(a);
            } else { // if it alerdy have that product it will increase the count of that product
                int c = a.getCount();
                c++;
                a.setCount(c);
            }
            int s = a.get_stock();
            a.set_stock(s-1); // reduce the stock of that item
            System.out.println("Adding item -> "+a.get_name() + " to cart.");
            cart.sort();
        } else if (product.get(n).available_bool()) {
            System.out.println(yellowColor+"Now "+a.get_name()+" is out of stock"+resetColor);
        }
    }

    public void add_product(){ // adding the product to the store by using the provide format
        System.out.print("Enter new product in this formular -> ID,Name,Description,price,stock\n -> ");
        String input = sc.nextLine();
        String[] raw = input.split(",");
        product.add(new Product(raw[0],raw[1],raw[2],Float.parseFloat(raw[3]),Integer.parseInt(raw[4])));
        System.out.println("Complete adding -> "+product.get(product.size()-1).get_name() + " price: "+ product.get(product.size()-1).get_price());
    }

    public void remove_product(){ // remove the product out from the store by using the showID
        System.out.print("Plase enter ID of product to remove from store -> ");
        int re;
        do { // it for check the value that user input is valid or not?
            re = sc.nextInt();
            if (re > product.size()){
                System.out.print(" -> Plase check and enter ID again.\n : ");
            }
        }while (re > product.size());
        product.remove(re - 1);
        System.out.println(brightRedColor+":Complete remove"+resetColor);
    }
    public void remove(int n,int q){ // remove or reduce product out from the cart
        Product a = product.get(n);
        int c = a.getCount();
        a.setCount(c-q);
        a.set_stock(a.get_stock()+q);
//        System.out.println(cart.get(n).get_name()+n);
        if (a.getCount() < 1) { // to check that the count of the product in the cart if it less than 1 it mean that not it not have that product in cart
            cart.remove(n);
        }
        System.out.println(brightRedColor+":Complete remove"+resetColor);
    }
    public void n_page(){ // it for changing the next page of the product showing
        if (page <= (int)product.size() / showinpage){
        page+=1;
        show_p +=showinpage;
        if (page > 1) { // this for checking the page that is the first page or not.
            Frontp = false;
        }
        }
    }
    public void b_page(){ // it for changing the previous page of the product showing
        if ( page != 1){
            page-=1;
            show_p -= showinpage;
            Lastp = false;
            if (page == 1){ // to let the method that now it on the first page
                Frontp = true;
            }
        }
    }

    private void showOption(){
        System.out.println("Enter ID to select item.");
        System.out.println("Enter 'c' to look in cart.");
        System.out.println("Enter 'r' to remove item from cart.");
        System.out.println("Enter 'q' for check out.");
        if (Frontp){
            System.out.println("Enter '>' for going to next page.");
        } else if (Lastp){
            System.out.println("Enter '<'  for going to previous.");
        } else{
            System.out.println("Enter '<' or '>' for going to previous next page.");
        }
    }
    public void showProduct(){
        for(int i = 0 ; i < product.size() ; i++) {
//            System.out.println(product.get(i).toString());
            if (i == product.size()-1){
                break;
            }
            Product n = product.get(i);
            System.out.printf("| ID: -> %-2s %-20s | Price: %-3s | Stock: %-2d |\n",n.getShowID(),n.get_name(), n.get_price(), n.get_stock());
        }
    }

    public void showProduct(int o){
        for(int i = show_p ; i < page*showinpage ; i++) { // show_p equal to the start point of showID and page*showinpage is the maxiumn of showID that it will show
//            System.out.println(product.get(i).toString());
            if (i == product.size()){
                Lastp = true;
                break;
            }
            Product n = product.get(i);
            System.out.printf("| ID: -> %-2s %-20s | Price: %-3s | %-4s |\n", n.getShowID(), n.get_name(), n.get_price(), n.available());
        }
            System.out.printf("%33s %d\n","Page",page);

        System.out.println("_".repeat(64));
        if (o == 1)showOption();
    }

    public void showCart(){
//        System.out.println("_".repeat(51));
        for (int i = 0 ; i< cart.size() ; i++){
//            System.out.println(cart.get(i).toCart());
            Product n = cart.get(i);
            System.out.printf("| ID: -> %d | %-2s %-20s | Price: %-3s | %-1d |\n",cart.get(i).getShowID(),n.get_productID(),n.get_name(), n.get_price(), n.getCount());
        }
        System.out.println("Total amout : " + totalPrice() + " Baht");
    }

    public void checkout(Cart a){
        int d = 0;
        if (!isEmpty()){
                System.out.print("Plase enter to discount code if not plase enter '-' : ");
                do {
                    dis = sc.nextLine();
                    if (dis.equals("-")) {
                        break;
                    }
                    if (!dis.equals(discount)) {
                        System.out.print(magentaColor + " -> Plase check and enter the new correct code : " + resetColor);
                    } else {
                        d = 10; // change to check discount code how many % of code
                        break;
                    }

                } while (!dis.equals("-"));
                a.recipe(d);
                save(product); // save the ArrayList of product back to the .CSV
            }
        System.out.println("=".repeat(64));
        System.out.println("\t\tThank you to come to our store.");
    }

    public void recipe(int per){
        String spname = "LokSorn' shop.co.dog";
        System.out.println("=".repeat(58));
        System.out.printf(" %38s\n %43s\n %35s\n",spname,"No.88/8 BedonBed BangBuaThong,","Nothaburi, 11110");
        System.out.println("-".repeat(58));
        System.out.printf("| %-2s   | %-36s|   Price   |\n","ID","Name");
        System.out.println("-".repeat(58));
        for (int i = 0 ; i < cart.size() ; i++){
            Product n = cart.get(i);
            System.out.printf("| %-2s | %-25s x %-7d     %-3s   |\n",n.get_productID(),n.get_name(),n.getCount(),n.get_price_total());
        }
        System.out.println("-".repeat(58));
        float fina = totalPrice();
        System.out.printf("| Total   %43.2f    |\n",fina);
        System.out.printf("| Discount: %-35s %5.2f    |\n",dis,onlydiscount(fina,per));
        System.out.println("-".repeat(58));
        System.out.printf("| Total Amount  %37.2f    |\n",totaldiscount(fina,per));

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
            int op = sc.nextInt(); // get the option that what they want to update
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

