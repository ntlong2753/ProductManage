import java.io.File;
import java.util.Scanner;

public class MainManage {
    public static void main(String[] args) {
        new File("data/product.txt").mkdirs();
        Manage manageProduct = new Manage();
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("\n--- MENU QUẢN LÝ SẢN PHẨM ---");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số.");
                continue;
            }

            switch (choice) {
                case 1:
                    addProduct(sc, manageProduct);
                    break;
                case 2:
                    manageProduct.display();
                    break;
                case 3:
                    searchProduct(sc, manageProduct);
                    break;
                case 0:
                    System.out.println("Đang thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);
        sc.close();
    }

    private static void addProduct(Scanner sc, Manage manageProduct) {
        System.out.println("\n--- THÊM SẢN PHẨM MỚI ---");
        System.out.print("Nhập mã sản phẩm: ");
        String id = sc.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String name = sc.nextLine();
        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = sc.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập mô tả: ");
        String description = sc.nextLine();

        manageProduct.addProduct(new Product(id, name, price, manufacturer, description));
        System.out.println("Đã thêm sản phẩm thành công!");
    }

    private static void searchProduct(Scanner sc, Manage manageProduct) {
        System.out.print("Nhập tên cần tìm: ");
        String keyword = sc.nextLine();

        manageProduct.searchProduct(keyword);
    }
}