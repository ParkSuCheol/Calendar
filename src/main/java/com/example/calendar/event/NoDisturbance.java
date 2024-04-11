package com.example.calendar.event;

import com.example.calendar.event.update.AbstractAuditableEvent;
import java.time.ZonedDateTime;

public class NoDisturbance extends AbstractEvent{

    public NoDisturbance(int id, String title,
                       ZonedDateTime startAt, ZonedDateTime endAt){
        super(id, title, startAt, endAt);
    }
    @Override
    public void print(){
        System.out.printf("[회의] %s : %s%n", getTitle());
    }

    @Override
    public boolean support(EventType type) {
        return type == EventType.NO_DISTURBANCE;
    }

    @Override
    protected void update(AbstractAuditableEvent update) {

    }
}
