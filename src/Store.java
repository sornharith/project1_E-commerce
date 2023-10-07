import java.util.Scanner;
public class Store {

	public static void main(String[] args) {

		Cart a = new Cart();
		Display show = new Display(a);
		show.display(); // call to show all of interface

/*
		Scanner sc  = new Scanner(System.in);
		boolean sp = true;
		System.out.println("_".repeat(54));
		while(true){
			if (sp) a.showProduct(1);
			sp = true;
			System.out.print("Input your option : ");
			char c = sc.next().charAt(0);
            if (c == 'q') {
				System.out.println("Thank you");
				a.save(a.get_nowproduct());
            	break;
            } else if(c == 'c'){
				sp = false;
				if (a.isEmpty()){
					System.out.println(": Now your cart is empty.");
					sp = true;
				}else {
					System.out.println("In Cart:");
					a.showCart();
				}
			}else if( c == 'r') {
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
					a.remove(num, q);
				} else {
					System.out.println("Now cart is empty plase add item.");
				}
			}else if (c == 'a') {
				System.out.print("Welcome to admin center.\n - Enter '-1' for add new product.\n - Enter '0' for remove product.\n - Enter ID of item to update.\n -> ");
//				System.out.print("please enter the ID of item to update : ");
				int i = sc.nextInt();
				if (i == -1){
					a.add_product();
				}else if (i == 0){
					a.remove_product();
				}else {
					a.update(i);
				}
			}else {
				try {
					int x = Integer.parseInt(String.valueOf(c));
					a.add(x-1);
				}catch(NumberFormatException e) {
					System.out.println(":input is not an Invalid");

				}
			}
			System.out.println("_".repeat(54));

		}
*/
		/*
		ArrayList<Product> test = a.get_nowproduct();
		a.add_product();
		ArrayList<Product> m= a.get_nowproduct();
		System.out.println(m.size());
		a.save(a.get_nowproduct());
		*/
	}

}
