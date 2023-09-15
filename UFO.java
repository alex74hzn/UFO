package com.example.interfaces.ufo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class UFO {
    private double maxSpeed;
    private String color;
    private List<String> process;

    public UFO() {
        process = new ArrayList<>();
    }
    public UFO(double maxSpeed, String color) {
        this.maxSpeed = maxSpeed;
        this.color = color;
        process = new ArrayList<>();
    }

    public List<String> getProcess() {
        return process;
    }


    public void setProcess(List<String> process) {
        this.process = process;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    public double getMaxSpeed() {
        return maxSpeed;
    }


    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void addProcess(String process){
        if(process != null){
            this.process.add(process);
        }
        else{
            throw new RuntimeException("Нельзя добавить пустую строку!");
        }
    }
}