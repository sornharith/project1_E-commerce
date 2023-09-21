import java.util.Scanner;
public class Store {

	public static void main(String[] args) {
		Cart a = new Cart();
		Scanner sc  = new Scanner(System.in);
		boolean sp = true;
		System.out.println("---------------------------------------------------");
		while(true){
			if (sp) a.showProduct(1);
			sp = true;
			System.out.print("Input your option : ");
			char c = sc.next().charAt(0);
            if (c == 'q') {
				System.out.println("Thank you");
            	break;
            } else if(c == 'c'){
				sp = false;
				System.out.println("In Cart:");
				a.showCart();
			} else if (c == 'a') {
				System.out.print("please enter the ID of item to update : ");
				int i = sc.nextInt();
				a.update(i);
			}else {
				try {
					int x = Integer.parseInt(String.valueOf(c));
					a.add(x-1);
				}catch(NumberFormatException e) {
					System.out.println("input is not an int value");

				}
			}
			System.out.println("---------------------------------------------------");
		}


	}

}
