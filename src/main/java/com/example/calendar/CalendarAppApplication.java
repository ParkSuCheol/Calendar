package com.example.calendar;

import com.example.calendar.event.AbstractEvent;
import com.example.calendar.event.Event;
import com.example.calendar.event.EventType;
import com.example.calendar.event.Meeting;
import com.example.calendar.event.Schedule;
import com.example.calendar.event.Todo;
import com.example.calendar.event.update.UpdateMeeting;
import com.example.calendar.reader.EventCsvReader;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CalendarAppApplication {
    public static void main(String[] args) throws IOException {
        Schedule schedule = new Schedule();

        EventCsvReader csvReader = new EventCsvReader();
        String meetingCsvPath = "/data/meeting.csv";

        List<Meeting> meetings = csvReader.readMeetings(meetingCsvPath);
        meetings.forEach(each -> schedule.add(each));

        Meeting meeting = meetings.get(0);
        meeting.print();

        System.out.println("수정 후 ...");
        meetings.get(0).validateAndUpdate(
                new UpdateMeeting(
                        "new title",
                        ZonedDateTime.now(),
                        ZonedDateTime.now().plusHours(1),
                        null,
                        "A",
                        "new agenda"
                )
        );

        meeting.delete(true);
        System.out.println("수정 후 삭제 시도");
        meetings.get(0).validateAndUpdate(
                new UpdateMeeting(
                        "new title",
                        ZonedDateTime.now(),
                        ZonedDateTime.now().plusHours(1),
                        null,
                        "B",
                        "new agenda 2"
                )
        );
        meeting.print();
    }
}
