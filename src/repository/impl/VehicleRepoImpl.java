package repository.impl;

import entity.Vehicle;
import repository.VehicleRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepoImpl implements VehicleRepo {

    Connection con;

    public VehicleRepoImpl(Connection con) {
        this.con = con;
    }

    @Override
    public List<Vehicle> getAll() {
        List<Vehicle> data = new ArrayList<>();
        try {
            PreparedStatement pr = con.prepareStatement("SELECT * FROM m_vehicle");
            ResultSet result = pr.executeQuery();
            while (result.next()) {
                Integer id = result.getInt("id");
                String brand = result.getString("brand");
                String model = result.getString("model");
                String year = result.getString("production_year");
                String color = result.getString("color");
                Integer salePrice = result.getInt("sale_price");
                String status = result.getString("status");
                Integer stock = result.getInt("stock");

                data.add(new Vehicle(id, brand, model, year, color, salePrice, status, stock));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    @Override
    public void save(Vehicle vehicle) {
        try {
            PreparedStatement pr = con.prepareStatement("INSERT INTO m_vehicle (brand, model, production_year, color, sale_price, status, stock) VALUES (?, ?, ?, ?, ?, ?::status_type, ?)");
            pr.setString(1, vehicle.getBrand());
            pr.setString(2, vehicle.getModel());
            pr.setString(3, vehicle.getProductionYear());
            pr.setString(4, vehicle.getColor());
            pr.setInt(5, vehicle.getSalePrice());
            pr.setString(6, vehicle.getStatus());
            pr.setInt(7, vehicle.getStock());
            pr.executeUpdate();
            System.out.println("INSERT 0 1");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Vehicle vehicle) {
        try {
            PreparedStatement pr = con.prepareStatement("UPDATE m_vehicle SET brand = ?, model = ?, production_year = ?, color = ?, sale_price = ?, status = ?::status_type, stock = ? WHERE id = ?");
            pr.setString(1, vehicle.getBrand());
            pr.setString(2, vehicle.getModel());
            pr.setString(3, vehicle.getProductionYear());
            pr.setString(4, vehicle.getColor());
            pr.setInt(5, vehicle.getSalePrice());
            pr.setString(6, vehicle.getStatus());
            pr.setInt(7, vehicle.getStock());
            pr.setInt(8, vehicle.getId());
            pr.executeUpdate();
            System.out.println("UPDATE 0 1");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            PreparedStatement pr = con.prepareStatement("DELETE FROM m_vehicle WHERE id = ?");
            pr.setInt(1, id);
            pr.executeUpdate();
            System.out.println("DELETE 0 1");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Vehicle getById(Integer id) {
        try {
            PreparedStatement pr = con.prepareStatement("SELECT * FROM m_vehicle WHERE id = ?");
            pr.setInt(1, id);
            ResultSet result = pr.executeQuery();
            while (result.next()) {
                return new Vehicle(
                        result.getInt("id"),
                        result.getString("brand"),
                        result.getString("model"),
                        result.getString("production_year"),
                        result.getString("color"),
                        result.getInt("sale_price"),
                        result.getString("status"),
                        result.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}