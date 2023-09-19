public class Store {

	public static void main(String[] args) {
//		Store.openStore();
		Cart a = new Cart();
		a.showProduct();
		a.add(1);
		a.showCart();
		a.add(1);
		a.showCart();
		a.add(1);
		a.showCart();
		a.add(1);
		a.showCart();
		a.add(0);
		a.showCart();
		a.remove(0);
		a.showCart();
		a.remove(1);
		a.showCart();
		a.add(2);
		a.showCart();
		a.add(3);
		a.showCart();

	}

}
