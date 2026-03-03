public class Product {
    private String productCode;
    private String productName;
    private int price;
    private String manufacturer;
    private String description;

    public Product(String id, String name, String manufacturer, double price, String description) {

    }

    public Product(String productCode, String productName,
                   int price, String manufacturer,
                   String description) {
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.manufacturer = manufacturer;
        this.description = description;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Mã sản phẩm: " + productCode + "\n" +
                "Tên sản phẩm: " + productName + "\n" +
                "Hãng sản xuất: " + manufacturer + "\n" +
                "Giá: " + String.format("%,.0f", price) + " VND\n" +
                "Mô tả: " + description;
    }
}
