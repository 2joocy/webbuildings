/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbHandler;

import entities.Building;
import entities.Room;
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
        ArrayList<Room> roomList = new ArrayList<Room>();

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

                Building tempB = new Building(idBuilding,address, zip, city, contactPerson, contactPhone, roomList);
                buildingList.add(tempB);
            }
        } catch (SQLException | HeadlessException ex) {

        }

        return buildingList;
    }
    
    
    
    public String showBuildings(ArrayList<Building> list) {
        String tableData = null;

        tableData += "<table class='table table-hover'>\n"
                + "    <thead>\n"
                + "      <tr>\n"
                + "        <th>ID</th>\n"
                + "        <th>Address</th>\n"
                + "        <th>Zip</th>\n"
                + "        <th>City</th>\n"
                + "        <th>contactPerson</th>\n"
                + "        <th>contactPhone</th>\n"
                + "      </tr>\n"
                + "    </thead>\n"
                + "    <tbody>";
        for (Building i : list) {

            tableData += "<tr><td>" + i.getId() + "</td>"
                    + "<td>" + i.getAddress() + "</td>"
                    + "<td>" + i.getZip() + "</td></tr>"
                    + "<td>" + i.getCity() + "</td></tr>"
                    + "<td>" + i.getContactPerson() + "</td></tr>"
                    + "<td>" + i.getContactPhone() + "</td></tr>";

        }
        tableData += "</tbody>\n"
                + "  </table>";

        return tableData;
    }

}
