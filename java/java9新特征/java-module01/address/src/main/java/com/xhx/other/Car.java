package com.xhx.other;

public class Car {
    private String carCard;
    private String color;


    public String getCarCard() {
        return carCard;
    }

    public void setCarCard(String carCard) {
        this.carCard = carCard;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carCard='" + carCard + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
