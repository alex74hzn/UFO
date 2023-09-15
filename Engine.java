package com.example.interfaces.ufo;

public class Engine{
    public boolean started;

    public Engine() {
        started = false;
    }

    public boolean start(){
        return started = true;
    }
    public boolean stop(){
        return started = false;
    }
}