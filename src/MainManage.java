import java.io.File;
import java.util.Scanner;

public class MainManage {
    public static void main(String[] args) {
        // Đảm bảo thư mục 'data' tồn tại để tránh lỗi FileNotFoundException
        new File("data/product.txt").mkdirs();

        Manage manage = new Manage();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("\n--- MENU QUẢN LÝ SẢN PHẨM ---");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số.");
                continue;
            }

            switch (choice) {
                case 1:
                    addProduct(scanner, manage);
                    break;
                case 2:
                    manage.displayProducts();
                    break;
                case 3:
                    searchProduct(scanner, manage);
                    break;
                case 0:
                    System.out.println("Đang thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void addProduct(Scanner scanner, Manage manage) {
        System.out.println("\n--- THÊM SẢN PHẨM MỚI ---");
        System.out.print("Nhập mã sản phẩm: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();

        Product product = new Product(id, name, manufacturer, price, description);
        manage.addProduct(product);
    }

    private static void searchProduct(Scanner scanner, Manage manage) {
        System.out.print("\nNhập mã sản phẩm cần tìm: ");
        String id = scanner.nextLine();
        manage.searchProduct(id);
    }
}
