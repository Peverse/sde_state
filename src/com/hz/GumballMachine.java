package com.hz;

public class GumballMachine {

    State state;
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            setState(new NoQuarter(this));
        }
        else{
            setState(new SoldOut(this));
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
    }

    private void dispense() {
        state.dispense();
    }

    public void refill(int numGumBalls) {
        this.count = numGumBalls;
        setState(new NoQuarter(this));
    }

    public void setState(State state){
        this.state = state;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004\n");
        result.append("Inventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\nMachine is ");
        result.append(state.toString());
        result.append("\n");
        return result.toString();
    }
}
