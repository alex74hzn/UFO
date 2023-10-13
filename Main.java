package com.example.interfaces.ufo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Airplane plane = new Airplane("Boing 747", 4, 600, "Графитовый");
      //  double maxSpeed = plane.getMaxSpeed();
        Drone drone = new Drone("Yuneec", 28, 6, "Оранжевый");
        plane.takeOff();
        plane.fly();
        plane.moveRight();
        plane.moveRight();
        plane.land();
        System.out.println(plane);
        printProcess(plane.getProcess());

        drone.takeOff();
        drone.fly();
        drone.moveRight();
        drone.moveLeft();
        drone.land();
        System.out.println(drone);
        printProcess(drone.getProcess());

        Bird bird = new Bird("Скворец",50,35,4,"Темно-коричневый");
        bird.takeOff();
        bird.fly();
        bird.land();
        System.out.println(bird);
        printProcess(bird.getProcess());
    }
    public static void printProcess(List<String> list){
        StringBuilder process = new StringBuilder();
        for(String line:list){
            process.append(line);
        }
        System.out.println(process);
    }
}
