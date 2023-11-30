package entity;

public class Vehicle {
    private Integer id;
    private String brand;
    private String model;
    private String productionYear;
    private String color;
    private Integer salePrice;
    private String status;
    private Integer stock;

    public Vehicle() {
    }

    public Vehicle(Integer id, String brand, String model, String productionYear, String color, Integer salePrice, String status, Integer stock) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.color = color;
        this.salePrice = salePrice;
        this.status = status;
        this.stock = stock;
    }

    public Vehicle(String brand, String model, String productionYear, String color, Integer salePrice, String status, Integer stock) {
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.color = color;
        this.salePrice = salePrice;
        this.status = status;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Vehicle {" +
                "id = " + id +
                ", brand = '" + brand + '\'' +
                ", model = '" + model + '\'' +
                ", production_year = '" + productionYear + '\'' +
                ", color = '" + color + '\'' +
                ", sale_price = " + salePrice +
                ", status = '" + status + '\'' +
                ", stock = " + stock +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}