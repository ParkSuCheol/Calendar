package com.example.calendar;

import com.example.calendar.event.AbstractEvent;
import com.example.calendar.event.Event;
import com.example.calendar.event.EventType;
import com.example.calendar.event.Meeting;
import com.example.calendar.event.Schedule;
import com.example.calendar.event.Todo;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CalendarAppApplication {
    public static void main(String[] args) {
        Schedule schedule = new Schedule();

        HashSet<String> participants = new HashSet<>();
        participants.add("danny.kim");

        Meeting meeting1 = new Meeting(
                1, "meeting1",
                ZonedDateTime.now(), ZonedDateTime.now().plusHours(1),
                participants,"meetingRoomA", "스터디"
        );

        schedule.add(meeting1);

        Todo todo1 = new Todo(
                2, "todo1",
                ZonedDateTime.now().plusHours(3), ZonedDateTime.now().plusHours(4),
                "할 일 적기"
        );

        Todo todo2 = new Todo(
                3, "todo2",
                ZonedDateTime.now().plusHours(6), ZonedDateTime.now().plusHours(8),
                "할 일 적기"
        );

        schedule.add(todo1);

        //schedule.printBy(EventType.TO_DO);
        schedule.printAll();
    }
}
