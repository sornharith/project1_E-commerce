import java.util.Objects;
import java.util.Scanner;
public class Display {
    Cart a;
    private boolean admin;
    public Display(Cart b) {
        a = b;
        admin = false;
    }

    public void display(){
        Scanner sc  = new Scanner(System.in);
        boolean sp = true;
        System.out.println("_".repeat(54));
        while(true){
            if (sp) a.showProduct(1);
            sp = true;
            System.out.print("Input your option : ");
//            char c = sc.next().charAt(0);
            String c = sc.nextLine();
            if (Objects.equals(c, "q")) {
                a.checkout(a);
//                System.out.println("Thank you");
//                a.save(a.get_nowproduct());
                break;
            } else if(Objects.equals(c, "c")){
                sp = false;
                if (a.isEmpty()){
                    System.out.println(": Now your cart is empty.");
                    sp = true;
                }else {
                    System.out.println("In Cart:");
                    a.showCart();
                }
            }else if(Objects.equals(c, "r")) {
                int num;
                int q;
                if (!a.isEmpty()) {
                    System.out.println("Enter the ID of item and quantity to remove.");
                    do {
                        System.out.print("Plase enter ID -> ");
                        num = sc.nextInt();
                        if (num-1 > a.get_size()){
                            System.out.println("-> Plase check and enter ID again.");
                        }
                    }while(num-1 > a.get_size());
                    do {
                        System.out.print("Plase enter quantity to remove -> ");
                        q = sc.nextInt();
                        if (q > a.get_nowproduct().get(num - 1).getCount()) {
                            System.out.println("-> Plase check and enter quantity again.");
                        }
                    } while (q > a.get_nowproduct().get(num - 1).getCount());
                    System.out.println("-> " + a.get_nowproduct().get(num - 1).get_name());
                    a.remove(num-1, q);
                } else {
                    System.out.println(": Now cart is empty plase add item.");
                }
            }else if (Objects.equals(c, "a")) {
                String user = "";
                String pass = "";
                if (!admin) {
                    System.out.print("Username : ");
                    user = sc.nextLine();
                    System.out.print("Password : ");
                    pass = sc.nextLine();
                }
                if (a.getUserName().equals(user) && a.getPassWord().equals(pass) || admin) {
                    admin = true;
                    System.out.print("Welcome to admin center.\n - Enter '-1' for add new product.\n - Enter '0' for remove product.\n - Enter '-9' for logout.\n - Enter ID of item to update.\n -> ");
//				System.out.print("please enter the ID of item to update : ");
                    int i = sc.nextInt();
                    if (i == -1){
                        a.add_product();
                    }else if (i == 0){
                        a.remove_product();
                    } else if (i == -9) {
                        admin = false;
                    } else {
                        a.update(i);
                    }
                } else {
                    System.out.println("You are not admin");
                }
            }else {
                try {
                    int x = Integer.parseInt(c);
                    a.add(x-1);
                }catch(NumberFormatException e) {
                    System.out.println(": input is not an Invalid");

                }
            }
            System.out.println("_".repeat(54));

        }
    }

}
