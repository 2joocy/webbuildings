/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;

public class Building {

    // street address, a contact person (name and telephone)
    private int id;
    private String address;
    private int zip;
    private String city;
    private String contactPerson;
    private String contactPhone;
    private ArrayList<Room> room = new ArrayList<Room>();

    public Building( int id, String address, int zip, String City, String contactPerson, String contactPhone, ArrayList<Room> tempList) {
        this.id = id;
        this.address = address;
        this.zip = zip;
        this.city = City;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
        this.room = tempList;
    }

    public Building( int id, String address, int zip, String City, String contactPerson, String contactPhone) {
        this.id = id;
        this.address = address;
        this.zip = zip;
        this.city = City;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
    }

    @Override
    public String toString() {
        return "Building( " + address + ", " + zip + ", " + city + ", "
                + contactPerson + ", " + contactPhone + " )";
    }

    public int getId() {
        return id;
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
            room.remove(count);
            return "Room was successfully removed!";
            }
            
            return "Room was not found!";
        }
        
        return "";
    }
    
    public int getAmountOfRooms(){
        return room.size();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

}
