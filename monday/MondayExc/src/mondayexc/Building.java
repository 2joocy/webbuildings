
package mondayexc;


public class Building 
{
    int id;
    String address;
    int zip;
    String city;
    String contactPerson;
    String contactPhone;

    public Building(int id, String adress, int zip, String city, String contactPerson, String contactPhone) {
        this.id = id;
        this.address = adress;
        this.zip = zip;
        this.city = city;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
    }
    
    public Building(String adress, int zip, String city, String contactPerson, String contactPhone) 
    {
        this.address = adress;
        this.zip = zip;
        this.city = city;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Override
    public String toString() {
        return "Building{" + "id=" + id + ", adress=" + address + ", zip=" + zip + ", city=" + city + ", contactPerson=" + contactPerson + ", contactPhone=" + contactPhone + '}';
    }
    
}
