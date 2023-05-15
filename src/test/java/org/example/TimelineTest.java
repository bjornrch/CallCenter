package org.example;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TimelineTest {

    @Test
    public void addEvent() {
        IEvent mockEvent = new MockEvent(0);
        Timeline timeline = new Timeline();
        timeline.add(mockEvent);
        assertEquals(timeline.next(), mockEvent);
    }


    @Test
    public void addEventWithNegativeTime() {
        IEvent mockEvent = new MockEvent(-1);
        Timeline timeline = new Timeline();
        assertThrows(PastEventException.class, () -> timeline.add(mockEvent));

    }

    @Test
    public void addTwoEventsInIncorrectOrder() {
        IEvent mockEvent = new MockEvent(10);
        IEvent mockEvent2 = new MockEvent(5);
        Timeline timeline = new Timeline();
        timeline.add(mockEvent);
        timeline.next();
        assertThrows(PastEventException.class, () -> timeline.add(mockEvent2));
    }

    @Test
    public void addTwoEventsInCorrectOrder() {
        IEvent mockEvent = new MockEvent(5);
        IEvent mockEvent2 = new MockEvent(10);
        Timeline timeline = new Timeline();
        timeline.add(mockEvent);
        timeline.next();
        timeline.add(mockEvent2);
        assertEquals(timeline.next(), mockEvent2);
    }


}
