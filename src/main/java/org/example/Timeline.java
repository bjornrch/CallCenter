package org.example;

import java.util.ArrayList;

public class Timeline {

    private ArrayList<IEvent> backlog;

    public Timeline() {
        backlog = new ArrayList<>();
    }

    public void add(IEvent event) {
        if (event.getTime() < 0) {
            throw new PastEventException("Time has to be greater than 0");
        } else if (!backlog.isEmpty() && event.getTime() < backlog.get(backlog.size() - 1).getTime()) {

            throw new PastEventException("Time has to be greater than 0");
        }
        backlog.add(event);
    }

    public IEvent next() {
        return backlog.get(backlog.size() - 1);
    }
}
