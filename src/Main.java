import entity.Vehicle;
import repository.impl.VehicleRepoImpl;
import util.DbConnector;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        DbConnector dbConnector = new DbConnector();
        Connection con = dbConnector.startConnect();
        VehicleRepoImpl repo = new VehicleRepoImpl(con);

//        To display all data in m_vehicle table
//        repo.getAll(); // 1
        for(Vehicle v : repo.getAll()){ // 2
            System.out.println(v);
        }

//        To add and save 1 data in m_vehicle table
        repo.save(new Vehicle("H", "Ionic", "2022", "Hijau", 280000000, "NEW", 10));

//        To change 1 data in m_vehicle table
        repo.update(new Vehicle(24, "Hyundai", "Ionic 6", "2023", "Hitam", 300000000, "NEW", 10));

//        To delete data in m_vehicle table using id
        repo.delete(24);

//        To get data in m_vehicle table using id
        System.out.println(repo.getById(23));

    }
}