/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mondayexc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author William Bingo
 */
public class Handler {

    private static Connection myConn = DBConnection.getConnection();
    private ArrayList<Building> buildings = new ArrayList<>();
    private ArrayList<Room> room = new ArrayList<>();

    public void main() {
        getBuildings();
        for (Building b : buildings) {
            System.out.println(b.toString());
        }

        ArrayList<Building> bingoTid = new ArrayList<>();
        Building b;
        b = new Building("bingovej", 6666, "Den er go", "Viktor", "666666666", room);
        bingoTid.add(new Building("Bingovej", 2600, "Bingobyen", "Farvelmanden", "900000", room));
        addNewBuildings(bingoTid);
    }

    public void getBuildings() {

        try {
            String sql = "SELECT * FROM building";
            PreparedStatement prepared = myConn.prepareStatement(sql);
            ResultSet result = prepared.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String address = result.getString("address");
                int zip = result.getInt("zip");
                String city = result.getString("city");
                String contactPerson = result.getString("contactPerson");
                String contactPhone = result.getString("contactPhone");
                buildings.add(new Building(address, zip, city, contactPerson, contactPhone, room));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addNewBuildings(ArrayList<Building> newBuildings) {
        for (Building b : newBuildings) {
            addOneNewBuilding(b);
        }
    }

    public void addOneNewBuilding(Building building) {
        try {
            String sql = "INSERT INTO building (address, zip, city, contactPerson, contactPhone)"
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement prepared = myConn.prepareStatement(sql);
            prepared.setString(1, building.getAddress());
            prepared.setInt(2, building.getZip());
            prepared.setString(3, building.getCity());
            prepared.setString(4, building.getContactPerson());
            prepared.setString(5, building.getContactPhone());
            prepared.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addRoomDB(Room r) {
        try {
            String sql = "INSERT INTO room (floorNumber, roomNumber, amountWindows, squareMeters, fk_idBuilding)"
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement prepared = myConn.prepareStatement(sql);
            prepared.setInt(1, r.getFloorNumber());
            prepared.setInt(2, r.getRoomNumber());
            prepared.setInt(3, r.getAmountWindows());
            prepared.setInt(4, r.getSquareMeters());
            prepared.setInt(5, r.getFk_idBuilding());
            prepared.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
