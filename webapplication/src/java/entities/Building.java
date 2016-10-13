/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

public class Building {

    // street address, a contact person (name and telephone)
    private int id;
    private String address;
    private int zip;
    private String city;
    private String contactPerson;
    private String contactPhone;

    public Building( int id, String address, int zip, String City, String contactPerson, String contactPhone ) {
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