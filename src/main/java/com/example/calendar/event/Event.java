package com.example.calendar.event;

public interface Event {
    void print();

    boolean support(EventType type);

}
