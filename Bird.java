package com.example.interfaces.ufo;

import java.util.Objects;

public class Bird extends UFO implements Bionic{
    private double wingspan;
    private double flapsPerSecond;
    private TakeOffType takeOffType;
    private String  species;


    public Bird(String  species, double maxSpeed, double wingspan, double flapsPerSecond, String color) {
        super(maxSpeed, color);
        this.species = species;
        this.wingspan = wingspan;
        this.flapsPerSecond = flapsPerSecond;
        this.takeOffType= TakeOffType.TAKE_OFF_FROM_SPOT;
    }
    public Bird(){

    }
    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    public double getFlapsPerSecond() {
        return flapsPerSecond;
    }

    public void setFlapsPerSecond(double flapsPerSecond) {
        this.flapsPerSecond = flapsPerSecond;
    }
    public TakeOffType getTakeOffType() {
        return takeOffType;
    }

    public void setTakeOffType(TakeOffType takeOffType) {
        this.takeOffType = takeOffType;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }



    @Override
    public void spreadWings() {
        addProcess("Расправить крылья на все свои " + this.wingspan + " см.\n");
    }

    @Override
    public void flapWings() {
        addProcess("Взмахи крыльями с частотой " + this.flapsPerSecond + " раз в секунду.\n");
    }

    @Override
    public void foldWings() {
        addProcess("Сложить крылья.\n");
    }

    @Override
    public void takeOff() {
        spreadWings();
        flapWings();
    }

    @Override
    public void fly() {
        flapWings();
        addProcess("Лечу туда, не знаю куда!\n");
    }

    @Override
    public void land() {
        addProcess("Замедлиться, встать на поверхность.\n");
        foldWings();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( o == null ) return false;
        if (getClass() != o.getClass())
            return false;
        Bird other = (Bird) o;
        return Double.compare(other.getWingspan(), wingspan) == 0 && Double.compare(other.getFlapsPerSecond(),
                flapsPerSecond) == 0 && takeOffType == other.getTakeOffType() && Objects.equals(species,
                other.getSpecies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWingspan(), getFlapsPerSecond(), getTakeOffType(), getSpecies());
    }

    @Override
    public String toString() {
        return " Bird:" +
                "\n вид: " + species +
                "\n wingspan: " + wingspan +
                "\n flapsPerSecond: " + flapsPerSecond +
                "\n color:= " + getColor() +
                "\n takeOffType: " + takeOffType.getType() +
                "\n " ;
    }
}