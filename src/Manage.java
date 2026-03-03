import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Manage {
    private static final String filePath = "data/products.txt";

    private void writeProducts(List<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(products);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private List<Product> readProducts() {
        List<Product> products = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists() || file.length() == 0) {
            return products; // Trả về danh sách rỗng nếu file chưa tồn tại hoặc trống
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            products = (List<Product>) ois.readObject();
        } catch (EOFException e) {
            // Bỏ qua, đây là trường hợp file trống, đã được xử lý ở trên
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return products;
    }

    public void addProduct(Product product) {
        List<Product> products = readProducts();
        products.add(product);
        writeProducts(products);
        System.out.println("Thêm sản phẩm thành công!");
    }

    public void displayProducts() {
        List<Product> products = readProducts();
        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm nào trong danh sách.");
            return;
        }
        System.out.println("--- DANH SÁCH SẢN PHẨM ---");
        for (Product product : products) {
            System.out.println(product);
            System.out.println("---------------------------");
        }
    }

    public void searchProduct(String id) {
        List<Product> products = readProducts();
        for (Product product : products) {
            if (product.getProductCode().equalsIgnoreCase(id)) {
                System.out.println("Đã tìm thấy sản phẩm:");
                System.out.println(product);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với mã: " + id);
    }
}