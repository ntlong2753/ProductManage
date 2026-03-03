import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Manage {
    private static final String filePath = "data/products.txt";
    private List<Product> productList = new ArrayList<>();

    public static void writeToFile(String path, List<Product> productList) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
            oos.close();
            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readDataFromFile (String path) {
        List<Product> productList = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            productList = (List<Product>) ois.readObject();
            ois.close();
            fis.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void display() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }

        for (Product p : productList) {
            System.out.println(p);
        }
    }

    public void searchProduct(String keyword) {
        boolean found = false;
        for (Product p : productList) {
            if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào!");
        }
    }

}