package org.example;

public class MockEvent implements IEvent {

    private int zeitpunkt;

    public MockEvent(int zeitpunkt) {
        this.zeitpunkt = zeitpunkt;
    }

    public int getTime() {
        return zeitpunkt;
    }

    public void execute() {

    }
}
