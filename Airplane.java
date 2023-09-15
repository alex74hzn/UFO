package com.example.interfaces.ufo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Airplane extends UFO implements Manageable{
    private int numberOfEngines;
    private  final List<Engine> engines;
    private String brand;
    private TakeOffType takeOffType;


    public Airplane(String _brand, int numOfEngines, double maxSpeed, String color) {
        super(maxSpeed, color);
        this.brand = _brand;
        this.numberOfEngines = numOfEngines;
        this.takeOffType = TakeOffType.RUN_UP_TAKE_OFF;
        this.engines = new ArrayList<>();
    }

    public Airplane(){
        this.engines = new ArrayList<>();
    }

    @Override
    public void takeOff() {
        startEngine();
        moveForward();
        moveUp();
    }

    @Override
    public void fly() {
        moveLeft();
        moveForward();
        moveRight();
    }

    @Override
    public void land() {
     moveDown();
        addPprocess("Выпустить шасси! ...Касание! Тормоз.\n");
        stopEngine();
    }
    public void addPprocess(String string){
        super.addProcess(string);
    }

    @Override
    public void startEngine() {
        for(int i = 1; i <= numberOfEngines; i++) {
            Engine engine = new Engine();
            addPprocess("Запуск двигателя " + i + "...\n");
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
        int e = 1;
        for(Engine engine:engines){
            addPprocess("Остановка двигателя " + e + "...\n");
            engine.stop();
            e++;
        }
    }

    @Override
    public void moveForward() {
        boolean itsAllRight = false;
        for (Engine eng:engines) {
            if(eng.started){
                itsAllRight = true;
            }
        }
        if(itsAllRight){
            addPprocess("Разгоняемся до " + getMaxSpeed() + " км/ч\n");
        }
        else{
            addPprocess("Запусти двигатели, олух!\n");
        }
    }

    @Override
    public void moveLeft() {
        addPprocess("Крен влево\n");
    }

    @Override
    public void moveRight() {
        addPprocess("Крен вправо\n");
    }

    @Override
    public void moveUp() {
        addPprocess("Штурвал на себя - набор высоты\n");
    }

    @Override
    public void moveDown() {
        addPprocess("Штурвал от себя - снижение\n");

    }

    public int getNumberOfEngines() {
        return numberOfEngines;
    }

    public TakeOffType getTakeOffType() {
        return takeOffType;
    }

    public void setTakeOffType(TakeOffType takeOffType) {
        this.takeOffType = takeOffType;
    }
    public void setNumberOfEngines(int numberOfEngines) {
        this.numberOfEngines = numberOfEngines;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( o == null ) return false;
        if (getClass() != o.getClass())
            return false;
        Airplane other = (Airplane) o;
        return numberOfEngines == other.getNumberOfEngines() && Objects.equals(engines, other.engines) && Objects.equals(brand,
                other.getBrand()) && takeOffType == other.getTakeOffType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberOfEngines(), engines, getBrand(), getTakeOffType());
    }

    @Override
    public String toString() {
        return " Airplane: " +
                " brand: " + brand +
                "\n color = " + getColor() +
                "\n numberOfEngines = " + numberOfEngines +
                "\n takeOffType: " + takeOffType.getType() +
                "\n engines: " + engines.size() +
                "\n";
    }
}