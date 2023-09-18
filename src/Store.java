public class Store {
	
	public static void main(String[] args) {
		Product a = new Product();
		Product b = new Product();
		Product c = new Product();
//		System.out.println(a.get_productID());
		a.set_prodectID(3);
		b.set_prodectID(1);
		c.set_prodectID(5);
		//		System.out.println(a.get_productID());
		ArrayList<Product> languages = new ArrayList<>();
		languages.add(a);
		languages.add(b);
		// Add elements to ArrayList
//		languages.add("Java");
//		languages.add("Python");
//		languages.add("Swift");
		for(int i = 0 ; i < languages.size() ; i++){
			System.out.println("ArrayList No."+i+": " + languages.get(i).get_productID());
		}
//		languages.clear();
		 System.out.println(languages.toArray());
//		System.out.println("--0---------------");
//		for(int i = 0 ; i < languages.size() ; i++){
//			System.out.println("ArrayList No."+i+": " + languages.get(i).get_productID());
//		}
	}

}
