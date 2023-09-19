public class Cart {
    private final ArrayList<Product> product;
    private final LinkedList<Product> cart;
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

            } else {
                Product a = product.get(n);
                int c = a.getCount();
                a.setCount(c + 1);
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
    public void showProduct(){
        for(int i = 0 ; i < product.size() ; i++) {
            System.out.println(product.get(i).toString());
        }
    }

    public void showCart(){
        System.out.println("in cart:");
        for (int i = 0 ; i< cart.size() ; i++){
            System.out.println(cart.get(i).toCart());
        }
    }


}
