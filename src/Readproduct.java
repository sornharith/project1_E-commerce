import java.io.*;
import java.nio.file.Paths;

public class Readproduct {

    public static final String PATH = Paths.get("").toAbsolutePath().toString()
            + File.separator + "data" + File.separator ;
    String line = "";
    private final ArrayList<Product> product = new ArrayList<>();
    int count = 0;
    public Readproduct() {
        count = 0;
        read_add();
    }
    public Readproduct(int i,ArrayList<Product> got) {
        update_csv(got);
    }


    private void read_add(){ // read file from .csv data and adding it to the arraylist product
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH + "Stock.csv"));
            while((line = br.readLine()) != null){
                if (count == 0) {
                    count = 1;
                } else {
                    String[] value = line.split(",");
//                    System.out.println(Arrays.toString(value));
                    product.add(new Product(value[0],value[1],Float.parseFloat(value[2]),Integer.parseInt(value[3])));
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update_csv(ArrayList<Product> save){
        StringBuilder write = new StringBuilder();
        write.append("Name").append(",").append("Description").append(",").append("Price").append(",").append("Stock").append("\n");
//        ArrayList<Product> save = new Cart().get_nowproduct();
        System.out.println(save.size());
        for (int i = 0 ; i < save.size() ; i++){
            write.append(save.get(i).get_name()).append(",").append(save.get(i).get_description()).append(",").append(save.get(i).get_price()).append(",").append(save.get(i).get_stock()).append("\n");
            System.out.println(write.toString());
        }
        try(FileWriter writer = new FileWriter(PATH + "Stock.csv")) {
            writer.write(write.toString());
            System.out.println("Complete Update data");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Product> get_p(){
        return product;
    }
}
