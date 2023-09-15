package com.example.interfaces.ufo;

public interface Manageable extends Flyable{
   boolean MANAGED_BY_HUMAN = true;
   void startEngine();
    void stopEngine();
    void moveForward();
    void moveLeft();
    void moveRight();
    void moveUp();
    void moveDown();

}