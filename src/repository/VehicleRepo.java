package repository;

import entity.Vehicle;

import java.util.List;

public interface VehicleRepo {

    List<Vehicle> getAll();
    void save(Vehicle vehicle);
    void update(Vehicle vehicle);
    void delete(Integer id);
    Vehicle getById(Integer id);

}