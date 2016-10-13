/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author William Bingo
 */
public class Room {
    private int id, floorNumber, roomNumber, amountWindows, squareMeters, fk_idBuilding;


    public Room(int id, int floorNumber, int roomNumber, int amountWindows, int squareMeters, int fk_idBuilding){
        this.id = id;
        this.floorNumber = floorNumber;
        this.roomNumber = roomNumber;
        this.amountWindows = amountWindows;
        this.squareMeters = squareMeters;
        this.fk_idBuilding = fk_idBuilding;
    }
    
    public String toString(){
        return id + " - " + floorNumber + " - " + roomNumber + " - " + amountWindows + " - " + squareMeters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getAmountWindows() {
        return amountWindows;
    }

    public void setAmountWindows(int amountWindows) {
        this.amountWindows = amountWindows;
    }

    public int getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(int squareMeters) {
        this.squareMeters = squareMeters;
    }

    public int getFk_idBuilding() {
        return fk_idBuilding;
    }

    public void setFk_idBuilding(int fk_idBuilding) {
        this.fk_idBuilding = fk_idBuilding;
    }
    
    
}
