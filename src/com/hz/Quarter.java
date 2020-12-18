package com.hz;

public class Quarter implements State{

    GumballMachine machine;

    public Quarter(GumballMachine machine){
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        machine.setState(new NoQuarter(machine));
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        machine.setState(new Sold(machine));
        machine.state.dispense();
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    public String toString(){
        return "waiting for turn of crank";
    }
}
