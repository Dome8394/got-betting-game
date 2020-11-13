package com.dominik.gameofthrones.entities;

public class Fraction {

    private Houses name;
    private int army = 100;
    private boolean isAlive = true;
    private Houses isLoyalTo;

    public Houses getName() {
        return name;
    }

    public void setName(Houses name) {
        this.name = name;
    }

    public int getArmy() {
        return army;
    }

    public void setArmy(int army) {
        this.army = army;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public Houses isLoyalTo() {
        return isLoyalTo;
    }

    public void swearLoyaltyTo(Houses house) {
        this.isLoyalTo = house;
    }
}
