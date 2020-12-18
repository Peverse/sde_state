package com.hz;

public class NoQuarter implements State{

    GumballMachine machine;

    public NoQuarter(GumballMachine machine){
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        machine.setState(new Quarter(machine));
        System.out.println("You inserted a quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned but there's no quarter");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }

    public String toString(){
        return "waiting for quarter";
    }
}
