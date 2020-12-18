package com.hz;

public class Sold implements State{

    GumballMachine machine;

    public Sold(GumballMachine machine){
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    @Override
    public void dispense() {
        System.out.println("A gumball comes rolling out the slot");
        machine.count = machine.count - 1;
        if (machine.count == 0) {
            System.out.println("Oops, out of gumballs!");
            machine.setState(new SoldOut(machine));
        } else {
            machine.setState(new NoQuarter(machine));
        }
    }

    public String toString(){
        return "delivering a gumball";
    }
}
