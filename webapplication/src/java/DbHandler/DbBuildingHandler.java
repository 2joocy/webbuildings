/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbHandler;

import entities.Building;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author William-PC
 */
public class DbBuildingHandler {

    public ArrayList getBuildings() {
        ArrayList<Building> buildingList = new ArrayList<Building>();
            try {
                Connection myConn = DBConnection.getConnection();
                String sql = "SELECT * FROM building";
                PreparedStatement prepared = myConn.prepareStatement(sql);
                ResultSet myRS = prepared.executeQuery();
                while (myRS.next()) {
                    int idBuilding = myRS.getInt("id");
                    String address = myRS.getString("address");
                    int zip = myRS.getInt("zip");
                    String city = myRS.getString("city");
                    String contactPerson = myRS.getString("contactPerson");
                    String contactPhone = myRS.getString("contactPhone");
                    Building tempB = new Building(idBuilding, address, zip, city, contactPerson, contactPhone);
                    buildingList.add(tempB);
                }
            } catch (SQLException | HeadlessException ex) {
                ex.printStackTrace();
            }
        return buildingList;
    }
    
    public String showBuildings(ArrayList<Building> list) {
        String tableData = "";

        tableData += "<table class='table table-hover'>\n"
                + "    <thead>\n"
                + "      <tr>\n"
                + "        <th>ID</th>\n"
                + "        <th>Address</th>\n"
                + "        <th>Zip</th>\n"
                + "        <th>City</th>\n"
                + "        <th>contactPerson</th>\n"
                + "        <th>contactPhone</th>\n"
                + "        <th></th>\n"
                + "      </tr>\n"
                + "    </thead>\n"
                + "    <tbody>";
        for (Building i : list) {
            tableData += "<form method='POST' action='Front'>"
                    + "<tr><td>" + i.getId() + "</td>"
                    + "<td>" + i.getAddress() + "</td>"
                    + "<td>" + i.getZip() + "</td></tr>"
                    + "<td>" + i.getCity() + "</td></tr>"
                    + "<td>" + i.getContactPerson() + "</td></tr>"
                    + "<td>" + i.getContactPhone() + "</td></tr>"
                    + "<td><input type='submit' value='Edit'></td></tr>"
                    + "<input name='buildingID' type='hidden' value=" + i.getId() + "></tr>"
                    + "<input name='method' type='hidden' value='edit1'></tr>"
                    + "</form>";
        }
        tableData += "</tbody>\n" + "</table>";
        return tableData;
    }

    public Building getBuilding(int id) {
        ArrayList<Building> buildings = getBuildings();
        for (Building b : buildings) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }
    
    public void updateDatabase(Building b) {
        String sql = "UPDATE building SET address = ?, zip = ?, city = ?, contactPerson = ?, contactPhone = ? WHERE id = " + b.getId();
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1, b.getAddress());
            prep.setInt(2, b.getZip());
            prep.setString(3, b.getCity());
            prep.setString(4, b.getContactPerson());
            prep.setString(5, b.getContactPhone());
            prep.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}