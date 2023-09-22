import java.util.Scanner;
public class Store {

	public static void main(String[] args) {

		Cart a = new Cart();
///*
		Scanner sc  = new Scanner(System.in);
		boolean sp = true;
		System.out.println("_".repeat(51));
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
				System.out.println("In Cart:");
				a.showCart();
			} else if (c == 'a') {
				System.out.print("Welcome to admin center.\n - Enter '-1' for add new product.\n - Enter ID of item to update.\n -> ");
//				System.out.print("please enter the ID of item to update : ");
				int i = sc.nextInt();
				if (i == -1){
					a.add_product();
				} else {
					a.update(i);
				}
			}else {
				try {
					int x = Integer.parseInt(String.valueOf(c));
					a.add(x-1);
				}catch(NumberFormatException e) {
					System.out.println("input is not an int value");

				}
			}
			System.out.println("_".repeat(51));

		}
//*/
		/*
		ArrayList<Product> test = a.get_nowproduct();
		a.add_product();
		ArrayList<Product> m= a.get_nowproduct();
		System.out.println(m.size());
		a.save(a.get_nowproduct());
		*/
	}

}
