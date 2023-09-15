package com.example.interfaces.ufo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Drone extends UFO implements Manageable{
    private int numberOfEngines;
    private String brand;
    private TakeOffType takeOffType;
    private  final List<Engine> engines;

    public Drone(String brand, double maxSpeed, int numberOfEngines, String color) {
        super(maxSpeed, color);
        this.brand = brand;
        this.numberOfEngines = numberOfEngines;
        this.takeOffType = TakeOffType.VERTICAL_TAKE_OFF;
        this.engines = new ArrayList<>();
    }
    public Drone(){
        this.engines = new ArrayList<>();
    }
    @Override
    public void takeOff() {
        startEngine();
        moveUp();
    }

    @Override
    public void fly() {
        moveForward();
    }

    @Override
    public void land() {
        moveDown();
        addPprocess("Посадка...\n");
        stopEngine();
    }

    @Override
    public void startEngine() {

        for(int i = 1; i <= numberOfEngines; i++) {
            Engine engine = new Engine();
            addPprocess("Запуск " + i + " двигателя...\n");
            engine.start();

            if(engine.started){
                addPprocess("Двигатель " + i + " запущен!\n");
            }else{
                throw new RuntimeException("Чё-то не запускается...???");
            }
            engines.add(engine);
        }
    }

    @Override
    public void stopEngine() {
        for(int i = 1; i <= this.engines.size(); i++){
            addPprocess("Двигатель " + i + " остановлен.\n");
            this.engines.get(i - 1).stop();
        }
    }

    @Override
    public void moveForward() {
        addPprocess("Движенеие вперед\n");
    }

    @Override
    public void moveLeft() {
        addPprocess("Перемещение влево\n");
    }

    @Override
    public void moveRight() {
        addPprocess("Перемещение вправо\n");
    }

    @Override
    public void moveUp() {
        addPprocess("Поднимаемся вверх...\n");
    }

    @Override
    public void moveDown() {
        addPprocess("Опускаемся вниз...\n");
    }
    public void addPprocess(String string){
        super.addProcess(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( o == null ) return false;
        if (getClass() != o.getClass())
            return false;
        Drone drone = (Drone)o;
        return numberOfEngines == drone.numberOfEngines && Objects.equals(brand, drone.brand) && takeOffType == drone.takeOffType && Objects.equals(engines, drone.engines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfEngines, brand, takeOffType, engines);
    }

    @Override
    public String toString() {
        return " Drone: " +
                "color = " + getColor() +
                "\n numberOfEngines = " + this.numberOfEngines +
                "\n brand: " + this.brand +
                "\n takeOffType: " + this.takeOffType.getType() +
                "\n engines: " + this.engines.size() +
                "\n" ;
    }
}