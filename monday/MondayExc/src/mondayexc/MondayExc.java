
package mondayexc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MondayExc 
{
    private static Connection myConn = DBConnection.getConnection();
    private static ArrayList<Building> buildings = new ArrayList<>();
    
    public static void main(String[] args) 
    {
        getBuildings();
        for (Building b : buildings) 
        {
            System.out.println(b.toString());
        }
        
        ArrayList<Building> bingoTid = new ArrayList<>();
        bingoTid.add(new Building("Bingovej", 2600, "Bingobyen", "Farvelmanden", "900000"));
        addNewBuildings(bingoTid);
    }
    
    public static void getBuildings()
    {
        
        try
        {
            String sql = "SELECT * FROM building";
            PreparedStatement prepared = myConn.prepareStatement(sql);
            ResultSet result = prepared.executeQuery();
            while (result.next())
            {
                int id = result.getInt("id");
                String address = result.getString("address");
                int zip = result.getInt("zip");
                String city = result.getString("city");
                String contactPerson = result.getString("contactPerson");
                String contactPhone = result.getString("contactPhone");
                buildings.add(new Building(id, address, zip, city, contactPerson, contactPhone));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void addNewBuildings(ArrayList<Building> newBuildings)
    {
        for (Building b : newBuildings) 
        {
            addOneNewBuilding(b);
        }
    }
    
    public static void addOneNewBuilding(Building building)
    {
        try
        {
        String sql = "INSERT INTO building (address, zip, city, contactPerson, contactPhone)"
                    + "VALUES (?,?,?,?,?)";
        PreparedStatement prepared = myConn.prepareStatement(sql);
        prepared.setString(1, building.getAdress());
        prepared.setInt(2, building.getZip());
        prepared.setString(3, building.getCity());
        prepared.setString(4, building.getContactPerson());
        prepared.setString(5, building.getContactPhone());
        prepared.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
