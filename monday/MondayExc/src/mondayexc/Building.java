/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mondayexc;

import java.util.ArrayList;

public class Building {

    // street address, a contact person (name and telephone)
    private int id;
    private String address;
    private int zip;
    private String city;
    private String contactPerson;
    private String contactPhone;
    private ArrayList<Room> room; 

    public Building(String address, int zip, String City, String contactPerson, String contactPhone, ArrayList<Room> tempList) {
        this.address = address;
        this.zip = zip;
        this.city = City;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
        this.room = tempList;
    }

    @Override
    public String toString() {
        return "Building( " + address + ", " + zip + ", " + city + ", "
                + contactPerson + ", " + contactPhone + " )";
    }

    public String getAddress() {
        return address;
    }

    public int getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }
    
    public void addRoom(Room tempRoom){
        this.room.add(tempRoom);
    }
    
    public String deleteRoom(int id){
        int count = 0;
        for(Room r : room){
            count++;
            if(r.getId() == id){
            room.remove(r);
            return "Room was successfully removed!";
            }
            
        }
        
        return "Room was not found!";
    }
    
    public int getAmountOfRooms(){
        return room.size();
    }

}