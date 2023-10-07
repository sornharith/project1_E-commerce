import java.io.*;
import java.nio.file.Paths;

public class Manageproduct {

    public static final String PATH = Paths.get("").toAbsolutePath().toString()
           + File.separator + "data" + File.separator ; // For finding the Path of the data folder that contain .CSV
    String line = "";
    private final ArrayList<Product> product = new ArrayList<>();
    int count = 0;
    public Manageproduct() {
        count = 0;
        read_add();
    }
    public Manageproduct(int i, ArrayList<Product> got) {
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
                    product.add(new Product(value[0].strip(),value[1].strip(),value[2].strip(),Float.parseFloat(value[3].strip()),Integer.parseInt(value[4].strip())));
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update_csv(ArrayList<Product> save){ // this is a method to write the product after update back to .CSV file
        StringBuilder write = new StringBuilder();
        write.append("ID").append(",").append("Name").append(",").append("Description").append(",").append("Price").append(",").append("Stock").append("\n");
        for (int i = 0 ; i < save.size() ; i++){ // this loop is for convert the arraylist of product back to .CSV file
            write.append(save.get(i).get_productID()).append(",").append(save.get(i).get_name()).append(",").append(save.get(i).get_description()).append(",").append(save.get(i).get_price()).append(",").append(save.get(i).get_stock()).append("\n");
        }
        try(FileWriter writer = new FileWriter(PATH + "Stock.csv")) { // set the path and file name back to the same file for update data inside
            writer.write(write.toString());
            System.out.println("\nComplete Update data.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Product> get_p(){
        return product;
    }
}
